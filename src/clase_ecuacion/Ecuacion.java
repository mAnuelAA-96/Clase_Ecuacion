
package clase_ecuacion;

import java.lang.Math;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Ecuacion {
    double discriminante = 0;
    double resultadoRaiz1 = 0;
    double resultadoRaiz2 = 0;
    boolean solucionReal = false;
    
    private double a;
    private double b;
    private double c;

    Ecuacion (double a, double b, double c) throws Exception{
        //Mediante las dos excepciones creadas aseguramos que se introduzcan datos correctos
        if (a == 0 && b == 0 && c == 0){
            throw new Exception ("El valor de 'a', 'b' y 'c' tienen que ser diferente a 0.\n");
        }
        if (a == 0){
            throw new Exception ("El valor de 'a' tiene que ser diferente a 0.\n");
        }
        
        this.a = a;
        this.b = b;
        this.c = c;
        
    }
    
    //getters
    public double getA(){
        return a;
    }
    
    public double getB(){
        return b;
    }
    
    public double getC(){
        return c;
    }
    
    public double getDiscriminante(){
        return discriminante;
    }
    
    //setters
    private void setA(double newA){
        this.a = newA;
    }
    
    private void setB(double newB){
        this.b = newB;
    }
    
    private void setC(double newC){
        this.c = newC;
    }
    
    //Obtenemos el discriminante
    private boolean tieneSolucionReal(double newA, double newB, double newC){
        a = newA;
        b = newB;
        c = newC;
        double newDiscriminante = b*b - 4*a*c;
        if (newDiscriminante >= 0){
            solucionReal = true;
            discriminante = newDiscriminante;
        }
        else if (newDiscriminante < 0){
            solucionReal = false;
            discriminante = newDiscriminante;
        }
        return solucionReal;
    }
    
    //Calculamos las dos dos soluciones por separado
    public void calcularRaiz1(double newA, double newB, double newC){
        setA(newA);
        setB(newB);
        setC(newC);
        
        // Intercalamos el método de obtención del discriminante solo en la primera raíz
        // ya que no es necesario hacerlo en las dos. En la segunda raíz solamente usamos
        // el getter del discriminante para utilizar el if correcto.
        tieneSolucionReal(getA(), getB(), getC());
        double nReal = getDiscriminante();
        if (nReal > 0){
            //ES.msgln("La ecuación tiene solución real:");
            resultadoRaiz1 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);
            //ES.msgln("Solución 1: " + (double)Math.round(resultadoRaiz1 * 100d)/100d);
        }
        if (nReal == 0){
            resultadoRaiz1 = (-b)/(2*a);
        }
        if (nReal < 0){
            //No devuelve resultadoRaiz1 por no necesitarlo en el toString
            //resultadoRaiz1 = (-b)/(2*a);
        }
    }
    
    public void calcularRaiz2(double newA, double newB, double newC){
        setA(newA);
        setB(newB);
        setC(newC);
        double nReal = getDiscriminante();
        if (nReal > 0){
            resultadoRaiz2 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
        }
        if (nReal == 0){
            resultadoRaiz2 = (-b)/(2*a);
        }
        if (nReal < 0){
            resultadoRaiz2 = b*b-4*a*c;
        }
    }
    
    
    @Override
  public String toString() {
    Locale enLocale = new Locale("en","");
    DecimalFormatSymbols otrosSimbolos = new DecimalFormatSymbols(enLocale);
    DecimalFormat df = new DecimalFormat ("0.0#", otrosSimbolos);
    String cadena = null;
    if (solucionReal == true){
        cadena = "La ecuación tiene solución real: \n" +
                df.format(a) + "x² + " + df.format(b) + "x + " + df.format(c) + " = 0\n" +
                "Solución 1 = " + df.format(resultadoRaiz1) +
                "\nSolución 2 = " + df.format(resultadoRaiz2);
    }else if (solucionReal == false){
        cadena = "La ecuación no tiene solución real: \n" +
                "Solución 1 = (-" + b + " - i√(" + (b*b - 4*a*c) + ")) / " + " 2·" + a +
                "\nSolución 2 = (-" + b + " + i√(" + (b*b - 4*a*c) + ")) / " + " 2·" + a +
                "\nParte real = -" + b + " / 2·" + a + "\nParte imaginaria = (±i√(" + resultadoRaiz2 + ")) / " +
                "2·" + a;
    }
    return cadena;
  }
    
    
    
    
    
    
    
    
    
    
    
        
        

    
}// fin class Ecuacion
