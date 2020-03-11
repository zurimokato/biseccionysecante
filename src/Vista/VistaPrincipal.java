/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Vista.BisecWindows;

/**
 *
 * @author Ingenieros
 */
public class VistaPrincipal extends JFrame {

    private JLabel titulo = new JLabel();
    private JButton biseccion = new JButton();
    private JButton newtonRapson = new JButton();
    private JButton secante = new JButton();
    private JButton mltR = new JButton();

    public VistaPrincipal() {

        setTitle("Analisis Numerico Aproximación de raices");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
        setBounds(50, 50, 800, 400);

        JPanel setpanel = new JPanel();
        setpanel.setBounds(10, 11, 785, 365);
        getContentPane().add(setpanel);
        setpanel.setLayout(null);

        titulo.setText("An\u00e1lisis Num\u00e9rico");
        titulo.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 90, 799, titulo.getPreferredSize().height);
        setpanel.add(titulo);

        //---- button1 ----
        biseccion.setText("Bisecci\u00f3n");
        setpanel.add(biseccion);
        biseccion.setBounds(30, 220, 159, 37);
        
        biseccion.addActionListener((ActionEvent e) -> {
            BisecWindows bisec=new BisecWindows();
            bisec.setVisible(true);
        });

       
        
         //---- button4 ----
        mltR.setText("Raiz Multiple"); 
        setpanel.add(mltR);
        mltR.setBounds(590, 220, 159, 37);
        
        mltR.addActionListener((ActionEvent e) -> {
            RaicesMultiplesWindows sec= new RaicesMultiplesWindows();
            sec.setVisible(true);
        });
       
        

    }

}
