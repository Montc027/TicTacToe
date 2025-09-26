package game.src.main.java.com.game;

public class Player {
    private final String symbol;
    private final String color;

    public Player(String symbol, String color) {
        this.symbol = symbol;
        this.color = color;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }
}
