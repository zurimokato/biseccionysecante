
package Logica;


import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ingenieros
 */
public class Biseccion {

    private double valorx, limit1, bisec, limit2, errAbs, errRel, errorel;
    
    private final Funcion fun;
    
    public  Biseccion(Funcion fun) {
        this.fun=fun;
    }

    public double valorx(double valor1, double valor2) {
        return (valor1 + valor2) / 2;

    }

    public void iteraciones(int iteraciones,RegistroBisec regs,DefaultTableModel model) {
		double valory = 0;
		model.setNumRows(0);
		for(int i = 0;i < iteraciones;i++) {			
			limit1 = regs.getLimiteMenor();
			limit2 = regs.getLimiteMayor();
			valorx = valorx(limit1,limit2);
			bisec = fun.eval(valorx);			
			errAbs = Math.abs(errorAbs(valorx,valory));
			model.addRow(new Object[] {
					i+1,limit1,limit2,valorx,bisec,errAbs,errorRel(errAbs,valorx)
					});
			if(bisec > 0) {
				regs.setLimiteMayor(valorx);
			}else {
				regs.setLimiteMenor(valorx);
			}	
			valory = valorx; 
		}				
	}

    public double errorAbs(double valorx, double valory) {
        return valorx - valory;

    }

    public double errorRel(double errorAbs, double valorx) {
        return errorAbs / valorx;

    }
    
    
    public int numIteraciones(double decCorrect){
        
        int numI;
        
        numI= (int) Math.ceil((decCorrect/ (Math.log(2)/Math.log(10))));
        return numI;
        
    }

   

     public void errResult(double err,RegistroBisec regs,DefaultTableModel model) {
		model.setNumRows(0);
		double valory = 0;
		int i = 0;
		do {	
			limit1 = regs.getLimiteMenor();
			limit2 = regs.getLimiteMayor();
			valorx = valorx(limit1,limit2);
			bisec = fun.eval(valorx);			
			errAbs = Math.abs(errorAbs(valorx,valory));
			errorel = errorRel(errAbs,valorx);
                       
			model.addRow(new Object[] {
					 i++,limit1,limit2,valorx,bisec,errAbs,errorel
					});
			if(bisec > 0) {
				regs.setLimiteMayor(valorx);
			}else {
				regs.setLimiteMenor(valorx);
			}	
			valory = valorx; 
		}while(err < errorel);				
	}

    public void funResult(double result,RegistroBisec regs,DefaultTableModel model) {
		model.setNumRows(0);
		double valory = 0;
		int i = 0;
		do {
			limit1 = regs.getLimiteMenor();
			limit2 = regs.getLimiteMayor();
			valorx = valorx(limit1,limit2);
			bisec = Math.abs(fun.eval(valorx));
			errAbs = Math.abs(errorAbs(valorx,valory));
			errorel = errorRel(errAbs,valorx);
			model.addRow(new Object[] {
					i+1,limit1,limit2,valorx,Math.abs(bisec),errAbs,errorel
					});
			if(bisec > 0) {
				regs.setLimiteMayor(valorx);
			}else {
				regs.setLimiteMenor(valorx);
			}	
			valory = valorx; 
		}while(result < bisec );	
	}

}
