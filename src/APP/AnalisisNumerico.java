/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import Vista.VistaPrincipal;
import java.awt.EventQueue;

/**
 *
 * @author Ingenieros
 */
public class AnalisisNumerico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                //BisecWindows frame = new BisecWindows();
                VistaPrincipal vista =new VistaPrincipal();
                //frame.setVisible(true);
                vista.setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }
    
}
