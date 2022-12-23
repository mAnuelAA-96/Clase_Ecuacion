
package clase_ecuacion;

public class Clase_Ecuacion {

    public static void main(String[] args) {
        
        Ecuacion x = null;
        
        //Mediante bucle do while aseguramos que la variable x no sea null
        do{
            try{
                double a = ES.leeDecimal("Introduce el valor de a: ");
                double b = ES.leeDecimal("Introduce el valor de b: ");
                double c = ES.leeDecimal("Introduce el valor de c: ");
                x = new Ecuacion (a, b, c);
            }catch (Exception e){
                ES.msg((e.getMessage()));
            }
        }while (x == null);
        
        solucion(x);
        ES.msgln(x.toString());
    }
    
    
    static void solucion(Ecuacion ecuacion){
        
        double a = ecuacion.getA();
        double b = ecuacion.getB();
        double c = ecuacion.getC();
        ecuacion.calcularRaiz1(a, b, c);
        ecuacion.calcularRaiz2(a, b, c);
    }
}
