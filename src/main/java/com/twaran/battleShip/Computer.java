package com.twaran.battleShip;

import static java.lang.Math.random;

public class Computer {
    public static Ship shipObj = new Ship();
    public Board boardObject = BattleShipGame.gameBoard;

    public void setShip() {
        for (int ship = 0; ship < shipObj.noOfShips; ) {
            int xCoordinate = (int) (random() * 10);
            int yCoordinate = (int) (random() * 10);
            int direction = (int) (random() * 2);
            shipObj.isShipPlaced = false;

            if (boardObject.board[xCoordinate][yCoordinate].equals("0")) {
                shipObj.shipPointsFilled = 0;
                if (direction == 0) {
                    shipObj.setShipInVerticalPosition(xCoordinate, yCoordinate, ship);
                } else {
                    shipObj.setShipInHorizontalPosition(xCoordinate, yCoordinate, ship);
                }
                if (shipObj.isShipPlaced) {
                    System.out.println("Ship" + (ship + 1) + " deployed");
                    ship++;
                }
            }
        }
        /*for (int row = 0; row < boardObject.board.length; row++) {
            System.out.print("| ");
            for (int column = 0; column < boardObject.board[row].length; column++) {
                System.out.print(boardObject.board[row][column] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < shipObj.noOfShips; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(shipObj.shipCoordinates[i][j] + " ");
            }
            System.out.println();
        }*/
    }

}
