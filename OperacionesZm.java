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
                            if(a > 0 & b > 0){
                                int AbsB = b; 
                                b = -b; 
                                String s, j;
                                s = "la"; 
                                j = "solución"; 
                                procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                            }
                            if(a < 0 & b < 0){
                                int AbsB = b; 
                                a = -a; 
                                String s, j;
                                s = "la"; 
                                j = "solución"; 
                                procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                            }      
                        } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                            int AbsB = b; 
                            int dd = procesos.mcd(a, m);
                            b = Math.abs(b);
                            a = Math.abs(a); 
                            String s, j;
                            s = "la"; 
                            j = "solución"; 
                            procesos.ZmPositiva(a, b, m, s, j, AbsB, dd);    
                        }
                    } else if (c != 0) {
                        if(a < 0 & b < 0 | a > 0 & b > 0){
                            if(a > 0 & b > 0){
                                
                            }
                            if(a < 0 & b < 0){
                                
                            }     
                        } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                               
                        }
                    }
                } else if(d != 1 & b % d != 0 || d == 0) {
                    System.out.println("\n"); 
                    System.out.println("La ecuación no tiene solución, puesto que el MCD de "+ a +" y "+ m +" es "+ d +" el cual no es divisor de "+ b +".");
                } else if(d != 1){
                    if(c == 0){
                        if(a < 0 & b < 0 | a > 0 & b > 0){
                            if(a > 0 & b > 0){
                                int AbsB = b; 
                                b = -b; 
                                String s, j;
                                s = "las"; 
                                j = "soluciones"; 
                                procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                            }
                            if(a < 0 & b < 0){
                                int AbsB = b; 
                                a = -a; 
                                String s, j;
                                s = "las"; 
                                j = "soluciones"; 
                                procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                            }     
                        } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                            int AbsB = b; 
                            int dd = procesos.mcd(a, m);
                            dd = Math.abs(dd); 
                            b = Math.abs(b);
                            a = Math.abs(a); 
                            String s, j;
                            s = "las"; 
                            j = "soluciones"; 
                            procesos.ZmPositiva(a, b, m, s, j, AbsB, dd);    
                        }
                    } else if (c != 0) {
                        if(a < 0 & b < 0 | a > 0 & b > 0){
                            if(a > 0 & b > 0){
                               
                            }
                            if(a < 0 & b < 0){
                                
                            }     
                        } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                               
                        }
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
