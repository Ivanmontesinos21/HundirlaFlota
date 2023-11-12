package HundirlaFlota;

import static HundirlaFlota.Tableros.crearTablero;

public class Game {
    public static void main(String[] args) {
        char[][] tableroJugador = crearTablero();
        char[][] tableroDisparos = crearTablero();
        char[][] tableroPC = crearTablero();
        char[][] tableroDisparosPc = crearTablero();
        int[] barcos = {5, 4, 3, 2, 1};

        Tableros.imprimirTablerosJugador(tableroJugador,tableroDisparos);
        Tableros.imprimirTablerosPC(tableroPC,tableroDisparosPc);
        Jugador.colocarBarcosJugador(tableroJugador,barcos);
        System.out.println("Los barcos han sido colocados");
        PC.colocarBarcosAleatoriosPC(tableroPC,barcos);
    }
}