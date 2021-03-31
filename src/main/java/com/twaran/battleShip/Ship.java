package com.twaran.battleShip;

public class Ship {

    public Board boardObject = BattleShipGame.gameBoard;
    public Computer computerObject = BattleShipGame.computer;

    int pointsFilled;
    final int noOfCoordinates = 4;
    boolean isOnBoard;
    public String shipName;
    public int shipSize;
    int[] shipLocation = new int[noOfCoordinates];

    public Ship(String shipName, int shipSize) {
        this.shipName = shipName;
        this.shipSize = shipSize;
    }

    void setShipInHorizontalPosition(int xCoordinate, int yCoordinate) {
        for (int currentYCoordinate = yCoordinate; currentYCoordinate < yCoordinate + shipSize && currentYCoordinate < boardObject.noOfCols; currentYCoordinate++) {
            if (!boardObject.board[xCoordinate][currentYCoordinate].equals("0"))
                break;
            else
                pointsFilled++;
        }
        if (pointsFilled == shipSize) {
            isOnBoard = true;
            for (int yPositionOfShip = yCoordinate; yPositionOfShip < yCoordinate + shipSize; yPositionOfShip++)
                boardObject.board[xCoordinate][yPositionOfShip] = "1";
            shipLocation[0] = xCoordinate;
            shipLocation[1] = yCoordinate;
            shipLocation[2] = xCoordinate;
            shipLocation[3] = yCoordinate + shipSize - 1;
        }
    }

    void setShipInVerticalPosition(int xCoordinate, int yCoordinate) {
        for (int currentXCoordinate = xCoordinate; currentXCoordinate < xCoordinate + shipSize && currentXCoordinate < boardObject.noOfRows; currentXCoordinate++) {
            if (!boardObject.board[currentXCoordinate][yCoordinate].equals("0"))
                break;
            else
                pointsFilled++;
        }
        if (pointsFilled == shipSize) {
            isOnBoard = true;
            for (int xPositionOfShip = xCoordinate; xPositionOfShip < xCoordinate + shipSize; xPositionOfShip++)
                boardObject.board[xPositionOfShip][yCoordinate] = "1";
            shipLocation[0] = xCoordinate;
            shipLocation[1] = yCoordinate;
            shipLocation[2] = xCoordinate + shipSize - 1;
            shipLocation[3] = yCoordinate;
        }
    }

    boolean isSink() {
        int shipCoordinatesHit = 0;
        int isShipHit = 1;
        for (int xPositionOfShip = shipLocation[0]; xPositionOfShip <= shipLocation[2]; xPositionOfShip++) {
            for (int yPositionOfShip = shipLocation[1]; yPositionOfShip <= shipLocation[3]; yPositionOfShip++) {
                if (boardObject.board[xPositionOfShip][yPositionOfShip].equals("X"))
                    shipCoordinatesHit++;
                else {
                    isShipHit = 0;
                    break;
                }
            }
            if (isShipHit == 0) {
                break;
            }
        }
        if (shipCoordinatesHit == shipSize) {
            sinkShip();
            computerObject.listOfShipsOnBoard.remove(this);
            System.out.println("Number of ships remaining : " + computerObject.listOfShipsOnBoard.size());
            return true;
        }
        return false;
    }

    void sinkShip() {
        for (int xPositionOfShip = shipLocation[0]; xPositionOfShip <= shipLocation[2]; xPositionOfShip++) {
            for (int yPositionOfShip = shipLocation[1]; yPositionOfShip <= shipLocation[3]; yPositionOfShip++) {
                boardObject.board[xPositionOfShip][yPositionOfShip] = "S";
            }
        }
        System.out.println(shipName + " Sunk");
    }
}
