import java.util.Random;
import java.util.Scanner;

public class HundirLaFlota {

    static final int TAM = 5;
    static final int NUM_BARCOS = 5;

    public static void main(String[] args) {

        int[][] tablero = new int[TAM][TAM];
        Scanner sc = new Scanner(System.in);

        colocarBarcos(tablero);

        int barcosRestantes = NUM_BARCOS;

        System.out.println("BIENVENIDO A HUNDIR LA FLOTA");

        while (barcosRestantes > 0) {
            mostrarTablero(tablero);

            System.out.print("Fila (0-4): ");
            int fila = sc.nextInt();
            System.out.print("Columna (0-4): ");
            int col = sc.nextInt();

            if (fila < 0 || fila >= TAM || col < 0 || col >= TAM) {
                System.out.println(" Coordenadas inválidas");
                continue;
            }

            if (tablero[fila][col] == 1) {
                System.out.println(" ¡TOCADO!");
                tablero[fila][col] = 2;
                barcosRestantes--;
            } else if (tablero[fila][col] == 0) {
                System.out.println("Agua");
                tablero[fila][col] = -1;
            } else {
                System.out.println("Ya disparaste ahí");
            }
        }

        System.out.println("¡HAS HUNDIDO TODA LA FLOTA!");
        sc.close();
    }


    }

