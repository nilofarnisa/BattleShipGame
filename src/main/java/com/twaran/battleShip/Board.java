package com.twaran.battleShip;

public class Board {
    final int noOfRows = 10;
    final int noOfCols = 10;
    final int ASCII_VALUE_OF_A = 65;
    String noShip = "0";
    String ship = "1";
    String hit = "X";
    String miss = "*";
    String[][] board = new String[noOfRows][noOfCols];

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
        System.out.print("   ");
        for (int cols = 0; cols < noOfCols; cols++) {
            System.out.print((char) (cols + ASCII_VALUE_OF_A) + " ");
        }
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            System.out.print(row + 1 + "| ");
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column].equals(noShip) || board[row][column].equals(ship)) {
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
            System.out.print((char) (cols + ASCII_VALUE_OF_A) + " ");
        }
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            System.out.print(row + 1 + "| ");
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column].equals(noShip)) {
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
