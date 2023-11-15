package HundirlaFlota;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

    }
    public static String getLetraNumeroCoordenada(String msg){
        Scanner sc=new Scanner(System.in);
        System.out.println(msg);
        while (!sc.hasNext())
            System.out.print("Introduce una coordenada que este formada por  una letra de la A a la J seguida de un número del 0 al 9.");
         return sc.next();


    }



}
