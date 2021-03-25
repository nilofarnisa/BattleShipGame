package com.twaran.battleShip;

public class Player {

    Board boardObject = new Board();
    Ship shipObject = new Ship();
    BattleShipGame gameObject = new BattleShipGame();

    public void printBoard() {
        System.out.print("   0 1 2 3 4 5 6 7 8 9 ");
        System.out.println();
        for (int row = 0; row < boardObject.board.length; row++) {
            System.out.print(row + "| ");
            for (int column = 0; column < boardObject.board[row].length; column++) {
                if (boardObject.board[row][column].equals("0") || boardObject.board[row][column].equals("1")) {
                    System.out.print("- ");
                } else {
                    System.out.print(boardObject.board[row][column] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    public String shootShip(int xCoordinate, int yCoordinate) {
        if (boardObject.board[xCoordinate][yCoordinate].equals("X") || boardObject.board[xCoordinate][yCoordinate].equals("*")) {
            return "Shot Already , Choose other co-ordinates";
        }
        if (gameObject.isHit(xCoordinate, yCoordinate)) {
            if (shipObject.isSink()) {
                System.out.println("Ship Sunk");
                shipObject.noOfShips--;
            }
            if (shipObject.noOfShips == 0) {
                return "You Won :)";
            }
            return "HIT";
        }
        return "MISS";
    }
}
