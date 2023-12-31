package HundirlaFlota;

import java.util.Scanner;

import static HundirlaFlota.Tableros.imprimirTablerosJugador;

public class Jugador {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] tableroJugador = crearTableroVacio();
        char[][] tableroDisparos = crearTableroVacio();
        imprimirTablerosJugador(tableroJugador, tableroDisparos);

        int[] barcos = {4, 3, 2, 1};
        colocarBarcosJugador(tableroJugador, barcos);

    }

    public static void colocarBarcosJugador(char[][] tablero, int[] barcos) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < barcos.length; i++) {
            int longitud = barcos[i];
            int barcosColocados = 0;

            while (barcosColocados < 1) {
                System.out.println("Coloca un barco de longitud " + longitud);
                String coordenada = Coordenada.getCoordenada();
                System.out.println("¿Horizontal [H] o vertical [V]?");
                String orientacion = sc.next().toUpperCase();

                int fila = coordenada.charAt(0) - 'A';
                int columna = coordenada.charAt(1) - '0';

                if (checkOrientacion(orientacion) && !cabeBarcoJugador(tablero, longitud, fila, columna, orientacion.charAt(0))) {
                    if (!hayColisionJugador(tablero, longitud, coordenada, orientacion)) {
                        colocarBarco(tablero, longitud, fila, columna, orientacion.charAt(0));
                        barcosColocados++;


                    } else {
                        System.out.println("El barco que intentas poner va a colisionar . Ponlo en otro espacio");
                    }
                } else {
                    System.out.println("Te estas saliendo del tablero.Introducelo en las coordenadas del tablero");
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
        for (int i = 0; i < tableroJugador.length; i++)
            for (int j = 0; j < tableroJugador[0].length; j++)
                System.out.print(tableroJugador[i][j] + "");

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
        char agua = '~';
        char impacto = 'X';
        char fallo='o';

        // Verificar si ya se ha disparado en esa posición
        if (tableroDisparosJugador[fila][columna] != agua) {
            System.out.println("Ya has disparado en esa posición. Elige otra.");
            return false;
        }

        // Realizar el disparo
        if (tableroPC[fila][columna] != agua) {
            System.out.println("¡Impacto!");

            // Marcar como impactado en el tablero de la PC
            tableroPC[fila][columna] = impacto;

            tableroDisparosJugador[fila][columna] = impacto;
        } else {
            System.out.println("Agua.");
            tableroDisparosJugador[fila][columna] = fallo;
            tableroPC[fila][columna]=fallo;
        }

        return true;
    }
}


