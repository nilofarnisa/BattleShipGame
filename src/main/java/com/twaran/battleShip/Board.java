package com.twaran.battleShip;

public class Board {
    int noOfRows = 10;
    int noOfCols = 10;
    String[][] board = new String[noOfRows][noOfCols];

    public void setBoard() {
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfCols; column++) {
                board[row][column] = "0";
            }
        }
    }

}
