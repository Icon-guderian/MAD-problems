
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

/**
 * Write a description of class mcd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
          System.out.printf("%d ≡ %d (mod %d)", a, a % z, z);
          a = a % z;
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
          return soluc;
        }
    }
}
