package HundirlaFlota;

import static HundirlaFlota.Tableros.crearTablero;

public class Game {
    public static void main(String[] args) {
        char[][] tableroJugador = crearTablero();
        char[][] tableroDisparos = crearTablero();
        char[][] tableroPC = crearTablero();
        char[][] tableroDisparosPc = crearTablero();
        int[] barcos = {  4,3,2, 1};

        Tableros.imprimirTablerosJugador(tableroJugador,tableroDisparos);

     Tableros.imprimirTablerosPC(tableroPC,tableroDisparosPc);
        System.out.println();
       Jugador.colocarBarcosJugador(tableroJugador,barcos);
      Tableros.imprimirTablerosJugador(tableroJugador,tableroDisparos);
     System.out.println("Los barcos han sido colocados");
        PC.colocarBarcosAleatoriosPC(tableroPC,barcos);
        Tableros.imprimirTablerosPC(tableroPC,tableroDisparosPc);
        Jugador.disparoJugador(tableroDisparos,tableroPC,Jugador.fila(),Jugador.columna());
        PC.disparoPC(tableroDisparosPc,tableroJugador);

    }
}