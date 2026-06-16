package Model;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scan = new Scanner(System.in);

    public static String pegarTexto(String texto){
        System.out.println(texto);
        return scan.nextLine();
    }

    public static int pegarNumInteiro (String texto){
        System.out.println(texto);
        return Integer.parseInt(scan.nextLine());
    }

    public static double pegarNumDouble (String texto){
        System.out.println(texto);
        return Double.parseDouble(scan.nextLine());
    }

    public static float pegarNumFloat (String texto){
        System.out.println(texto);
        return Float.parseFloat(scan.nextLine());
    }

}
