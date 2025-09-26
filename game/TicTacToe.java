package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicTacToe {

    private static String gameName = "Bienvenido al Juego TicTacToe";

    private static String player = "X";

    // cree el tablero
    private static String[][] board = {
            { "1", "2", "3" },
            { "4", "5", "6" },
            { "7", "8", "9" }
    };

    private static Map<Integer, Integer[]> positions = new HashMap<>();

    // Metodo cargar posisciones
    private static void enterPositions() {
        TicTacToe.positions.put(1, new Integer[] { 0, 0 });
        TicTacToe.positions.put(2, new Integer[] { 0, 1 });
        TicTacToe.positions.put(3, new Integer[] { 0, 2 });
        TicTacToe.positions.put(4, new Integer[] { 1, 0 });
        TicTacToe.positions.put(5, new Integer[] { 1, 1 });
        TicTacToe.positions.put(6, new Integer[] { 1, 2 });
        TicTacToe.positions.put(7, new Integer[] { 2, 0 });
        TicTacToe.positions.put(8, new Integer[] { 2, 1 });
        TicTacToe.positions.put(9, new Integer[] { 2, 2 });
    }

    // metodo pinte el tablero
    private static void paintboard() {
        for (int i = 0; i <= 2; i++) {
            System.out.println(" -------------");
            System.out.print(" | ");
            for (int j = 0; j <= 2; j++) {
                System.out.print(TicTacToe.board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println(" -------------");
    }

    public static void changePlayer(){
        if (TicTacToe.player.equals("X")){
            TicTacToe.player = "O";
        } else {
            TicTacToe.player = "X";
        }
    }

    private static boolean fullBoard(){
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (!TicTacToe.board[i][j].equals("X") && !TicTacToe.board[i][j].equals("O")){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean winner(){
    
        for (int i = 0; i <= 2; i++) {
            if(TicTacToe.board[i][0].equals(TicTacToe.board[i][1]) && TicTacToe.board[i][1].equals(TicTacToe.board[i][2])) {
                return true;
        }
    }

    for (int i = 0; i <= 2; i++) {
            if(TicTacToe.board[0][i].equals(TicTacToe.board[1][i]) && TicTacToe.board[i][i].equals(TicTacToe.board[2][i])) {
                return true;
        }

    }

    return false;

    }

    public static void main(String[] args) {
        System.out.println(TicTacToe.gameName);
        enterPositions();
        paintboard();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("ingresa la posición a jugar");
            int chosenPosition = sc.nextInt();

            if (!TicTacToe.positions.containsKey(chosenPosition)) {
                System.out.println("posición no valida, elige otra");
                continue;
            }

            System.out.println("tu posición elegida es: " + chosenPosition);
            Integer[] coordinates = TicTacToe.positions.get(chosenPosition);

            if (TicTacToe.board[coordinates[0]][coordinates[1]].equals("X") || TicTacToe.board[coordinates[0]][coordinates[1]].equals("O")) {
                System.out.println("posición ya ocupada, elige otra");
                continue;
            }

            TicTacToe.board[coordinates[0]][coordinates[1]] = TicTacToe.player;
            paintboard();
            if (fullBoard()){
                System.out.println("El tablero esta lleno, el juego ha terminado en empate");
                break;
            }
            changePlayer();

            if (winner()){
                System.out.println("Felicidades jugador: " + TicTacToe.player + " has ganado!");
                break;
            }
        }


        
        sc.close();
    }

}
