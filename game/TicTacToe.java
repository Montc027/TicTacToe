package game;

public class TicTacToe {

    private static String nombreJuego = "Bienvenido al Juego TicTacToe"; 
    
    //cree el tablero
    private static String [][] tablero = {
        {"1","2","3"},
        {"4","2","6"},
        {"7","8","9"}
    };

    //metodo pinte el tablero
    private static void pintartablero(){
        for(int i = 0 ; i <= 2; i++){
            System.out.println(" -------------");
            System.out.print(" | ");
            for(int j = 0 ; j <= 2; j++){
                System.out.print(TicTacToe.tablero[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println(" -------------");
    }

    public static void main(String [] args) {
        System.out.println(TicTacToe.nombreJuego);

        pintartablero();
    }

}
