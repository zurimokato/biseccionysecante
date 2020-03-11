/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Ingenieros
 */
public class RegistroBisec {

    private double limiteMenor, limiteMayor, biseccion, errAbsol, errRel;

    private int iterations = 0;

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public RegistroBisec() {
    }

    public double getBiseccion() {
        return biseccion;
    }

    public void setBiseccion(double biseccion) {
        this.biseccion = biseccion;
    }

    public double getErrAbsol() {
        return errAbsol;
    }

    public void setErrAbsol(double errAbsol) {
        this.errAbsol = errAbsol;
    }

    public double getErrRel() {
        return errRel;
    }

    public void setErrRel(double errRel) {
        this.errRel = errRel;
    }

    public double getLimiteMenor() {
        return limiteMenor;
    }

    public void setLimiteMenor(double limiteMenor) {
        this.limiteMenor = limiteMenor;
    }

    public double getLimiteMayor() {
        return limiteMayor;
    }

    public void setLimiteMayor(double limiteMayor) {
        this.limiteMayor = limiteMayor;
    }

}
