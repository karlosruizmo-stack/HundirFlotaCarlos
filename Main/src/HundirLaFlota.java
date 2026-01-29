import java.util.Scanner;
import java.util.Random;

public class HundirLaFlota {

    static final int TAM = 5;//Generamos constantes
    static final int NUM_BARCOS = 5;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int[][] tablero1 = new int[TAM][TAM];//Tablero
        int[][] tablero2 = new int[TAM][TAM];

        int barcos1 = NUM_BARCOS;
        int barcos2 = NUM_BARCOS;

        colocarBarcos(tablero1, r);
        colocarBarcos(tablero2, r);

        boolean turnoJugador1 = true;

        System.out.println("HUNDIR LA FLOTA");

        while (true) {

            if (turnoJugador1) {
                System.out.println("TURNO JUGADOR 1");
                mostrarTablero(tablero2);

                if (disparo(sc, tablero2)) {
                    barcos2--;
                    if (barcos2 == 0) {
                        System.out.println(" GANA JUGADOR 1");
                        System.exit(0);
                    }
                }
            } else {
                System.out.println("TURNO JUGADOR 2 ");
                mostrarTablero(tablero1);

                if (disparo(sc, tablero1)) {
                    barcos1--;
                    if (barcos1 == 0) {
                        System.out.println(" GANA JUGADOR 2");
                        System.exit(0);
                    }
                }
            }

            turnoJugador1 = !turnoJugador1;
        }
    }

    static void colocarBarcos(int[][] tablero, Random r) {
        int colocados = 0;

        while (colocados < NUM_BARCOS) {//Reposcionamiento del barco
            int fila = r.nextInt(TAM);
            int col = r.nextInt(TAM);

            if (tablero[fila][col] == 0) {
                tablero[fila][col] = 1;
                colocados++;
            }
        }
    }

    static boolean disparo(Scanner sc, int[][] tablero) {

        System.out.print("Fila (0-4): ");//Apartir de lo siguiente encontramos los diferentes resultados en base a las aaccinoes del jugador
        int fila = sc.nextInt();
        System.out.print("Columna (0-4): ");
        int col = sc.nextInt();

        if (fila < 0 || fila >= TAM || col < 0 || col >= TAM) {
            System.out.println("Coordenadas inválidas");
            return false;
        }

        if (tablero[fila][col] == 1) {
            System.out.println("TOCADO");
            tablero[fila][col] = 2;
            return true;
        } else if (tablero[fila][col] == 0) {
            System.out.println("Agua");
            tablero[fila][col] = -1;
        } else {
            System.out.println("Ya disparaste ahí");
        }

        return false;
    }

    static void mostrarTablero(int[][] tablero) {
        System.out.println("  0 1 2 3 4");
        for (int i = 0; i < TAM; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAM; j++) {
                if (tablero[i][j] == 2) {
                    System.out.print("X ");
                } else if (tablero[i][j] == -1) {
                    System.out.print("~ ");
                } else {
                    System.out.print("? ");
                }
            }
            System.out.println();
        }
    }
}
