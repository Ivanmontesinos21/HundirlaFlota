package HundirlaFlota;



public class PC {


    public static void main(String[] args) {


    }

    public static void colocarBarcosAleatoriosPC(char[][] tableroPC, int[] barcos) {
        for (int i = 0; i < barcos.length; i++) {
            int longitud = barcos[i];
            boolean colocado = false;

            while (!colocado) {
                int fila = (int) (Math.random() * 10);  // Generar fila aleatoria entre A-J
                int columna = (int) (Math.random() * 10);  // Generar columna aleatoria 0-9
                String orientacion = (Math.random() < 0.5) ? "H" : "V";  // Generar orientación aleatoria

                if (cabeBarcoPC(tableroPC, longitud, fila, columna, orientacion)
                        && !hayColisionPC(tableroPC, longitud, fila, columna, orientacion)) {
                    colocarBarcoPC(tableroPC, longitud, fila, columna, (orientacion));
                    colocado = true;

                }

            }
        }
    }

    public static boolean cabeBarcoPC(char[][] tablero, int longitudBarco, int fila, int columna, String orientacion) {
        if (orientacion.equals("V")) {
            return fila + longitudBarco <= tablero.length;
        } else if (orientacion.equals("H")) {
            return columna + longitudBarco <= tablero[0].length;
        }
        return false;
    }

    public static boolean hayColisionPC(char[][] tablero, int longitud, int fila, int columna, String orientacion) {
        char barco = 'B';

        if (orientacion.equals("H")) {
            for (int i = 0; i < longitud; i++) {
                if (tablero[fila][columna + i] == barco) {
                    return true; // Colisión detectada
                }
            }
        } else if (orientacion.equals("V")) {
            for (int i = 0; i < longitud; i++) {
                if (tablero[fila + i][columna] == barco) {
                    return true; // Colisión detectada
                }
            }
        }

        return false; // No hay colisión
    }

    public static void colocarBarcoPC(char[][] tablero, int longitudBarco, int fila, int columna, String orientacion) {
        char barco = 'B';

        if (orientacion.equals("H")) {
            for (int i = 0; i < longitudBarco; i++) {
                tablero[fila][columna + i] = barco;
            }
        } else if (orientacion.equals("V")) {
            for (int i = 0; i < longitudBarco; i++) {
                tablero[fila + i][columna] = barco;
            }
        }
    }

    public static void imprimirTablerosPC(char[][] tableroPC, char[][] tableroDisparosPc) {
        System.out.println();
        System.out.println("\t\t" + "Tablero PC " + "\t\t\t\t" + "Tablero DisparosPC");
        // Imprimir encabezado con números
        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.print("       ");
        for (int j = 0; j < 10; j++) {
            System.out.print(j + " ");
        }
        System.out.println("     ");

        // Imprimir tablero Pc y TableroDisparosPC lado a lado
        for (int j = 0; j < 10; j++) {
            System.out.print((char) ('A' + j) + "  ");
            for (int i = 0; i < tableroPC.length; i++) {
                System.out.print(tableroPC[j][i] + " ");
            }
            System.out.print("    "); // Espacio entre tableros
            System.out.print((char) ('A' + j) + "  ");
            for (int i = 0; i < 10; i++) {
                System.out.print(tableroDisparosPc[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static boolean disparoPC(char[][] tableroDisparosPC, char[][] tableroJugador) {
        char agua = '~';
        char impacto = 'X';
        char fallo='o';

        // Elegir una posición aleatoria
        int fila = (int) (Math.random() * tableroDisparosPC.length);
        int columna = (int) (Math.random() * tableroDisparosPC[0].length);

        // Verificar si ya se ha disparado en esa posición
        if (tableroDisparosPC[fila][columna] != agua) {

            System.out.println("Ya se ha disparado aqui ");
            return false;
        }
            // Realizar el disparo
            if (tableroJugador[fila][columna] != agua) {
                System.out.println("¡La PC ha impactado en tus barcos en la posición " + (char) ('A' + fila) + columna + "!");
                tableroDisparosPC[fila][columna] = impacto;

                // Marcar como impactado en el tablero del jugador
                tableroJugador[fila][columna] = impacto;
            } else {
                System.out.println("La PC ha disparado al agua en la posición " + (char) ('A' + fila) + columna + ".");
                tableroDisparosPC[fila][columna] = fallo;
                tableroJugador[fila][columna]=fallo;
            }
            return true;  // Se realizó el disparo
        }


    }






