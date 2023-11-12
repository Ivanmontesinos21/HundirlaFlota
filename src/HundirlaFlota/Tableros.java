package HundirlaFlota;

public class Tableros {
    public static void main(String[] args) {
        char[][] tableroJugador = crearTablero();
        char[][] tableroDisparos = crearTablero();
        char[][] tableroPC = crearTablero();
        char[][] tableroDisparosPc = crearTablero();


        // Imprimir los tableros
        imprimirTablerosJugador(tableroJugador, tableroDisparos);
        imprimirTablerosPC(tableroPC, tableroDisparosPc);

    }

    // Método para crear un tablero vacío
    public static char[][] crearTablero() {
        char[][] tablero = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = '~';
            }
        }
        return tablero;
    }


    // Método para imprimir los tableros
    public static void imprimirTablerosJugador(char[][] tableroJugador, char[][] tableroDisparos) {

        System.out.println("\t" + "Tablero Jugador " + "\t\t\t" + "Tablero Disparos");
        // Imprimir encabezado con números
        System.out.print("   ");
        for (int i = 0; i < tableroJugador.length; i++) {
            System.out.print(i + " ");
        }
        System.out.print("       ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("     ");

        // Imprimir tablero 1 y tablero 2 lado a lado
        for (int j = 0; j < tableroJugador.length; j++) {
            System.out.print((char) ('A' + j) + "  ");
            for (int i = 0; i < tableroJugador.length; i++) {
                System.out.print(tableroJugador[j][i] + " ");
            }
            System.out.print("    "); // Espacio entre tableros
            System.out.print((char) ('A' + j) + "  ");
            for (int i = 0; i < 10; i++) {
                System.out.print(tableroDisparos[j][i] + " ");
            }
            System.out.println();
        }


        }
        public static void imprimirTablerosPC(char[][] tableroPC,char[][] tableroDisparosPc){
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
        }











