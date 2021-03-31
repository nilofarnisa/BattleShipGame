package com.twaran.battleShip;

import java.util.Scanner;

public class BattleShipGame {

    public static Board gameBoard = new Board();
    public static Computer computer = new Computer();

    public boolean isHit(int xCoordinate, int yCoordinate) {
        if (gameBoard.board[xCoordinate][yCoordinate].equals(gameBoard.ship)) {
            gameBoard.board[xCoordinate][yCoordinate] = gameBoard.hit;
            for (int ship = 0; ship < computer.listOfShipsOnBoard.size(); ship++) {
                Ship shipObj = computer.listOfShipsOnBoard.get(ship);
                shipObj.isSink();
            }
            return true;
        }
        gameBoard.board[xCoordinate][yCoordinate] = gameBoard.miss;
        return false;
    }
   public static void playGame(Board gameBoard, Computer computer)
   {
       Player player = new Player();
       Scanner input = new Scanner(System.in);
       final int ASCII_VALUE_OF_A = 65;
       System.out.println("Start...");
       String choice;
       do {
           choice = input.nextLine();
           choice = choice.replaceAll("\\s+", "");
           choice = choice.toUpperCase();
           switch (choice) {
               case "1947":
                   System.out.println("Opponent Board :");
                   gameBoard.printOpponentBoard();
                   break;
               case "QUIT":
                   gameBoard.printOpponentBoard();
                   System.out.println("You Lost :(");
                   break;
               default:
                   int y = choice.charAt(0) - ASCII_VALUE_OF_A;
                   String row = choice.substring(1);
                   int x = Integer.parseInt(row) - 1;
                   if ((x >= 0 && x < gameBoard.noOfRows) && (y >= 0 && y < gameBoard.noOfCols)) {
                       String result = player.shootShip(x, y);
                       System.out.println(result);
                       gameBoard.printBoard();
                       if (computer.listOfShipsOnBoard.size() == 0) {
                           System.out.println("You Won :)");
                           return;
                       }
                   } else {
                       System.out.println("Co-ordinates out of Range.");
                   }
                   break;
           }
       } while (!choice.equals("QUIT"));
   }
    public static void main(String[] args) {
        gameBoard.setBoard();
        gameBoard.printBoard();
        computer.createShipsOnBoard(gameBoard);
        playGame(gameBoard,computer);
    }
}
