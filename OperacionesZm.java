
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays; 

public class OperacionesZm {
    public static final int primero = 0 ;
    public static final int segundo = 1; 
    public static final int no = 0; 
    public static final int si = 1;

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
                                j = "eión"; 
                                procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                            }
                            if(a < 0 & b < 0){
                                int AbsB = b; 
                                a = -a; 
                                String s, j;
                                s = "la"; 
                                j = "eión"; 
                                procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                            }      
                        } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                            int AbsB = b; 
                            int dd = procesos.mcd(a, m);
                            b = Math.abs(b);
                            a = Math.abs(a); 
                            String s, j;
                            s = "la"; 
                            j = "eión"; 
                            procesos.ZmPositiva(a, b, m, s, j, AbsB, dd);    
                        }
                    } else if (c != 0) {
                        if (c < 0){
                            if(a < 0 & b < 0 | a > 0 & b > 0){
                                if(a > 0 & b > 0){
                                    int AbsB = b; 
                                    b = -b; 
                                    b += c;
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                                }
                                if(a < 0 & b < 0){
                                    int AbsB = b; 
                                    a = -a; 
                                    c = -c;
                                    b += b;
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                                }     
                            } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                                int AbsB = b; 
                                int dd = procesos.mcd(a, m);
                                b = Math.abs(b);
                                a = Math.abs(a);
                                b = -b; 
                                b += c;
                                if (b > 0){
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    procesos.ZmNegativa(a, b, m, s, j, AbsB, dd);
                                } else {
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    procesos.ZmPositiva(a, b, m, s, j, AbsB, dd);   
                                }
                            }
                        }
                        if (c > 0){
                            if(a < 0 & b < 0 | a > 0 & b > 0){
                                if(a > 0 & b > 0){
                                    int AbsB = b;
                                    b = -b;
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    b += c; 
                                    if(b > 0){
                                        procesos.ZmPositiva(a, b, m, s, j, AbsB, d);   
                                    } else {
                                        procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                                    }
                                }
                                if(a < 0 & b < 0){
                                    int AbsB = b; 
                                    a = -a;
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    c = -c;
                                    b += c; 
                                    if(b > 0){
                                        procesos.ZmPositiva(a, b, m, s, j, AbsB, d);   
                                    } else {
                                        procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                                    }
                                }     
                            } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                                int AbsB = b; 
                                int dd = procesos.mcd(a, m);
                                b = Math.abs(b);
                                a = Math.abs(a);
                                b = -b; 
                                b += c;
                                if (b > 0){
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    procesos.ZmNegativa(a, b, m, s, j, AbsB, dd);
                                } else {
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    procesos.ZmPositiva(a, b, m, s, j, AbsB, dd);   
                                }
                            }
                        }
                    }
                } else if(d != 1 & b % d != 0 || d == 0) {
                    System.out.println("\n"); 
                    System.out.println("La ecuación no tiene eión, puesto que el MCD de "+ a +" y "+ m +" es "+ d +" el cual no es divisor de "+ b +".");
                } else if(d != 1){
                    if(c == 0){
                        if(a < 0 & b < 0 | a > 0 & b > 0){
                            if(a > 0 & b > 0){
                                int AbsB = b; 
                                b = -b; 
                                String s, j;
                                s = "las"; 
                                j = "eiones"; 
                                procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                            }
                            if(a < 0 & b < 0){
                                int AbsB = b; 
                                a = -a; 
                                String s, j;
                                s = "las"; 
                                j = "eiones"; 
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
                            j = "eiones"; 
                            procesos.ZmPositiva(a, b, m, s, j, AbsB, dd);    
                        }
                    } else if (c != 0) {
                        if (c < 0){
                            if(a < 0 & b < 0 | a > 0 & b > 0){
                                if(a > 0 & b > 0){
                                    int AbsB = b; 
                                    b = -b; 
                                    b += c;
                                    String s, j;
                                    s = "las"; 
                                    j = "eiones"; 
                                    procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                                }
                                if(a < 0 & b < 0){
                                    int AbsB = b; 
                                    a = -a; 
                                    c = -c;
                                    b += b;
                                    String s, j;
                                    s = "las"; 
                                    j = "eiones"; 
                                    procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                                }     
                            } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                                int AbsB = b; 
                                int dd = procesos.mcd(a, m);
                                b = Math.abs(b);
                                a = Math.abs(a);
                                b = -b; 
                                b += c;
                                if (b > 0){
                                    String s, j;
                                    s = "las"; 
                                    j = "eiones"; 
                                    procesos.ZmNegativa(a, b, m, s, j, AbsB, dd);
                                } else {
                                    String s, j;
                                    s = "las"; 
                                    j = "eiones"; 
                                    procesos.ZmPositiva(a, b, m, s, j, AbsB, dd);   
                                }
                            }
                        }
                        if (c > 0){
                            if(a < 0 & b < 0 | a > 0 & b > 0){
                                if(a > 0 & b > 0){
                                    int AbsB = b;
                                    b = -b;
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    b += c; 
                                    if(b > 0){
                                        procesos.ZmPositiva(a, b, m, s, j, AbsB, d);   
                                    } else {
                                        procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                                    }
                                }
                                if(a < 0 & b < 0){
                                    int AbsB = b; 
                                    a = -a;
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    c = -c;
                                    b += c; 
                                    if(b > 0){
                                        procesos.ZmPositiva(a, b, m, s, j, AbsB, d);   
                                    } else {
                                        procesos.ZmNegativa(a, b, m, s, j, AbsB, d);
                                    }
                                }     
                            } else if (a < 0 & b > 0 | a > 0 & b < 0) {
                                int AbsB = b; 
                                int dd = procesos.mcd(a, m);
                                b = Math.abs(b);
                                a = Math.abs(a);
                                b = -b; 
                                b += c;
                                if (b > 0){
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    procesos.ZmNegativa(a, b, m, s, j, AbsB, dd);
                                } else {
                                    String s, j;
                                    s = "la"; 
                                    j = "eión"; 
                                    procesos.ZmPositiva(a, b, m, s, j, AbsB, dd);   
                                }
                            }
                        }
                    }
                }
                break;  
            }
            case segundo: {
                System.out.println("Recuerde que si le sale una ecaución del estilo c - a * b, es lo mismo que poner -a * b + c");
                System.out.println("La ecuación mostrada de tipo a * b + c, ¿tiene inverso?");
                System.out.println("0/ No     1/ Sí");
                int SiNo = teclado.nextInt(); 
                
                if(SiNo == 0) {
                    System.out.println("Introduzca a (con signo): ");
                    int a = teclado. nextInt(); 
                    System.out.println("Introduzca b (con signo): ");
                    int b = teclado. nextInt(); 
                    System.out.println("Introduzca c (con signo): ");
                    int c = teclado. nextInt();

                    System.out.println("\n"); 

                    if((a | b | c) > c){
                        if(a > m){
                            System.out.println("Como "+ a +" es mayor que "+ m +" se hace el módulo para simplificar la ecuación"); 
                            a = procesos.modulo(a, m);
                            System.out.println("El término quedaría algo tal que (mod "+ m +") = "+ a +"\n"); 
                        } else if(b > m) {
                            System.out.println("Como "+ b +" es mayor que "+ m +" se hace el módulo para simplificar la ecuación"); 
                            b = procesos.modulo(b, m);
                            System.out.println("El término quedaría algo tal que (mod "+ m +") = "+ b +"\n"); 
                        } else if(c > m) {
                            System.out.println("Como "+ a +" es mayor que "+ m +" se hace el módulo para simplificar la ecuación"); 
                            c = procesos.modulo(c, m);
                            System.out.println("El término quedaría algo tal que (mod "+ m +") = "+ c +"\n"); 
                        }
                    }

                    System.out.println("\n"); 
                    System.out.println("Por lo que la ecuación quedaría tal que: "+ a +" * "+ b +" + "+ c +"\n"); 
                    System.out.println("Ahora se operan los términos"); 
                    int d = a * b; 
                    System.out.println("Se multiplican primero los término a * b resultado: "+ d +" + "+ c +"\n"); 
                    int e = d + c; 
                    System.out.println("El resultado es: "+ e +"\n");
                    int numero = 1;
                    if(e < 0){
                        System.out.println("Como "+ e +" es negativo buscamos un número que cumpla la ecuación a = b con módulo "+ m);
                        int e1 = e;
                        while(Math.abs(e) % m != numero % m){
                            numero++;
                        }
                        System.out.println("Al encontrar el número el cual es "+ numero +" ya que "+ Math.abs(e1) +" = "+ numero +" con módulo "+ m +", lo positivizamos");
                        System.out.println("Ahora restamos el módulo "+ m +" menos "+ numero +" y hayamos la solución.");
                        e = m - numero;
                        System.out.println("Por tanto, la eión de la ecuación es: "+ e);
                    } else if (e > 0) {
                        if(e > m){
                            System.out.println("Como "+ e +" es mayor que "+ m +" se hace el módulo."); 
                            System.out.println("(mod "+ m +") = "+ e); 
                            int ee = e; 
                            e -= m; 
                            System.out.println("La solución es = (mod "+ m +") = "+ e +". Se ha sacado restando "+ ee +" - "+ m +" = "+ e); 
                        } else {
                            System.out.println("(mod "+ m +") = "+ e); 
                        }
                    }
                } else if (SiNo == 1) {
                    System.out.println("Introduzca a (con signo): ");
                    int a = teclado. nextInt(); 
                    System.out.println("Introduzca b (con signo): ");
                    int b = teclado. nextInt(); 
                    System.out.println("Introduzca c (con signo): ");
                    int c = teclado. nextInt(); 
                    System.out.println("Introduzca cual de los 3 términos es el que hay que calcular el inverso: 0/ a     1/ b     2/ c"); 
                    int variable = teclado.nextInt(); 

                    if(variable == 0){
                        System.out.println("Se procede a calcular el inverso de "+ a +"\n");
                        procesos.inverso(a, m); 
                        a = procesos.inverso(a, m);
                        System.out.println("El término invertido quedaría algo tal que "+ a +"\n");
                        System.out.println("Recuerde que puede justificar el inverso con el ejercicio anterior, si lo hay, sería sospechoco si vuelve a copiar la operación");
                    } else if (variable == 1) {
                        System.out.println("Se procede a calcular el inverso de "+ b +"\n");
                        procesos.inverso(b, m);
                        b = procesos.inverso(b, m);
                        System.out.println("El término invertido quedaría algo tal que "+ b +"\n"); 
                        System.out.println("Recuerde que puede justificar el inverso con el ejercicio anterior, si lo hay, sería sospechoco si vuelve a copiar la operación");
                    } else if (variable == 2) {
                        System.out.println("Se procede a calcular el inverso de "+ c +"\n");
                        procesos.inverso(c, m);
                        c = procesos.inverso(c, m);
                        System.out.println("El término invertido quedaría algo tal que "+ c +"\n"); 
                        System.out.println("Recuerde que puede justificar el inverso con el ejercicio anterior, si lo hay, sería sospechoco si vuelve a copiar la operación");
                    } else {
                        System.out.println("Reinicie el programa");
                    }

                    System.out.println("\n"); 

                    if(a > m){
                        System.out.println("Como "+ a +" es mayor que "+ m +" se hace el módulo para simplificar la ecuación"); 
                        a = procesos.modulo(a, m);
                        System.out.println("El término quedaría algo tal que (mod "+ m +") = "+ a +"\n"); 
                    } 
                    if(b > m) {
                        System.out.println("Como "+ b +" es mayor que "+ m +" se hace el módulo para simplificar la ecuación"); 
                        b = procesos.modulo(b, m);
                        System.out.println("El término quedaría algo tal que (mod "+ m +") = "+ b +"\n"); 
                    } 
                    if(c > m) {
                        System.out.println("Como "+ c +" es mayor que "+ m +" se hace el módulo para simplificar la ecuación"); 
                        c = procesos.modulo(c, m);
                        System.out.println("El término quedaría algo tal que (mod "+ m +") = "+ c +"\n"); 
                    }
 
                    System.out.println("Por lo que la ecuación quedaría tal que: "+ a +" * "+ b +" + "+ c); 
                    System.out.println("Ahora se operan los términos" +"\n"); 
                    int d = a * b; 
                    System.out.println("Se multiplican primero los término a * b resultado: "+ d +" + "+ c +"\n"); 
                    int e = d + c; 
                    System.out.println("El resultado es: "+ e);
                    int numero = 1;
                    if(e < 0){
                        System.out.println("Como "+ e +" es negativo buscamos un número que cumpla la ecuación a = b con módulo "+ m);
                        int e1 = e;
                        while(Math.abs(e) % m != numero % m){
                            numero++;
                        }
                        System.out.println("Al encontrar el número el cual es "+ numero +" ya que "+ Math.abs(e1) +" = "+ numero +" con módulo "+ m +", lo positivizamos");
                        System.out.println("Ahora restamos el módulo "+ m +" menos "+ numero +" y hayamos la solución.");
                        e = m - numero;
                        System.out.println("Por tanto, la eión de la ecuación es: "+ e);
                    } else if(e > 0){
                        if(e > m){
                            System.out.println("Como "+ e +" es mayor que "+ m +" se hace el módulo."); 
                            System.out.println("(mod "+ m +") = "+ e); 
                            int ee = e; 
                            e -= m; 
                            System.out.println("La solución es = (mod "+ m +") = "+ e +". Se ha sacado restando "+ ee +" - "+ m +" = "+ e); 
                        } else {
                            System.out.println("(mod "+ m +") = "+ e); 
                        }
                    }
                } else {
                    System.out.println("Subnormal, ahí pone que 0 es no y 1 es sí. ¿Para que pones otro valor? En el caso que haya sido sin querer o te hayas de equivocado de opción, tienes perdón");
                    System.out.println("Reinicie el programa"); 
                }

                break; 
            }
        } 
    }
}
