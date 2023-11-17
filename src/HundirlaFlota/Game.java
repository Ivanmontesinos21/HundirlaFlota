package HundirlaFlota;

import java.util.Scanner;

import static HundirlaFlota.Coordenada.PedirCoordenadaDisparoNumero;
import static HundirlaFlota.Jugador.*;
import static HundirlaFlota.PC.colocarBarcosAleatoriosPC;
import static HundirlaFlota.PC.disparoPC;
import static HundirlaFlota.Tableros.crearTablero;
import static HundirlaFlota.Tableros.imprimirTablerosJugador;
import static HundirlaFlota.Tableros.imprimirTablerosPC;


public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] tableroJugador = crearTablero();
        char[][] tableroDisparos = crearTablero();
        char[][] tableroPC = crearTablero();
        char[][] tableroDisparosPC = crearTablero();
        int[] barcos = {4, 3, 2, 1};


        System.out.println("¡Bienvenido a Hundir la Flota!");


        imprimirTablerosJugador(tableroJugador, tableroDisparos);
        imprimirTablerosPC(tableroPC, tableroDisparosPC);


        // Colocación de barcos del jugador
        System.out.println("Coloca tus barcos:");
        colocarBarcosJugador(tableroJugador, barcos);

        System.out.println("\n" + "Barcos colocados! Esperando a que la PC coloque sus barcos.");
        System.out.println();
        borrarPantalla();

        // Colocación de barcos de la PC
        colocarBarcosAleatoriosPC(tableroPC, barcos);
        System.out.println("La PC ha colocado sus barcos.");
        borrarPantalla();

        // Comienza la partida
        System.out.println("¡Comienza la partida!");

        while (hayBarcos(tableroJugador) && hayBarcos(tableroPC)) {
            // Turno del jugador
            System.out.println("¡Es tu turno! Realiza tu disparo:");
            disparoJugador(tableroDisparos, tableroPC, Coordenada.PedirCoordenadaDisparoLetra(), PedirCoordenadaDisparoNumero());
            imprimirTablerosJugador(tableroJugador, tableroDisparos);


            // Comprobar si el jugador ha ganado antes de pasar al turno de la PC
            if (!hayBarcos(tableroPC)) {
                System.out.println("¡Felicidades! Has hundido la flota de la PC. ¡Eres el ganador!");
                break; // Salir del bucle ya que el jugador ha ganado
            }

            // Turno de la PC
            System.out.println("Turno de la PC:");
            disparoPC(tableroDisparosPC, tableroJugador);
            PC.imprimirTablerosPC(tableroPC, tableroDisparosPC);


            // Comprobar si la PC ha ganado antes de pasar al siguiente turno del jugador
            if (!hayBarcos(tableroJugador)) {
                System.out.println("¡La PC ha hundido tu flota! Has perdido.");
                break; // Salir del bucle ya que la PC ha ganado
            }

            borrarPantalla();
        }
    }


    public static boolean hayBarcos(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 'B') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}