package com.twaran.battleShip;

public class Ship {

    public Board boardObject = BattleShipGame.gameBoard;
    public Computer computerObject = BattleShipGame.computer;

    //int noOfShips = 5;
    int shipPointsFilled;
    boolean isShipPlaced;
    public String shipName;
    public int shipSize;

    public Ship(String shipName, int shipSize) {
        this.shipName = shipName;
        this.shipSize = shipSize;
    }

    int[] shipCoordinate = new int[4];

    void setShipInHorizontalPosition(int xCoordinate, int yCoordinate) {
        for (int currentYCoordinate = yCoordinate; currentYCoordinate < yCoordinate + shipSize && currentYCoordinate < boardObject.noOfCols; currentYCoordinate++) {
            if (!boardObject.board[xCoordinate][currentYCoordinate].equals("0"))
                break;
            else
                shipPointsFilled++;
        }
        if (shipPointsFilled == shipSize) {
            isShipPlaced = true;
            for (int yPositionOfShip = yCoordinate; yPositionOfShip < yCoordinate + shipSize; yPositionOfShip++)
                boardObject.board[xCoordinate][yPositionOfShip] = "1";
            shipCoordinate[0] = xCoordinate;
            shipCoordinate[1] = yCoordinate;
            shipCoordinate[2] = xCoordinate;
            shipCoordinate[3] = yCoordinate + shipSize - 1;
        }
    }

    void setShipInVerticalPosition(int xCoordinate, int yCoordinate) {
        for (int currentXCoordinate = xCoordinate; currentXCoordinate < xCoordinate + shipSize && currentXCoordinate < boardObject.noOfRows; currentXCoordinate++) {
            if (!boardObject.board[currentXCoordinate][yCoordinate].equals("0"))
                break;
            else
                shipPointsFilled++;
        }
        if (shipPointsFilled == shipSize) {
            isShipPlaced = true;
            for (int xPositionOfShip = xCoordinate; xPositionOfShip < xCoordinate + shipSize; xPositionOfShip++)
                boardObject.board[xPositionOfShip][yCoordinate] = "1";
            shipCoordinate[0] = xCoordinate;
            shipCoordinate[1] = yCoordinate;
            shipCoordinate[2] = xCoordinate + shipSize - 1;
            shipCoordinate[3] = yCoordinate;
        }
    }

    boolean isSink() {
        int shipCoordinatesHit = 0;
        int isShipHit = 1;
        for (int xPositionOfShip = shipCoordinate[0]; xPositionOfShip <= shipCoordinate[2]; xPositionOfShip++) {
            for (int yPositionOfShip = shipCoordinate[1]; yPositionOfShip <= shipCoordinate[3]; yPositionOfShip++) {
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
            computerObject.shipRemaining.remove(this);
            System.out.println("Number of ships remaining : " + computerObject.shipRemaining.size());
            return true;
        }
        return false;
    }

    void sinkShip() {
        for (int xPositionOfShip = shipCoordinate[0]; xPositionOfShip <= shipCoordinate[2]; xPositionOfShip++) {
            for (int yPositionOfShip = shipCoordinate[1]; yPositionOfShip <= shipCoordinate[3]; yPositionOfShip++) {
                boardObject.board[xPositionOfShip][yPositionOfShip] = "S";
            }
        }
        System.out.println(shipName + " Sunk");
    }
}
