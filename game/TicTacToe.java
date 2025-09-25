package game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicTacToe {

    private static String gameName = "Bienvenido al Juego TicTacToe"; 

    private static String player = "X";
    
    //cree el tablero
    private static String [][] board = {
        {"1","2","3"},
        {"4","2","6"},
        {"7","8","9"}
    };

    private static Map<Integer, Integer[]> positions = new HashMap<>();

    //Metodo cargar posisciones
    private static void enterPositions(){
        TicTacToe.positions.put(1,new Integer[]{0,0});
        TicTacToe.positions.put(2,new Integer[]{0,1});
        TicTacToe.positions.put(3,new Integer[]{0,2});
        TicTacToe.positions.put(4,new Integer[]{1,0});
        TicTacToe.positions.put(5,new Integer[]{1,1});
        TicTacToe.positions.put(6,new Integer[]{1,2});
        TicTacToe.positions.put(7,new Integer[]{2,0});
        TicTacToe.positions.put(8,new Integer[]{2,1});
        TicTacToe.positions.put(9,new Integer[]{2,2});
    }

    //metodo pinte el tablero
    private static void paintboard(){
        for(int i = 0 ; i <= 2; i++){
            System.out.println(" -------------");
            System.out.print(" | ");
            for(int j = 0 ; j <= 2; j++){
                System.out.print(TicTacToe.board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println(" -------------");
    }

    public static void main(String [] args) {
        System.out.println(TicTacToe.gameName);
        enterPositions();
        paintboard();

        System.out.println("ingresa la posición a jugar");
        Scanner sc = new Scanner(System.in);
        int chosenPosition = sc.nextInt();
        System.out.println("tu posición elegida es: " + chosenPosition);

        Integer[] cordinates = TicTacToe.positions.get(chosenPosition);


        TicTacToe.board[cordinates[0]][cordinates[1]] = TicTacToe.player;

        paintboard();
    }

}
