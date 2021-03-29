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

    public void printBoard() {
        System.out.print("   ");
        for (int cols = 0; cols < noOfCols; cols++) {
            System.out.print((char) (cols + 65) + " ");
        }
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            System.out.print(row + 1 + "| ");
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column].equals("0") || board[row][column].equals("1")) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[row][column] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    public void printOpponentBoard() {
        System.out.print("   ");
        for (int cols = 0; cols < noOfCols; cols++) {
            System.out.print((char) (cols + 65) + " ");
        }
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            System.out.print(row + 1 + "| ");
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column].equals("0")) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[row][column] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

}
