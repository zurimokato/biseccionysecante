/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ingenieros
 */
public class RaicesMultiples {

    private int i = 0;
    private double e = 10;
    private final ArrayList<Double> t = new ArrayList<>();
    private final Funcion fun;

    public RaicesMultiples(double aprox_i, Funcion fun) {
        t.add(0, aprox_i);
        this.fun = fun;
        System.out.println("func"+fun.toString());
    
    }

    public double errRel(int i) {
        double e;
        e = Math.abs((t.get(i + 1) - t.get(i)) / t.get(i + 1));
        e = e * 100;
        return e;
    }

    public double errAbs(int i) {
        double e;
        e = Math.abs((t.get(i + 1) - t.get(i)) / t.get(i + 1));
        e = e * 100;
        return e;
    }

    public void calcRaiz(DefaultTableModel model, int numI) {
        i = 0;
        model.setNumRows(0);
        double next;

        while (numI > i) {
            double g = fun.eval(t.get(i));
            double h = fun.derivate(t.get(i));
            double k = fun.secondDerivate(t.get(i));

            next = t.get(i) - (g * h / (Math.pow(h, 2) - (g * k)));

            t.add(i + 1, next);
            e = errRel(i);
            model.addRow(new Object[]{i, t.get(i), g, h, k, e});
            i++;
        }

    }

    public void calcRaizErr(DefaultTableModel model, double err) {
        i = 0;
        model.setNumRows(0);
        double next;
        while (e > err) {
            double g = fun.derivate(t.get(i));
            double h = fun.derivate(t.get(i));
            double k = fun.secondDerivate(t.get(i));

            next = t.get(i) - (g * h / (Math.pow(h, 2) - (g * k)));
            t.add(i + 1, next);
            e = errRel(i);
            model.addRow(new Object[]{i, t.get(i), g, h, k, e});
            i++;
        }

    }
}
