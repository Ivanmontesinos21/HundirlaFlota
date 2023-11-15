package HundirlaFlota;

import java.util.Scanner;

import static HundirlaFlota.Tableros.imprimirTablerosJugador;

public class Jugador {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] tableroJugador = crearTableroVacio();
        char[][] tableroDisparos = crearTableroVacio();



        int[] barcos = { 4, 3, 2, 1};





    }
    public static void colocarBarcosJugador(char[][] tablero, int[] barcos) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < barcos.length; i++) {
            int longitud = barcos[i];
            int barcosColocados = 0;

            while (barcosColocados < i + 1) {
                System.out.println("Coloca un barco de longitud " + longitud );
                String coordenada = Coordenada.getCoordenada();
                System.out.println("¿Horizontal [H] o vertical [V]");
                String orientacion = sc.next().toUpperCase();

                int fila = coordenada.charAt(0) - 'A';
                int columna = coordenada.charAt(1) - '0';

                if (checkOrientacion(orientacion) && !cabeBarcoJugador(tablero, longitud, fila, columna, orientacion.charAt(0))) {
                    if (!hayColisionJugador(tablero, longitud, coordenada, orientacion)) {
                        colocarBarco(tablero, longitud, fila, columna, orientacion.charAt(0));
                        barcosColocados++;
                     Tableros.imprimirTablerosJugador(tablero,tablero);

                    } else {
                        System.out.println("No se puede colocar el barco debido a colisiones.");
                    }
                } else {
                    System.out.println("La orientación ingresada no hay espacio suficiente. Ingresa 'H' para horizontal o 'V' para vertical.");
                }
            }
        }
    }



    public static char[][] crearTableroVacio() {
        char[][] tablero = new char[10][10];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = '~';
            }
        }
        return tablero;
    }

    public static void imprimirTableroJugador(char[][] tableroJugador) {
      for (int i=0;i<tableroJugador.length;i++)
          for (int j=0;j<tableroJugador[0].length;j++)
              System.out.print(tableroJugador[i][j] +"");

        }









    public static boolean hayColisionJugador(char[][] tablero, int longitud, String coordenada, String orientacion) {
        int fila = coordenada.charAt(0) - 'A';
        int columna = coordenada.charAt(1) - '0';
        char barco = 'B';

        if (orientacion.charAt(0) == 'H') {
            for (int i = 0; i < longitud; i++) {
                if (tablero[fila][columna + i] == barco) {
                    return true;
                }
            }
        }

        if (orientacion.charAt(0) == 'V') {
            for (int i = 0; i < longitud; i++) {
                if (tablero[fila + i][columna] == barco) {
                    return true;
                }
            }
        }

        return false;  // No hay colisión
    }




    public static boolean checkOrientacion(String orientacion) {
        return orientacion.charAt(0) == ('H') || orientacion.charAt(0) == ('V');
    }





    public static boolean cabeBarcoJugador(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion) {
        if (orientacion != 'H') {
            return fila + longitudBarco > tablero.length;
        } else {
            return longitudBarco + columna > tablero[0].length;

        }
    }



    public static void colocarBarco(char[][] tablero, int longitudBarco, int fila, int columna, char orientacion) {
        char barco = 'B';

        if (orientacion == 'H') {
            for (int i = 0; i < longitudBarco; i++) {
                tablero[fila][columna + i] = barco;
            }
        }

        if (orientacion == 'V') {
            for (int i = 0; i < longitudBarco; i++) {
                tablero[fila + i][columna] = barco;
            }
        }
    }
    public static boolean disparoJugador(char[][] tableroDisparosJugador, char[][] tableroPC, int fila, int columna) {
        char agua = 'A';
        char golpeado = 'X';

        // Verificar si ya se ha disparado en esa posición
        if (tableroDisparosJugador[fila][columna] != agua) {
            System.out.println("Ya has disparado en esa posición. Elige otra.");
            return false;
        }

        // Realizar el disparo
        if (tableroPC[fila][columna] != agua) {
            System.out.println("¡Impacto! Barco hundido.");
            tableroDisparosJugador[fila][columna] = golpeado;
        } else {
            System.out.println("Agua.");
            tableroDisparosJugador[fila][columna] = agua;
        }

        return true;
    }
    public static int fila(){
        String orientacionLetra="";
        return Integer.parseInt(String.valueOf((orientacionLetra).charAt(0)=='H'));
    }
    public static int columna(){
        String orientacionNumero="";
        return Integer.parseInt(String.valueOf((orientacionNumero).charAt(0)=='V'));
    }


}




