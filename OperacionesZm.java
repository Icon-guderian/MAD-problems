import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays; 

public class OperacionesZm {
    public static final int primero = 0 ;
    public static final int segundo = 1; 

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        System.out.println("Indique el módulo: ");
        int m = teclado. nextInt(); 
        System.out.println("Elija el tipo de ecuación = (0: a + b = c    o   1: a * b + c)");
        int tipo = teclado.nextInt(); 

        switch(tipo){
            case primero: {
                System.out.println("Introduzca a (con signo): ");
                int a = teclado. nextInt(); 
                System.out.println("Introduzca b (con signo): ");
                int b = teclado. nextInt(); 
                System.out.println("Introduzca c (con signo): ");
                int c = teclado. nextInt(); 

                if(c == 0) {
                    if(a < 0 & b < 0 | a > 0 & b > 0){
                        int AbsB = b; 
                        b = -b; 
                        System.out.println("La ecuación se queda de la forma ax = -b tal que: "+ a +"x = "+ b);
                        System.out.println("Ahora que habría que positivizar la b, pues es negativa. Por lo que hay que encontrar un número en Z"+ m +" cuyo módulo sea 0 más gramde que "+ AbsB); 
                        int numero = 1; 
                        int mod2 = procesos.modulo(numero, m); 

                        while(mod2 != 0 | numero < AbsB){
                            numero++; 
                            mod2 = procesos.modulo(numero, m); 
                        } 

                        System.out.println(numero); 
                    } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                        System.out.println("La ecuación se queda de la forma ax = b tal que: "+ a +"x = "+ b); 

                    }
                } else  {

                }
                break;  
            }
            case segundo: {

                break; 
            }
        } 
    }
}
