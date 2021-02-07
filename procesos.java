
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class procesos {
    public static int mcd(int a, int b){
        if (b == 0) return a;
        return mcd(b, a % b);
    }

    public static int rango(int m, int a){
        int cociente, resto;
        int n = 0;

        while(a != 0){
            cociente = m / a;
            resto = m % a;
            m = a;
            a = resto;
            n++;
        }
        return n;
    }

    public static int rango2(int b){
        int i = 2;
        int y = 0;
        int n = 0;

        while(b != 1) {
            if(b % i != 0){
                i++;
            } else {
                while(b % i == 0) {
                    b /= i;
                    y++;
                    n++;
                }
            }
        }

        return n;
    }

    public static int[] fact(int a) {
        int[] fact = new int[rango2(a)];
        int i = 2;
        int j = 0;
        while(a != 1) {
            if(a % i != 0){
                i++;
            } else {
                while(a % i == 0) {
                    a /= i;
                    fact[j] = i;
                    j++;
                }
            }
        }
        return fact;
    }

    public static int reducir(int a, int b, int c){
        int u = procesos.mcd(a, b);
        int i = procesos.mcd(u, c);

        return i;
    }

    public static int modulo(int a, int m){
        return a % m;
    }

    public static int inverso(int a, int z){
        // Make sure a < z;
        if (a % z != a) {
            System.out.printf("Hay que resolver: %dx ≡ %d (mod %d)\n", a, a % z, z);
            a = a % z;
        } else {
            System.out.printf("Hay que resolver: %dx ≡ 1 (mod %d)\n", a, z);
        }
        // Check mcd(a, z) == 1
        if (procesos.mcd(a, z) != 1) {
            System.out.printf("%d no tiene inverso en Z = %d\n", a, z);
            return -0x7fffffff;
        }
        else {
            int cociente, resto;
            int m = z;
            int rg = procesos.rango(m, a);
            int[] f = new int[rg + 1];
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
            System.out.println("Ni = "+Arrays.toString(f));
            System.out.println("Ahora siguiendo la ecuación de la Pi, que es: Pi = qi * P[i-1] + P[i-2] calculamos los Pi");

            int[] x = new int[f.length];

            x[0] = 1;
            System.out.println("El primer valor siempre será "+ x[0]);
            int w = f[1] * x[0];
            System.out.println("Pi = "+ f[1] +" * " + x[0] +" + 0 = "+ w);
            x[1] = w;
            for(int q = 2; q < f.length; q++){
                z = (f[q] * x[q - 1]) + x[q - 2];
                System.out.println("Pi = "+ f[q] +" * "+ x[q -1] +" + "+ x[q - 2] +" = "+ z);
                x[q] = z;
            }

            System.out.println("Los valores de Pi son: "+ Arrays.toString(x) +"\n");
            System.out.println("El cuadro tras realizar las operaciones de quedaría tal que así:");
            System.out.println(Arrays.toString(f));
            System.out.println(Arrays.toString(x) +"\n");

            int sol = (int) Math.pow(-1, rg - 1) * 1;

            System.out.println("Como n es igual a "+ rg +", b es igual a "+ 1 +" y P[i-1] es igual a "+ x[rg] +", ya que la ecuación es x = (-1)^[n - 1] * b * P[n - 1]");
            int soluc = x[rg-1] * sol;
            System.out.println("Pi = (-1)^"+ (rg - 1) +" * "+ 1 +" * "+ x[rg-1]);
            System.out.println("Por tanto, a^(-1) = "+ soluc);
            if (soluc < 0) {
                System.out.println("Solución negativa detectada. Convirtiendo en positiva");
                while (soluc < 0) {
                    soluc = z + soluc;
                }
                System.out.println("La solución positiva y correcta es: "+soluc);

            }
            return soluc;
        }
    }

    public static int ZmPositiva(int a, int b, int m, String det, String plr, int AbsB, int d){
        System.out.println("\n"); 
        System.out.println("La ecuación se queda de la forma ax = b tal que: "+ a +"x = "+ b +"\n");
        System.out.println("Ahora calculamos el MCD de a y m para comprobar "+ det +" "+ plr +" de la ecuación "+ a +"x = "+ b +". MCD("+ a +", "+ m +") = "+ d); 
        System.out.println("Por lo que habrán "+ d +" "+ plr +"\n"); 
        System.out.println("Encontramos ahora "+ det +" "+ plr +", para ello primero hemos de hallar el módulo de "+ b);
        int modb = procesos.modulo(b, m); 
        System.out.println(b +" / "+ m +" el resto es "+ modb + ". Así que hay que encontrar "+ det +" "+ plr +" que cumplan la ecuación."); 
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

        return x; 
    }

    public static int ZmNegativa(int a, int b, int m, String det, String plr, int AbsB, int d){
        d = Math.abs(d);
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

        if(numero - AbsB > m) {
            System.out.println(b +" = 0 + "+ b +" = "+ numero +" "+ b + " = "+ (numero + AbsB) +"\n"); 
            b = numero + AbsB; 
            System.out.println("La ecuación quedaría tal que: "+ a +"x = "+ b +"\n");
            System.out.println("Ahora calculamos el MCD de a y m para comprobar "+ det +" "+ plr +" de la ecuación "+ a +"x = "+ b +". MCD("+ a +", "+ m +") = "+ d); 
            System.out.println("Por lo que habrán "+ d +" "+ plr +"\n"); 
            System.out.println("Encontramos ahora "+ det +" "+ plr +", para ello primero hemos de hallar el módulo de "+ b);
            int modb = procesos.modulo(b, m); 
            System.out.println(b +" / "+ m +" el resto es "+ modb + ". Así que hay que encontrar "+ det +" "+ plr +" que cumplan la ecuación."); 
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

            return x; 
        } else {
            
            System.out.println(b +" = 0 + "+ b +" = "+ numero +" "+ b + " = "+ (numero - AbsB) +"\n"); 
            b = numero - AbsB;
            System.out.println("La ecuación quedaría tal que: "+ a +"x = "+ b +"\n");
            System.out.println("Ahora calculamos el MCD de a y m para comprobar "+ det +" "+ plr +" de la ecuación "+ a +"x = "+ b +". MCD("+ a +", "+ m +") = "+ d); 
            System.out.println("Por lo que habrán "+ d +" "+ plr +"\n"); 
            System.out.println("Encontramos ahora "+ det +" "+ plr +", para ello primero hemos de hallar el módulo de "+ b);
            int modb = procesos.modulo(b, m); 
            System.out.println(b +" / "+ m +" el resto es "+ modb + ". Así que hay que encontrar "+ det +" "+ plr +" que cumplan la ecuación."); 
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

            return x; 
        }

    }
}
