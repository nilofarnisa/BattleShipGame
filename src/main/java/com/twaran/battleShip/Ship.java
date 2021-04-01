package com.twaran.battleShip;

public class Ship {

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

    void setShipInHorizontalPosition(int xCoordinate, int yCoordinate, Board board) {
        for (int currentYCoordinate = yCoordinate; currentYCoordinate < yCoordinate + shipSize && currentYCoordinate < board.noOfCols; currentYCoordinate++) {
            if (!board.board[xCoordinate][currentYCoordinate].equals(board.noShip))
                break;
            else
                pointsFilled++;
        }
        if (pointsFilled == shipSize) {
            isOnBoard = true;
            for (int yPositionOfShip = yCoordinate; yPositionOfShip < yCoordinate + shipSize; yPositionOfShip++)
                board.board[xCoordinate][yPositionOfShip] = board.ship;
            shipLocation[0] = xCoordinate;
            shipLocation[1] = yCoordinate;
            shipLocation[2] = xCoordinate;
            shipLocation[3] = yCoordinate + shipSize - 1;
        }
    }

    void setShipInVerticalPosition(int xCoordinate, int yCoordinate, Board board) {
        for (int currentXCoordinate = xCoordinate; currentXCoordinate < xCoordinate + shipSize && currentXCoordinate < board.noOfRows; currentXCoordinate++) {
            if (!board.board[currentXCoordinate][yCoordinate].equals(board.noShip))
                break;
            else
                pointsFilled++;
        }
        if (pointsFilled == shipSize) {
            isOnBoard = true;
            for (int xPositionOfShip = xCoordinate; xPositionOfShip < xCoordinate + shipSize; xPositionOfShip++)
                board.board[xPositionOfShip][yCoordinate] = board.ship;
            shipLocation[0] = xCoordinate;
            shipLocation[1] = yCoordinate;
            shipLocation[2] = xCoordinate + shipSize - 1;
            shipLocation[3] = yCoordinate;
        }
    }

    boolean isSink(Board board, Computer computer) {
        int shipCoordinatesHit = 0;
        int isShipHit = 1;
        for (int xPositionOfShip = shipLocation[0]; xPositionOfShip <= shipLocation[2]; xPositionOfShip++) {
            for (int yPositionOfShip = shipLocation[1]; yPositionOfShip <= shipLocation[3]; yPositionOfShip++) {
                if (board.board[xPositionOfShip][yPositionOfShip].equals(board.hit))
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
            sinkShip(board);
            computer.listOfShipsOnBoard.remove(this);

            return true;
        }
        return false;
    }

    private void sinkShip(Board board) {
        for (int xPositionOfShip = shipLocation[0]; xPositionOfShip <= shipLocation[2]; xPositionOfShip++) {
            for (int yPositionOfShip = shipLocation[1]; yPositionOfShip <= shipLocation[3]; yPositionOfShip++) {
                board.board[xPositionOfShip][yPositionOfShip] = board.sink;
            }
        }
        System.out.println(shipName + " Sunk");
    }
}
