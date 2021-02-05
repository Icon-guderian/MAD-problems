
import java.util.Scanner;
import java.util.Locale;

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

    public static int inverso(){
        int x = 0;
        return x;

    }
}
