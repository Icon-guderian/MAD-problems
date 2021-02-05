import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class EcCongruencias {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        int cociente, resto;

        System.out.println("Introduzca los valores de la ecuación de congruencia del estilo ax = b con módulo m \n"); 
        System.out.println("Introduzca a");
        int a = teclado.nextInt(); 
        System.out.println("Introduzca b");
        int b = teclado.nextInt(); 
        System.out.println("Introduzca m");
        int m = teclado.nextInt(); 

        int d = procesos.mcd1(a, m); 
        int mm = m; 
        int aa = a;
        int bb = b; 

        if(d == 1){
            int[] f = new int[procesos.rango(m, a) + 1]; 

            System.out.println("Ya que el MCD("+ a +", "+ m +") es 1,  tiene una única solución por lo que es de tipo 1" );
            System.out.println("A continuación para hallar la solución calculamos los cocientes del algoritmo de Euclides\n");

            System.out.println("Las divisiones serían las siguientes: \n"); 

            int rg = procesos.rango(m, a);

            if(a != 0){
                for(int i = 1; a != 0; i++){
                    cociente = m / a; 
                    resto = m % a;
                    f[i] = cociente; 
                    System.out.println(m +" / "+ a +" = "+ cociente +" y con resto "+ resto);
                    m = a;
                    a = resto; 
                }
            }

            System.out.println("Los valores de los cocientes son: "+ Arrays.toString(f)+ "\n");

            System.out.println("Ahora siguiendo la ecuación de la Pi, que es: Pi = qi * P[i-1] + P[i-2] calculamos los Pi \n");

            int[] x = new int[f.length];

            for(int s = 0; s < f.length; s++){
                x[s] = 1;
                System.out.println("El primer valor siempre será "+ x[s]);
                s++; 
                int w = f[s] * x[s - 1];
                System.out.println("Pi = "+ f[s] +" * " + x[s -1] +" + 0 = "+ w);
                x[s] = w;
                for(int q = 2; q < f.length; q++){
                    int z = (f[q] * x[q - 1]) + x[q - 2];
                    System.out.println("Pi = "+ f[q] +" * "+ x[q -1] +" + "+ x[q - 2] +" = "+ z);
                    x[q] = z;
                } 
                s = 1000000; 
            }

            System.out.println("Los valores de Pi son: "+ Arrays.toString(x) +"\n");

            System.out.println("El cuadro tras realizar las operaciones de quedaría tal que así:");
            System.out.println(Arrays.toString(f));
            System.out.println(Arrays.toString(x) +"\n");
            int sol = (int) (Math.pow(-1, procesos.rango(m, a) - 2) * b);

            for(int i = 0; i < x.length; i++){
                if(i == rg){
                    System.out.println("Como n es igual a "+ (rg - 1) +", b es igual a "+ b +" y P[i-1] es igual a "+ x[i] +", ya que la ecuación es x = (-1)^[n - 1] * b * P[n - 1]");
                    int soluc = x[i] * sol; 
                    System.out.println("Pi = (-1)^"+ (rg - 2) +" * "+ b +" * "+ x[i]);
                    int numero = 1; 
                    if(soluc < 0){
                        System.out.println("Como "+ soluc +" es negativo buscamos un número que cumpla la ecuación a = b con módulo "+ mm); 
                        int soluc1 = soluc; 
                        while(Math.abs(soluc) % mm != numero % mm){
                            numero++;
                        }
                        System.out.println("Al encontrar el número el cual es "+ numero +" ya que "+ Math.abs(soluc1) +" = "+ numero +" con módulo "+ mm +", lo positivizamos");
                        System.out.println("Ahora restamos el módulo "+ mm +" menos "+ numero +" y hayamos la solución.");
                        soluc = mm - numero; 
                        System.out.println("Por tanto, la solución de la ecuación es: "+ soluc);
                    } else {
                        System.out.println("Por tanto, la solución de la ecuación es: "+ soluc);
                    }
                }
            }
        } else if(d != 1 & b % d != 0 || d == 0 ) {
            System.out.println("La ecuación no tiene solución, puesto que el MCD de "+ a +" y "+ m +" es "+ d +" el cual no es divisor de "+ b +". Por lo que es de tipo 3");
        } else if(d != 1) {
            if(aa > mm){
                a = a % m; 

                System.out.println("Al pasar "+ aa +" a módulo "+ m +"la ecuación queda tal que: "+ a +"x = "+ b +" con módulo "+ m + "\n");
                System.out.println("La ecuación tiene soluciones, ya que el MCD("+ a +", "+ m +") = "+ d +" y "+ d +" es divisor de "+ b +"\n"); 
                System.out.println("A continuación para hallar la solución, descompondremos en factores primos a, y m\n");

                int[] factA = new int[procesos.rango2(a)]; 
                int[] factB = new int[procesos.rango2(b)];
                int[] factM = new int[procesos.rango2(m)];

                procesos.fact(factA, a); procesos.fact(factB, b); procesos.fact(factM, m);
                int rg = procesos.rango(m, a);
                System.out.println("a = "+ Arrays.toString(factA));
                System.out.println("b = "+ Arrays.toString(factB));
                System.out.println("m = "+ Arrays.toString(factM) + "\n"); 
                int A = a / procesos.reducir(a, b, m); 
                int B = b / procesos.reducir(a, b, m); 
                int M = m / procesos.reducir(a, b, m); 
                int MM = M; 
                System.out.println("Como tienen en común el factor "+ procesos.reducir(a, b, m) +" al dividir la ecuación se quedaría tal que: ");
                System.out.println(A +"x = "+ B +" con módulo "+ M + "\n");

                int[] f = new int[procesos.rango(M, A) + 1]; 

                if(a != 0){
                    for(int i = 1; A != 0; i++){
                        cociente = M / A; 
                        resto = M % A;
                        f[i] = cociente; 
                        System.out.println(M +" / "+ A +" = "+ cociente +" y con resto "+ resto);
                        M = A;  
                        A = resto; 
                    }
                }

                System.out.println("Los valores de los cocientes son: "+ Arrays.toString(f)+ "\n");

                System.out.println("Ahora siguiendo la ecuación de la Pi, que es: Pi = qi * P[i-1] + P[i-2] calculamos los Pi \n");

                int[] x = new int[f.length];

                for(int s = 0; s < f.length; s++){
                    x[s] = 1;
                    System.out.println("El primer valor siempre será "+ x[s]);
                    s++; 
                    int w = f[s] * x[s - 1];
                    System.out.println("Pi = "+ f[s] +" * " + x[s -1] +" + 0 = "+ w);
                    x[s] = w;
                    for(int q = 2; q < f.length; q++){
                        int z = (f[q] * x[q - 1]) + x[q - 2];
                        System.out.println("Pi = "+ f[q] +" * "+ x[q -1] +" + "+ x[q - 2] +" = "+ z);
                        x[q] = z;
                    } 
                    s = 1000000; 
                }
                System.out.println("Olvide el último valor del array");
                System.out.println("Los valores de Pi son: "+ Arrays.toString(x) +"\n");

                System.out.println("El cuadro tras realizar las operaciones de quedaría tal que así:");
                System.out.println(Arrays.toString(f));
                System.out.println(Arrays.toString(x) +"\n");

                int sol = (int) Math.pow(-1, rg - 2) * B;

                for(int i = 0; i < x.length; i++){
                    if(i == rg){
                        System.out.println("Como n es igual a "+ (rg - 1) +", b es igual a "+ B +" y P[i-1] es igual a "+ x[i] +", ya que la ecuación es x = (-1)^[n - 1] * b * P[n - 1]");
                        int soluc = x[i] * sol; 
                        System.out.println("Pi = (-1)^"+ (rg - 2) +" * "+ B +" * "+ x[i]);
                        System.out.println("Por tanto, x = "+ soluc);
                        if(soluc < 0){
                            System.out.println("No obstante, "+ soluc +" en (mod "+ MM +") = "+ (soluc + MM)); 
                            System.out.println("Las soluciones de la ecuación al ser su MCD igual a "+ d +", "+ d +". Y se calculan sumando la solucón de la x = "+ soluc +" más "+ MM +" las "+ d + " veces." );
                            int xd = 1;
                            while(d != 0){
                                soluc += MM; 
                                System.out.println("La "+ xd +"º solución es: "+ soluc); 
                                xd++; 
                                d--; 
                            }
                        } else if(soluc > 0){
                            if(soluc - MM < 0){
                                System.out.println("No obstante, "+ soluc +" en (mod "+ MM +") = "+ soluc); 
                                System.out.println("Las soluciones de la ecuación al ser su MCD igual a "+ d +", son "+ d +". Y se calculan sumando la solucón de la x = "+ soluc +" más "+ MM +" las "+ d + " veces." );
                                int xd = 1;
                                System.out.println("La "+ xd +"º solución es: "+ soluc +"   (mod "+ mm +")");
                                int xd1 = 2;
                                while(d != 1){
                                    soluc += MM; 
                                    System.out.println("La "+ xd1 +"º solución es: "+ soluc +"   (mod "+ mm +")"); 
                                    xd1++; 
                                    d--; 
                                }
                            } else {
                                System.out.println("No obstante, "+ soluc +" en (mod "+ MM +") = "+ (soluc - MM)); 
                                System.out.println("Las soluciones de la ecuación al ser su MCD igual a "+ d +", son "+ d +". Y se calculan sumando la solucón de la x = "+ soluc +" más "+ MM +" las "+ d + " veces." );
                                soluc = soluc - MM;
                                int xd = 1;
                                System.out.println("La "+ xd +"º solución es: "+ soluc +"   (mod "+ mm +")");
                                int xd1 = 2;
                                while(d != 1){
                                    soluc += MM; 
                                    System.out.println("La "+ xd1 +"º solución es: "+ soluc +"   (mod "+ mm +")"); 
                                    xd1++; 
                                    d--; 
                                }
                            }
                        } 
                    }
                }
            } else {
                System.out.println("La ecuación tiene soluciones, ya que el MCD("+ a +", "+ m +") = "+ d +" y "+ d +" es divisor de "+ b +"\n"); 
                System.out.println("A continuación para hallar la solución, descompondremos en factores primos a, y m\n");

                int[] factA = new int[procesos.rango2(a)]; 
                int[] factB = new int[procesos.rango2(b)];
                int[] factM = new int[procesos.rango2(m)];

                procesos.fact(factA, a); procesos.fact(factB, b); procesos.fact(factM, m);
                int rg = procesos.rango(m, a);
                System.out.println("a = "+ Arrays.toString(factA));
                System.out.println("b = "+ Arrays.toString(factB));
                System.out.println("m = "+ Arrays.toString(factM) + "\n"); 
                int A = a / procesos.reducir(a, b, m); 
                int B = b / procesos.reducir(a, b, m); 
                int M = m / procesos.reducir(a, b, m); 
                int MM = M; 
                System.out.println("Como tienen en común el factor "+ procesos.reducir(a, b, m) +" al dividir la ecuación se quedaría tal que: ");
                System.out.println(A +"x = "+ B +" con módulo "+ M + "\n");

                int[] f = new int[procesos.rango(M, A) + 1]; 

                if(a != 0){
                    for(int i = 1; A != 0; i++){
                        cociente = M / A; 
                        resto = M % A;
                        f[i] = cociente; 
                        System.out.println(M +" / "+ A +" = "+ cociente +" y con resto "+ resto);
                        M = A;
                        A = resto; 
                    }
                }

                System.out.println("Los valores de los cocientes son: "+ Arrays.toString(f)+ "\n");

                System.out.println("Ahora siguiendo la ecuación de la Pi, que es: Pi = qi * P[i-1] + P[i-2] calculamos los Pi \n");

                int[] x = new int[f.length];

                for(int s = 0; s < f.length; s++){
                    x[s] = 1;
                    System.out.println("El primer valor siempre será "+ x[s]);
                    s++; 
                    int w = f[s] * x[s - 1];
                    System.out.println("Pi = "+ f[s] +" * " + x[s -1] +" + 0 = "+ w);
                    x[s] = w;
                    for(int q = 2; q < f.length; q++){
                        int z = (f[q] * x[q - 1]) + x[q - 2];
                        System.out.println("Pi = "+ f[q] +" * "+ x[q -1] +" + "+ x[q - 2] +" = "+ z);
                        x[q] = z;
                    } 
                    s = 1000000; 
                }
                System.out.println("Olvide el último valor del array");
                System.out.println("Los valores de Pi son: "+ Arrays.toString(x) +"\n");

                System.out.println("El cuadro tras realizar las operaciones de quedaría tal que así:");
                System.out.println(Arrays.toString(f));
                System.out.println(Arrays.toString(x) +"\n");

                int sol = (int) Math.pow(-1, rg - 2) * B;

                for(int i = 0; i < x.length; i++){
                    if(i == rg){
                        System.out.println("Como n es igual a "+ (rg - 1) +", b es igual a "+ B +" y P[i-1] es igual a "+ x[i] +", ya que la ecuación es x = (-1)^[n - 1] * b * P[n - 1]");
                        int soluc = x[i] * sol; 
                        System.out.println("Pi = (-1)^"+ (rg - 2) +" * "+ B +" * "+ x[i]);
                        System.out.println("Por tanto, x = "+ soluc);
                        if(soluc < 0){
                            System.out.println("No obstante, "+ soluc +" en (mod "+ MM +") = "+ (soluc + MM)); 
                            System.out.println("Las soluciones de la ecuación al ser su MCD igual a "+ d +", "+ d +". Y se calculan sumando la solucón de la x = "+ soluc +" más "+ MM +" las "+ d + " veces." );
                            int xd = 1;
                            while(d != 0){
                                soluc += MM; 
                                System.out.println("La "+ xd +"º solución es: "+ soluc); 
                                xd++; 
                                d--; 
                            }
                        } else if(soluc > 0){
                            if(soluc - MM < 0){
                                System.out.println("No obstante, "+ soluc +" en (mod "+ MM +") = "+ soluc); 
                                System.out.println("Las soluciones de la ecuación al ser su MCD igual a "+ d +", son "+ d +". Y se calculan sumando la solucón de la x = "+ soluc +" más "+ MM +" las "+ d + " veces." );
                                int xd = 1;
                                System.out.println("La "+ xd +"º solución es: "+ soluc +"   (mod "+ mm +")");
                                int xd1 = 2;
                                while(d != 1){
                                    soluc += MM; 
                                    System.out.println("La "+ xd1 +"º solución es: "+ soluc +"   (mod "+ mm +")"); 
                                    xd1++; 
                                    d--; 
                                }
                            } else {
                                System.out.println("No obstante, "+ soluc +" en (mod "+ MM +") = "+ (soluc - MM)); 
                                System.out.println("Las soluciones de la ecuación al ser su MCD igual a "+ d +", son "+ d +". Y se calculan sumando la solucón de la x = "+ soluc +" más "+ MM +" las "+ d + " veces." );
                                soluc = soluc - MM;
                                int xd = 1;
                                System.out.println("La "+ xd +"º solución es: "+ soluc +"   (mod "+ mm +")");
                                int xd1 = 2;
                                while(d != 1){
                                    soluc += MM; 
                                    System.out.println("La "+ xd1 +"º solución es: "+ soluc +"   (mod "+ mm +")"); 
                                    xd1++; 
                                    d--; 
                                }
                            }
                        } else {
                            System.out.println("ERROR, vuelva a iniciar el programa");
                        }
                    }
                }
            }
        }
    }
}