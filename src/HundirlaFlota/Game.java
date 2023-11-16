package HundirlaFlota;

import static HundirlaFlota.PC.colocarBarcosAleatoriosPC;
import static HundirlaFlota.Tableros.crearTablero;
import static HundirlaFlota.Tableros.imprimirTablerosJugador;
import  static HundirlaFlota.Tableros.imprimirTablerosPC;
import static HundirlaFlota.Jugador.colocarBarcosJugador;


public class Game {
    public static void main(String[] args) {
        char[][] tableroJugador = crearTablero();
        char[][] tableroDisparos = crearTablero();
        char[][] tableroPC = crearTablero();
        char[][] tableroDisparosPc = crearTablero();
        int[] barcos = {  4,3,2, 1};
        imprimirTablerosJugador(tableroJugador,tableroDisparos);
        imprimirTablerosPC(tableroPC,tableroDisparosPc);
        colocarBarcosJugador(tableroJugador,barcos);
      imprimirTablerosJugador(tableroJugador,tableroDisparos);
        System.out.println();
        System.out.println();
        System.out.println();
        colocarBarcosAleatoriosPC(tableroPC,barcos);



    }
}