package Vista;

import Logica.Biseccion;
import Logica.Funcion;
import Logica.RegistroBisec;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ingenieros
 */
public class BisecWindows extends JFrame {

    private JTextField limit1;
    private JTextField limit2;
    private JTextField exp;
    private JTextField txt_parameter;
    private double limite1, limite2;
    private JTable table;
    private int seleccion;
    private String s;
    private Funcion funcion;

    public BisecWindows() {

        setTitle("Biseccion");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
        setBounds(50, 50, 800, 400);

        JPanel setpanel = new JPanel();
        setpanel.setBounds(10, 11, 165, 291);
        getContentPane().add(setpanel);
        setpanel.setLayout(null);

        JButton randomizer1 = new JButton("New button");
        randomizer1.addActionListener((ActionEvent e) -> {
            limit1.setText(Integer.toString((int) (Math.random() * 100) + 1));
        });
        randomizer1.setBounds(133, 56, 22, 23);
        setpanel.add(randomizer1);

        JLabel text = new JLabel("Escriba Una exprecion");
        text.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
        text.setBounds(10, 0, 180, 14);
        setpanel.add(text);
        exp = new JTextField();
        exp.setBounds(13, 16, 110, 20);
        setpanel.add(exp);
        exp.setColumns(10);

        limit1 = new JTextField();
        limit1.setBounds(13, 56, 110, 20);
        setpanel.add(limit1);
        limit1.setColumns(10);

        JLabel lblLimit1 = new JLabel("Limite 1");
        lblLimit1.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        lblLimit1.setBounds(10, 36, 46, 14);
        setpanel.add(lblLimit1);

        limit2 = new JTextField();
        limit2.setBounds(13, 106, 110, 20);
        setpanel.add(limit2);
        limit2.setColumns(10);

        JLabel lblLimit2 = new JLabel("Limite 2");
        lblLimit2.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        lblLimit2.setBounds(10, 86, 46, 14);
        setpanel.add(lblLimit2);

        txt_parameter = new JTextField();
        txt_parameter.setBounds(13, 240, 110, 20);
        setpanel.add(txt_parameter);
        txt_parameter.setColumns(10);
        txt_parameter.setVisible(false);

        JButton randomizer2 = new JButton("rndm1");
        randomizer2.addActionListener((ActionEvent e) -> {
            limit2.setText(Integer.toString((int) (Math.random() * 100) + 1));
        });
        randomizer2.setBounds(133, 106, 22, 23);
        setpanel.add(randomizer2);

        final JLabel lbl_parameter = new JLabel("Num iteraciones");
        lbl_parameter.setVisible(false);
        lbl_parameter.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        lbl_parameter.setBounds(13, 225, 142, 14);
        setpanel.add(lbl_parameter);

        JRadioButton sl_iterations = new JRadioButton("Iteraciones");
        sl_iterations.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        sl_iterations.addActionListener((ActionEvent e) -> {
            txt_parameter.setVisible(true);
            seleccion = 1;
            lbl_parameter.setVisible(true);
            lbl_parameter.setText("Iteraciones");
        });
        sl_iterations.setBounds(13, 133, 109, 23);
        setpanel.add(sl_iterations);

        JRadioButton sl_relerr = new JRadioButton("Error relativo");
        sl_relerr.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        sl_relerr.addActionListener((ActionEvent arg0) -> {
            txt_parameter.setVisible(true);
            lbl_parameter.setVisible(true);
            seleccion = 2;
            lbl_parameter.setText("Error deseado");
        });
        sl_relerr.setBounds(14, 153, 109, 23);
        setpanel.add(sl_relerr);

        JRadioButton sl_dec = new JRadioButton("Decimales correctos");
        sl_dec.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
        sl_dec.addActionListener((ActionEvent arg0) -> {
            txt_parameter.setVisible(true);
            lbl_parameter.setVisible(true);
            seleccion = 3;
            lbl_parameter.setText("Decimales correctos");
        });
        sl_dec.setBounds(14, 173, 109, 23);
        setpanel.add(sl_dec);

        ButtonGroup select = new ButtonGroup();
        select.add(sl_iterations);
        select.add(sl_relerr);
        select.add(sl_dec);

        JButton btnStart = new JButton("Calcular");
        btnStart.setBounds(43, 313, 89, 23);
        getContentPane().add(btnStart);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(185, 11, 599, 291);
        getContentPane().add(scrollPane);

        final DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Iteracion");
        model.addColumn("Limite menor");
        model.addColumn("Limite mayor");
        model.addColumn("Nuevo Limite");
        model.addColumn("Resultado de la funcion");
        model.addColumn("Error Absoluto");
        model.addColumn("Error Relative");
        table.getColumnModel().getColumn(3).setPreferredWidth(79);
        scrollPane.setViewportView(table);

        final RegistroBisec regs = new RegistroBisec();
        btnStart.addActionListener((ActionEvent e) -> {
            if (exp.getText().length() == 0 || limit1.getText().length() == 0
                    || limit2.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "No puedes dejar los campos vacios");
                
            } else {
                s = exp.getText();
                limite1 = Float.parseFloat(limit1.getText());
                limite2 = Float.parseFloat(limit2.getText());
                funcion = new Funcion(s);
                final Biseccion bisec = new Biseccion(funcion);
                
                if (limite1 < limite2) {
                    regs.setLimiteMenor(limite1);
                    regs.setLimiteMayor(limite2);
                } else {
                    regs.setLimiteMayor(limite1);
                    regs.setLimiteMenor(limite2);
                }
                
                if(txt_parameter.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "No puedes dejar los campos vacios");
                }else{
                    switch (seleccion) {
                        case 1:
                            
                            int iter = Integer.parseInt(txt_parameter.getText());
                            bisec.iteraciones(iter, regs, model);
                            break;
                        case 2:
                            
                            double errRel = Double.parseDouble(txt_parameter.getText());
                            bisec.errResult(errRel, regs, model);
                            break;
                        case 3:
                            double dec = Integer.parseInt(txt_parameter.getText());
                            
                            int numI = bisec.numIteraciones(dec);
                            JOptionPane.showMessageDialog(null, "Numero de iteraciones ideal: " + numI);
                            //bisec.funResult(res, regs, model);
                            break;
                    }
                    
                }

                
                
            }
        });

    }

}
