
import java.util.Scanner;
import java.util.Locale;

/**
 * Write a description of class mcd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class procesos {
    public static int mcd1(int a, int b){

        while(a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            } 
        }

        return a; 
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
        n++;
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

    public static int fact(int[] a, int b){
        int i = 2; 
        int y = 0; 
        while(b != 1) {
            if(b % i != 0){
                i++;
            } else {
                while(b % i == 0) {
                    b /= i;
                    a[y] = i;
                    y++;
                }
            }
        }

        return i; 
    }

    public static int reducir(int a, int b, int c){
        int u = procesos.mcd1(a, b);
        int i = procesos.mcd1(u, c); 

        return i; 
    }
    
    public static int modulo(int a, int m){
        a = a % m; 
        return a; 
    }
    
    public static int inverso(){
        int x = 0; 
        return x; 
    
    }
}