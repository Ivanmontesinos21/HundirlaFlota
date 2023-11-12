package HundirlaFlota;

import java.util.Scanner;

public class Coordenada {


    public static void main(String[] args) {
        String coordenada = getCoordenada();
        System.out.println("Coordenada válida: " + coordenada);
    }

    public static String getCoordenada() {

        String coordenada = "";
        boolean coordenadaValida = false;

        while (!coordenadaValida) {

            coordenada = Entrada.getLetraNumeroCoordenada("Ingresa una coordenada en este formato [A-J][0-9] :").toUpperCase();

            if (coordenada.length() == 2) {
                char letra = coordenada.charAt(0);
                char numero = coordenada.charAt(1);

                if (letra >= 'A' && letra <= 'J' && numero >= '0' && numero <= '9' && !contieneEspacio(coordenada)) {
                    coordenadaValida = true;
                }
            }

            if (!coordenadaValida) {
                System.out.println("Coordenada no válida. Introduce una coordenada que este formada por  una letra de la A a la J seguida de un número del 0 al 9 ");
            }
        }

        return coordenada;
    }

    public static boolean contieneEspacio(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                return true;
            }
        }
        return false;
    }
}

