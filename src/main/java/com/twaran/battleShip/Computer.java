package com.twaran.battleShip;

import java.util.ArrayList;

import static java.lang.Math.random;

public class Computer {
    //public Board boardObject = BattleShipGame.gameBoard;
    ArrayList<Ship> listOfShipsOnBoard = new ArrayList<>();


    public Board createShipsOnBoard(Board board) {
        System.out.println("Setting the Ships in positions");
        Ship carrier = new Ship("Carrier", 5);
        Ship battleShip = new Ship("BattleShip", 4);
        Ship cruiser = new Ship("Cruiser", 3);
        Ship subMarine = new Ship("SubMarine", 3);
        Ship destroyer = new Ship("Destroyer", 2);

        placeShipRandomlyOnBoard(carrier,board);
        placeShipRandomlyOnBoard(battleShip,board);
        placeShipRandomlyOnBoard(cruiser,board);
        placeShipRandomlyOnBoard(subMarine,board);
        placeShipRandomlyOnBoard(destroyer,board);

        return board;
    }

    public Board placeShipRandomlyOnBoard(Ship ship, Board board) {
        while (!ship.isOnBoard) {
            int xCoordinate = (int) (random() * board.noOfRows);
            int yCoordinate = (int) (random() * board.noOfCols);
            int direction = (int) (random() * 2);
            final int VERTICAL = 0;

            if (board.board[xCoordinate][yCoordinate].equals(board.noShip)) {
                ship.pointsFilled = 0;
                if (direction == VERTICAL) {
                    ship.setShipInVerticalPosition(xCoordinate, yCoordinate);
                } else {
                    ship.setShipInHorizontalPosition(xCoordinate, yCoordinate);
                }
            }
        }
        System.out.println(ship.shipName + " deployed");
        listOfShipsOnBoard.add(ship);
        return board;
    }
}
