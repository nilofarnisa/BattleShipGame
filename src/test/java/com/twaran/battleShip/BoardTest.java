package com.twaran.battleShip;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldReturnThePlayerBoardWhenPrintBoardIsCalled() {
        Board board = new Board(2, 2);
        board.setBoard();
        board.printBoard();
        assertEquals("Setting the board....\n" + "Board Set\n     A B \n  1| ~ ~ |\n  2| ~ ~ |\n\n", outContent.toString());
    }

    @Test
    void shouldPlaceShipRandomlyOnBoard() {
        Board board = new Board(5, 5);
        Ship ship = new Ship("BattleShip", 3);
        Computer computer = new Computer();

        board.setBoard();
        board.placeShipRandomlyOnBoard(ship, computer);

        assertEquals(1, computer.listOfShipsOnBoard.size());
    }

    @Test
    void shouldReturnTrueIfShipIsHit() {
        Board board = new Board(5, 5);
        Ship ship = new Ship("BattleShip", 3);
        Computer computer = new Computer();

        board.setBoard();
        board.placeShipRandomlyOnBoard(ship, computer);

        int xCoordinate = ship.shipLocation[0];
        int yCoordinate = ship.shipLocation[1];
        boolean shipHit = board.isShipHit(xCoordinate, yCoordinate);

        assertTrue(shipHit);
    }

    @Test
    void shouldReturnFalseIfShipIsNotHit() {
        Board board = new Board(5, 5);
        Ship ship = new Ship("BattleShip", 3);
        Computer computer = new Computer();

        board.setBoard();
        board.placeShipRandomlyOnBoard(ship, computer);

        int xCoordinate = 0;
        int yCoordinate = 0;

        while (Arrays.asList(ship.shipLocation).contains(xCoordinate)) {
            xCoordinate++;
        }

        boolean shipHit = board.isShipHit(xCoordinate, yCoordinate);

        assertFalse(shipHit);
    }
}