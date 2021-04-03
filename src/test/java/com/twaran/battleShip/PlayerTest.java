package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void shouldReturnShotAlreadyIfAlreadyShotCoordinateIsAgainShot() {
        Board board = new Board(2, 2);
        Player player = new Player();

        board.setBoard();

        player.shootShip(0, 0, board);

        assertEquals("Shot Already , Choose other co-ordinates", player.shootShip(0, 0, board));
    }

    @Test
    void shouldReturnHitIfChosenCoordinatesContainsShip() {
        Player player = new Player();
        Board board = new Board(2, 2);
        Ship ship = new Ship("BattleShip", 2);
        Computer computer = new Computer();

        board.setBoard();
        board.placeShipRandomlyOnBoard(ship, computer);

        int xCoordinate = ship.shipLocation[0];
        int yCoordinate = ship.shipLocation[1];

        assertEquals("HIT", player.shootShip(xCoordinate, yCoordinate, board));
    }

    @Test
    void shouldReturnMISSIfChosenCoordinatesContainsNoShip() {
        Player player = new Player();
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

        assertEquals("MISS", player.shootShip(xCoordinate, yCoordinate, board));
    }

}