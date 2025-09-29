package com.game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(); // Tablero limpio antes de cada test
    }

    @Test
    void testHorizontalWin() {
        board.placeSymbol(0, 0, "X");
        board.placeSymbol(0, 1, "X");
        board.placeSymbol(0, 2, "X");
        assertTrue(board.hasWinner(), "Debe detectar victoria horizontal en fila 0");
    }

    @Test
    void testVerticalWin() {
        board.placeSymbol(0, 1, "O");
        board.placeSymbol(1, 1, "O");
        board.placeSymbol(2, 1, "O");
        assertTrue(board.hasWinner(), "Debe detectar victoria vertical en columna 1");
    }

    @Test
    void testDiagonalWinPrincipal() {
        board.placeSymbol(0, 0, "X");
        board.placeSymbol(1, 1, "X");
        board.placeSymbol(2, 2, "X");
        assertTrue(board.hasWinner(), "Debe detectar victoria en diagonal principal");
    }

    @Test
    void testDiagonalWinInversa() {
        board.placeSymbol(0, 2, "O");
        board.placeSymbol(1, 1, "O");
        board.placeSymbol(2, 0, "O");
        assertTrue(board.hasWinner(), "Debe detectar victoria en diagonal inversa");
    }

    @Test
    void testNoWinnerYet() {
        board.placeSymbol(0, 0, "X");
        board.placeSymbol(1, 1, "O");
        assertFalse(board.hasWinner(), "No debe haber ganador aún");
    }

    @Test
    void testBoardNotFull() {
        assertFalse(board.isFull(), "El tablero recién creado no debe estar lleno");
    }

    @Test
    void testBoardIsFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.placeSymbol(i, j, "X");
            }
        }
        assertTrue(board.isFull(), "El tablero debe estar lleno");
    }
}