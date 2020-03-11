/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import Logica.Funcion;



/**
 *
 * @author Ingenieros
 */
public class PruebaGrafica{

   
    public static void main(String[] args) {
        String exp="x^5";
        Funcion fun=new Funcion(exp);
        
        System.out.println("primera derivada: "+fun.derivate(1.0));
         System.out.println("segunda derivada: "+fun.secondDerivate(1.0));
    }
    
}