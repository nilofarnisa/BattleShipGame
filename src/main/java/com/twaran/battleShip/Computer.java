package com.twaran.battleShip;

import java.util.ArrayList;

import static java.lang.Math.random;

public class Computer {
    public Board boardObject = BattleShipGame.gameBoard;
    ArrayList<Ship> shipRemaining = new ArrayList<>();

    public void setShip(Ship shipObj) {
        while (!shipObj.isShipPlaced) {
            int xCoordinate = (int) (random() * boardObject.noOfRows);
            int yCoordinate = (int) (random() * boardObject.noOfCols);
            int direction = (int) (random() * 2);

            if (boardObject.board[xCoordinate][yCoordinate].equals("0")) {
                shipObj.shipPointsFilled = 0;
                if (direction == 0) {
                    shipObj.setShipInVerticalPosition(xCoordinate, yCoordinate);
                } else {
                    shipObj.setShipInHorizontalPosition(xCoordinate, yCoordinate);
                }
                if (shipObj.isShipPlaced) {
                    System.out.println("Ship" + shipObj.shipName + " deployed");
                }
            }
        }
    }

    // TODO, How does Computer decide how many certain Ships to create? Some better way to make this dynamic and customizable
    public void createShip() {
        Ship carrier = new Ship("Carrier", 5);
        setShip(carrier);
        shipRemaining.add(carrier);
        Ship battleShip = new Ship("BattleShip", 4);
        setShip(battleShip);
        shipRemaining.add(battleShip);
        Ship cruiser = new Ship("Cruiser", 3);
        setShip(cruiser);
        shipRemaining.add(cruiser);
        Ship subMarine = new Ship("SubMarine", 3);
        setShip(subMarine);
        shipRemaining.add(subMarine);
        Ship destroyer = new Ship("Destroyer", 2);
        setShip(destroyer);
        shipRemaining.add(destroyer);
    }
}
