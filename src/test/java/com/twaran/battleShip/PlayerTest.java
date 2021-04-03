package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void shouldReturnShotAlreadyIfAlreadyShotCoordinateIsAgainShot() {
        Board board = new Board(2,2);
        board.setBoard();
        Player player = new Player();

        player.shootShip(0,0,board);

        assertEquals("Shot Already , Choose other co-ordinates",player.shootShip(0,0,board));
    }

    @Test
    void shouldReturnHitIfChosenCoordinatesContainsShip() {
        Player player = new Player();
        Board board = new Board(2,2);
        Ship ship = new Ship("BattleShip", 2);
        Computer computer = new Computer();
        board.setBoard();
        board.placeShipRandomlyOnBoard(ship, computer);

        int xCoordinate = ship.shipLocation[0];
        int yCoordinate = ship.shipLocation[1];

        assertEquals("HIT",player.shootShip(xCoordinate,yCoordinate,board));
    }

}