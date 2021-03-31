package com.twaran.battleShip;

import java.util.ArrayList;

public class Computer {
    ArrayList<Ship> listOfShipsOnBoard = new ArrayList<>();

    public Board createShipsOnBoard(Board board) {
        System.out.println("Setting the Ships in positions");
        Ship carrier = new Ship("Carrier", 5);
        Ship battleShip = new Ship("BattleShip", 4);
        Ship cruiser = new Ship("Cruiser", 3);
        Ship subMarine = new Ship("SubMarine", 3);
        Ship destroyer = new Ship("Destroyer", 2);

        board.placeShipRandomlyOnBoard(carrier, this);
        board.placeShipRandomlyOnBoard(battleShip, this);
        board.placeShipRandomlyOnBoard(cruiser, this);
        board.placeShipRandomlyOnBoard(subMarine, this);
        board.placeShipRandomlyOnBoard(destroyer, this);

        return board;
    }
}
