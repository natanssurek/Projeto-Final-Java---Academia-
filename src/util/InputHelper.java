package util;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scan = new Scanner(System.in);

    public static String pegarTexto(String texto) {
        System.out.println(texto);
        return scan.nextLine();
    }

    public static int pegarNumInteiro(String texto){
        System.out.println(texto);
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mDIGITE APENAS NUMEROS!!!\u001B[0m");
            return -1;
        }
    }

    public static float pegarNumFloat(String texto){
        System.out.println(texto);
        try {
            return Float.parseFloat(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\u001B[31mDIGITE APENAS NUMEROS!!!\u001B[0m");
            return -1;
        }
    }

    public static double pegarNumDouble(String texto){
        System.out.println(texto);
        try {
            return Double.parseDouble(scan.nextLine());
        }  catch (NumberFormatException e) {
            System.out.println("\u001B[31mDIGITE APENAS NUMEROS!!!\u001B[0m");
            return -1;
        }
    }
}
