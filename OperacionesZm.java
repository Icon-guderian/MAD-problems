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

                int d = procesos.mcd(a, m);
                if(d == 1) {
                    if(c == 0) {
                        if(a < 0 & b < 0 | a > 0 & b > 0){

                        } else if (a < 0 & b > 0 | a > 0 & b < 0) {

                        }
                    } else  {

                    }
                } else if(d != 1 & b % d != 0 || d == 0 ) {
                    System.out.println("La ecuación no tiene solución, puesto que el MCD de "+ a +" y "+ m +" es "+ d +" el cual no es divisor de "+ b +". Por lo que es de tipo 3");
                } else if(d != 1){
                    if(c == 0){
                        if(a < 0 & b < 0 | a > 0 & b > 0){
                            int AbsB = b; 
                            b = -b; 
                            System.out.println("\n"); 
                            System.out.println("La ecuación se queda de la forma ax = -b tal que: "+ a +"x = "+ b +"\n");
                            System.out.println("Ahora que habría que positivizar la b, pues es negativa. Por lo que hay que encontrar un número en Z"+ m +" cuyo módulo sea 0 más grande que "+ AbsB); 
                            int numero = 1; 
                            int mod2 = procesos.modulo(numero, m); 
                            while(mod2 != 0 | numero < AbsB){
                                numero++; 
                                mod2 = procesos.modulo(numero, m); 
                            } 
                            System.out.println("El número que buscamos que cumple la condición es "+ numero +" y como el módulo de"+ numero +" es igual al de 0. Por lo que: "); 
                            System.out.println(b +" = 0 + "+ b +" = "+ numero +" "+ b + " = "+ (numero - AbsB) +"\n"); 
                            b = numero - AbsB; 
                            System.out.println("La ecuación quedaría tal que: "+ a +"x = "+ b +"\n");
                            System.out.println("Ahora calculamos el MCD de a y m para comprobar las soluciones de la ecuación "+ a +"x = "+ b +". MCD("+ a +", "+ m +") = "+ d); 
                            System.out.println("Por lo que habrán "+ d +" soluciones\n"); 
                            System.out.println("Encontramos ahora las soluciones, para ello primero hemos de hallar el módulo de "+ b);
                            int modb = procesos.modulo(b, m); 
                            System.out.println(b +" / "+ m +" el resto es "+ modb + ". Así que hay que encontrar las soluciones que cumplan la ecuación."); 
                            int x = 0; 
                            int y = 0;
                            while(procesos.modulo(a, m) > y){
                                int X = x; 
                                x = x * a; 
                                if(procesos.modulo(x, m) == procesos.modulo(b, m)){
                                   System.out.println("La solución es "+ X); 
                                   y++;
                                   x = X;
                                   x++;
                                } else {
                                    x = X;
                                    x++; 
                                }
                            }

                            

                        } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                            System.out.println("La ecuación se queda de la forma ax = b tal que: "+ a +"x = "+ b +"\n"); 

                        }
                    } else {

                    }
                }
                break;  
            }
            case segundo: {

                break; 
            }
        } 
    }
}
