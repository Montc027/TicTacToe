package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicTacToe {

    private static String gameName = "Bienvenido al Juego TicTacToe";

    private static String player = "X";

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    private static String[][] board = {
            { "_", "_", "_" },
            { "_", "_", "_" },
            { "_", "_", "_" }
    };

    private static void paintboard() {
        System.out.print("    ");

        for (int j = 0; j <= 2; j++) {
            System.out.print(j + "   ");
        }
        System.out.println();

        for (int i = 0; i <= 2; i++) {
            System.out.println(" -------------");
            System.out.print(i + " | ");
            for (int j = 0; j <= 2; j++) {
                String cell = board[i][j];
                if (cell.equals("X")) {
                    System.out.print(RED + "X" + RESET + " | ");
                } else if (cell.equals("O")) {
                    System.out.print(BLUE + "O" + RESET + " | ");
                } else {
                    System.out.print(cell + " | ");
                }
            }
            System.out.println();
        }
        System.out.println(" -------------");
    }

    public static void changePlayer() {
        if (TicTacToe.player.equals("X")) {
            TicTacToe.player = "O";
        } else {
            TicTacToe.player = "X";
        }
    }

    private static void printTurn() {
        System.out.println("Turno del jugador: " + TicTacToe.player);
    }

    private static boolean fullBoard() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (!TicTacToe.board[i][j].equals("X") && !TicTacToe.board[i][j].equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean winner() {

        for (int i = 0; i <= 2; i++) {
            if (board[i][0].equals(board[i][1]) &&
                    board[i][1].equals(board[i][2]) &&
                    (board[i][0].equals("X") || board[i][0].equals("O"))) {
                return true;
            }
        }

        for (int i = 0; i <= 2; i++) {
            if (board[0][i].equals(board[1][i]) &&
                    board[1][i].equals(board[2][i]) &&
                    (board[0][i].equals("X") || board[0][i].equals("O"))) {
                return true;
            }
        }

        if (board[0][0].equals(board[1][1]) &&
                board[1][1].equals(board[2][2]) &&
                (board[1][1].equals("X") || board[1][1].equals("O"))) {
            return true;
        }

        if (board[0][2].equals(board[1][1]) &&
                board[1][1].equals(board[2][0]) &&
                (board[1][1].equals("X") || board[1][1].equals("O"))) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(TicTacToe.gameName);
        paintboard();
        Scanner sc = new Scanner(System.in);
        printTurn();

        while (true) {
            System.out.println("Ingresa la fila y columna separados por espacio (fila columna): ");
            String input = sc.nextLine();
            String[] parts = input.trim().split(" ");

            if (parts.length != 2) {
                System.out.println("Formato incorrecto, ingresa fila y columna separados por espacio.");
                continue;
            }

            int fila, columna;
            try {
                fila = Integer.parseInt(parts[0]);
                columna = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar números válidos.");
                continue;
            }

            if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
                System.out.println("Coordenadas fuera de rango (0-2), intenta de nuevo.");
                continue;
            }

            if (board[fila][columna].equals("X") || board[fila][columna].equals("O")) {
                System.out.println("Esa casilla ya está ocupada, elige otra.");
                continue;
            }

            board[fila][columna] = player;
            paintboard();

            if (winner()) {
                if (player.equals("X")) {
                    System.out.println("Felicidades " + RED + "X" + RESET + " has ganado!");
                } else {
                    System.out.println("Felicidades " + BLUE + "O" + RESET + " has ganado!");
                }
                break;
            }

            if (fullBoard()) {
                System.out.println("El tablero está lleno, el juego ha terminado en empate.");
                break;
            }

            changePlayer();
            printTurn();
        }

        sc.close();
    }

}
