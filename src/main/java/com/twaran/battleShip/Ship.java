package com.twaran.battleShip;

import java.util.ArrayList;
import java.util.Arrays;

public class Ship {

    public Board boardObject = BattleShipGame.gameBoard;

    int noOfShips = 5;
    int shipPointsFilled;
    boolean isShipPlaced;

    ArrayList<Integer> shipSize = new ArrayList<>(Arrays.asList(2, 3, 3, 4, 5));
    Integer[][] shipCoordinates = new Integer[noOfShips][4];
    ArrayList<Integer> shipRemaining = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));

    void setShipInHorizontalPosition(int xCoordinate, int yCoordinate, int ship) {
        for (int currentYCoordinate = yCoordinate; currentYCoordinate < yCoordinate + shipSize.get(ship) && currentYCoordinate < boardObject.noOfCols; currentYCoordinate++) {
            if (!boardObject.board[xCoordinate][currentYCoordinate].equals("0"))
                break;
            else
                shipPointsFilled++;
        }
        if (shipPointsFilled == shipSize.get(ship)) {
            isShipPlaced = true;
            for (int yPositionOfShip = yCoordinate; yPositionOfShip < yCoordinate + shipSize.get(ship); yPositionOfShip++)
                boardObject.board[xCoordinate][yPositionOfShip] = "1";
            shipCoordinates[ship][0] = xCoordinate;
            shipCoordinates[ship][1] = yCoordinate;
            shipCoordinates[ship][2] = xCoordinate;
            shipCoordinates[ship][3] = yCoordinate + shipSize.get(ship) - 1;
        }
    }

    void setShipInVerticalPosition(int xCoordinate, int yCoordinate, int ship) {
        for (int currentXCoordinate = xCoordinate; currentXCoordinate < xCoordinate + shipSize.get(ship) && currentXCoordinate < boardObject.noOfRows; currentXCoordinate++) {
            if (!boardObject.board[currentXCoordinate][yCoordinate].equals("0"))
                break;
            else
                shipPointsFilled++;
        }
        if (shipPointsFilled == shipSize.get(ship)) {
            isShipPlaced = true;
            for (int xPositionOfShip = xCoordinate; xPositionOfShip < xCoordinate + shipSize.get(ship); xPositionOfShip++)
                boardObject.board[xPositionOfShip][yCoordinate] = "1";
            shipCoordinates[ship][0] = xCoordinate;
            shipCoordinates[ship][1] = yCoordinate;
            shipCoordinates[ship][2] = xCoordinate + shipSize.get(ship) - 1;
            shipCoordinates[ship][3] = yCoordinate;
        }
    }

    boolean isSink() {
        int shipCoordinatesHit;
        int ship = 0;
        while (ship < shipRemaining.size()) {
            shipCoordinatesHit = 0;
            int isShipHit = 1;
            for (int xPositionOfShip = shipCoordinates[shipRemaining.get(ship)][0]; xPositionOfShip <= shipCoordinates[shipRemaining.get(ship)][2]; xPositionOfShip++) {
                for (int yPositionOfShip = shipCoordinates[shipRemaining.get(ship)][1]; yPositionOfShip <= shipCoordinates[shipRemaining.get(ship)][3]; yPositionOfShip++) {
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
            if (shipCoordinatesHit == shipSize.get(shipRemaining.get(ship))) {
                sinkShip(ship);
                shipRemaining.remove(ship);
                System.out.println("Number of ships remaining : " + shipRemaining.size());
                return true;
            }
            ship++;
        }
        return false;
    }

    private void sinkShip(int ship) {
        for (int xPositionOfShip = shipCoordinates[shipRemaining.get(ship)][0]; xPositionOfShip <= shipCoordinates[shipRemaining.get(ship)][2]; xPositionOfShip++) {
            for (int yPositionOfShip = shipCoordinates[shipRemaining.get(ship)][1]; yPositionOfShip <= shipCoordinates[shipRemaining.get(ship)][3]; yPositionOfShip++) {
                boardObject.board[xPositionOfShip][yPositionOfShip] = "S";
            }
        }
    }
}
