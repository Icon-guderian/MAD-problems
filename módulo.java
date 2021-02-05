
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class modulo
{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        System.out.println("Introduzca a");
        int a = teclado.nextInt();
        System.out.println("Introduzca b");
        int b = teclado.nextInt();

        System.out.println("\n\n\n");
        a = a % b;

        System.out.println(a);
    }
}
