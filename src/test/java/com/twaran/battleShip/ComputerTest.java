package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @Test
    void shouldCreateFiveShipsAndPlaceThemOnBoardWhenCreateShipOnBoardIsCalled() {
        Computer computer = new Computer();
        Board board = new Board(10, 10);

        board.setBoard();

        computer.createShipsOnBoard(board);

        int totalNoOfShipsToBePlaced = 5;

        assertEquals(totalNoOfShipsToBePlaced, computer.listOfShipsOnBoard.size());
    }
}