package com.twaran.battleShip;

import static java.lang.Math.random;

public class Computer {
    Ship shipObject = new Ship();
    Board boardObject = new Board();

    void setShip() {
        for (int ship = 0; ship < shipObject.noOfShips; ) {
            int xCoordinate = (int) (random() * 10);
            int yCoordinate = (int) (random() * 10);
            int direction = (int) (random() * 2);
            shipObject.isShipPlaced = false;

            if (boardObject.board[xCoordinate][yCoordinate].equals("0")) {
                shipObject.shipPointsFilled = 0;
                if (direction == 0) {
                    shipObject.setShipInVerticalPosition(xCoordinate, yCoordinate, ship);
                } else {
                    shipObject.setShipInHorizontalPosition(xCoordinate, yCoordinate, ship);
                }
                if (shipObject.isShipPlaced) {
                    System.out.println("Ship" + (ship + 1) + " deployed");
                    ship++;
                }
            }
        }
        for (int row = 0; row < boardObject.board.length; row++) {
            System.out.print("| ");
            for (int column = 0; column < boardObject.board[row].length; column++) {
                System.out.print(boardObject.board[row][column] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < shipObject.noOfShips; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(shipObject.shipCoordinates[i][j] + " ");
            }
            System.out.println();
        }
    }

}
