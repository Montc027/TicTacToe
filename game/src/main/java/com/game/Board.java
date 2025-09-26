package game.src.main.java.com.game;

public class Board {
    private final String[][] cells;

    public Board() {
        cells = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = "_";
            }
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return cells[row][col].equals("_");
    }

    public void placeSymbol(int row, int col, String symbol) {
        cells[row][col] = symbol;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].equals("_")) return false;
            }
        }
        return true;
    }

    public boolean hasWinner() {
        // Filas
        for (int i = 0; i < 3; i++) {
            if (!cells[i][0].equals("_") &&
                cells[i][0].equals(cells[i][1]) &&
                cells[i][1].equals(cells[i][2])) {
                return true;
            }
        }
        // Columnas
        for (int j = 0; j < 3; j++) {
            if (!cells[0][j].equals("_") &&
                cells[0][j].equals(cells[1][j]) &&
                cells[1][j].equals(cells[2][j])) {
                return true;
            }
        }
        // Diagonales
        if (!cells[1][1].equals("_")) {
            if (cells[0][0].equals(cells[1][1]) && cells[1][1].equals(cells[2][2])) return true;
            if (cells[0][2].equals(cells[1][1]) && cells[1][1].equals(cells[2][0])) return true;
        }
        return false;
    }

    public String[][] getCells() {
        return cells;
    }
}
