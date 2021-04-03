package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    @Test
    void shouldPlaceShipInHorizontalDirectionWhenSetShipInHorizontalPositionIsCalled() {
        Board board = new Board(3, 3);
        Ship ship = new Ship("Destroyer", 2);

        board.setBoard();

        int xCoordinate = 0;
        int yCoordinate = 0;

        ship.setShipInHorizontalPosition(xCoordinate, yCoordinate, board);

        assertEquals(board.ship, board.board[xCoordinate][yCoordinate + 1]);
    }

    @Test
    void shouldPlaceShipInVerticalDirectionWhenSetShipInVerticalPositionIsCalled() {
        Board board = new Board(3, 3);
        Ship ship = new Ship("Destroyer", 2);

        board.setBoard();

        int xCoordinate = 0;
        int yCoordinate = 0;

        ship.setShipInVerticalPosition(xCoordinate, yCoordinate, board);

        assertEquals(board.ship, board.board[xCoordinate + 1][yCoordinate]);
    }

    @Test
    void shouldReturnListOfShipsOnBoardIsZeroIfAllShipsAreSunk() {
        Board board = new Board(3, 3);
        Ship ship = new Ship("Destroyer", 2);
        Computer computer = new Computer();
        Player player = new Player();

        board.setBoard();
        board.placeShipRandomlyOnBoard(ship, computer);

        int expectedNoOfShipsOnBoard = 0;

        player.shootShip(ship.shipLocation[0], ship.shipLocation[1], board);
        player.shootShip(ship.shipLocation[2], ship.shipLocation[3], board);

        assertEquals(expectedNoOfShipsOnBoard, computer.listOfShipsOnBoard.size());
    }

    @Test
    void shouldIndicateTheSunkShipsOnBoardWhenShipIsSunk() {
        Board board = new Board(3, 3);
        Ship ship = new Ship("Destroyer", 2);
        Computer computer = new Computer();
        Player player = new Player();
        board.setBoard();
        board.placeShipRandomlyOnBoard(ship, computer);

        player.shootShip(ship.shipLocation[0], ship.shipLocation[1], board);
        player.shootShip(ship.shipLocation[2], ship.shipLocation[3], board);

        assertEquals(board.sink, board.board[ship.shipLocation[0]][ship.shipLocation[1]]);
    }
}