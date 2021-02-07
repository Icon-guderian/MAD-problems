
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;
/**
 * Write a description of class pruebas2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pruebas2
{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        System.out.println("Introduzca a");
        int a = teclado.nextInt(); 
        System.out.println("Introduzca b");
        int b = teclado.nextInt(); 
        System.out.println("Introduzca m");
        int m = teclado.nextInt(); 

        System.out.println(procesos.rango(m, a));

        int[] factA = new int[procesos.rango2(a)]; 
        int[] factB = new int[procesos.rango2(b)];
        int[] factM = new int[procesos.rango2(m)];

        

        System.out.println("a = "+ Arrays.toString(factA));
        System.out.println("b = "+ Arrays.toString(factB));
        System.out.println("m = "+ Arrays.toString(factM)+ "\n");
        
        System.out.println(procesos.reducir(a, b, m));
        
        
        int q = (int) Math.pow(-1, 5);
        System.out.println(q);
        
    }
}

