package com.twaran.battleShip;

import static java.lang.Math.random;

public class Board {
    int noOfRows;
    int noOfCols;
    final int ASCII_VALUE_OF_A = 65;
    String noShip = "0";
    String ship = "1";
    String hit = "X";
    String miss = "*";
    String sink = "S";
    String[][] board;
    private Computer computer;

    public Board(int noOfRows, int noOfCols) {
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        board = new String[this.noOfRows][this.noOfCols];
    }

    public void setBoard() {
        System.out.println("Setting the board....");
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfCols; column++) {
                board[row][column] = noShip;
            }
        }
        System.out.println("Board Set");
    }

    public void printBoard() {
        System.out.printf("%5s", "");
        for (int cols = 0; cols < noOfCols; cols++) {
            System.out.print((char) (cols + ASCII_VALUE_OF_A) + " ");
        }
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            System.out.print(String.format("%3d", row + 1) + "| ");
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column].equals(noShip) || board[row][column].equals(ship)) {
                    System.out.print("~ ");
                } else {
                    System.out.print(board[row][column] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    void printOpponentBoard() {
        System.out.printf("%5s", "");
        for (int cols = 0; cols < noOfCols; cols++) {
            System.out.print((char) (cols + ASCII_VALUE_OF_A) + " ");
        }
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            System.out.print(String.format("%3d", row + 1) + "| ");
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column].equals(noShip)) {
                    System.out.print("~ ");
                } else {
                    System.out.print(board[row][column] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    public void placeShipRandomlyOnBoard(Ship ship, Computer computer) {
        this.computer = computer;
        while (!ship.isOnBoard) {
            int xCoordinate = (int) (random() * noOfRows);
            int yCoordinate = (int) (random() * noOfCols);
            int direction = (int) (random() * 2);
            final int VERTICAL = 0;

            if (board[xCoordinate][yCoordinate].equals(noShip)) {
                ship.pointsFilled = 0;
                if (direction == VERTICAL) {
                    ship.setShipInVerticalPosition(xCoordinate, yCoordinate, this);
                } else {
                    ship.setShipInHorizontalPosition(xCoordinate, yCoordinate, this);
                }
            }
        }
        System.out.println(ship.shipName + " deployed");
        computer.listOfShipsOnBoard.add(ship);
    }

    public boolean isShipHit(int xCoordinate, int yCoordinate) {
        if (board[xCoordinate][yCoordinate].equals(ship)) {
            board[xCoordinate][yCoordinate] = hit;
            for (int ship = 0; ship < computer.listOfShipsOnBoard.size(); ship++) {
                Ship shipObj = computer.listOfShipsOnBoard.get(ship);
                if (shipObj.isSink(this, computer)) {
                    System.out.println("Number of ships remaining : " + computer.listOfShipsOnBoard.size());
                }
            }
            return true;
        }
        board[xCoordinate][yCoordinate] = miss;
        return false;
    }
}
