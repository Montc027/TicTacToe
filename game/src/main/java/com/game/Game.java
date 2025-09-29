package com.game;

/* import com.game.Player;
import com.game.Console; */
public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        player1 = new Player("X", "\u001B[31m");
        player2 = new Player("O", "\u001B[34m");
        currentPlayer = player1;
    }

    public void start() {
        Console.println("Bienvenido al Juego TicTacToe");
        printBoard();

        while (true) {
            Console.println(" ");
            Console.println("Turno del jugador: " + currentPlayer.getColor() + currentPlayer.getSymbol() + "\u001B[0m");
            Console.println("Ingresa la fila y columna separados por espacio (fila columna): ");
            String input = Console.readLine();
            String[] parts = input.trim().split(" ");

            if (parts.length != 2) {
                Console.println(" ");
                Console.println("Formato incorrecto, ingresa fila y columna separados por espacio.");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                Console.println(" ");
                Console.println("Debes ingresar números válidos.");
                continue;
            }

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                Console.println("Coordenadas fuera de rango (0-2), intenta de nuevo.");
                continue;
            }

            if (!board.isCellEmpty(row, col)) {
                Console.println(" ");
                Console.println("Esa casilla ya está ocupada, elige otra.");
                continue;
            }0 

            board.placeSymbol(row, col, currentPlayer.getSymbol());
            printBoard();

            if (board.hasWinner()) {
                Console.println("Felicidades " + currentPlayer.getColor() + currentPlayer.getSymbol() + "\u001B[0m has ganado!");
                Player opponent = currentPlayer == player1 ? player2 : player1;
                Console.println("Suerte para la próxima jugador " + opponent.getColor() + opponent.getSymbol() + "\u001B[0m");
                break;
            }

            if (board.isFull()) {
                Console.println("El tablero está lleno, el juego ha terminado en empate.");
                break;
            }

            switchPlayer();
        }

        Console.close();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void printBoard() {
        Console.print("    0   1   2\n");
        for (int i = 0; i < 3; i++) {
            Console.print(" -------------\n");
            Console.print(i + " | ");
            for (int j = 0; j < 3; j++) {
                String cell = board.getCells()[i][j];
                if (cell.equals("X")) {
                    Console.print(player1.getColor() + "X\u001B[0m | ");
                } else if (cell.equals("O")) {
                    Console.print(player2.getColor() + "O\u001B[0m | ");
                } else {
                    Console.print(cell + " | ");
                }
            }
            Console.print("\n");
        }
        Console.print(" -------------\n");
    }
}
