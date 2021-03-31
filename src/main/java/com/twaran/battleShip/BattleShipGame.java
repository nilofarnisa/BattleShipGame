package com.twaran.battleShip;

import java.util.Scanner;

public class BattleShipGame {

    public static void playGame(Board gameBoard, Computer computer) {
        Player player = new Player();
        Scanner input = new Scanner(System.in);

        final String cheatCode = "1947";
        final int ASCII_VALUE_OF_A = 65;
        final String quit = "QUIT";
        String choice;

        System.out.println();
        System.out.println("Start...");
        do {
            choice = input.nextLine();
            choice = choice.replaceAll("\\s+", "");
            choice = choice.toUpperCase();

            switch (choice) {
                case cheatCode:
                    System.out.println("Opponent Board :");
                    gameBoard.printOpponentBoard();
                    break;
                case quit:
                    gameBoard.printOpponentBoard();
                    System.out.println("You Lost :(");
                    break;
                default:
                    int y = choice.charAt(0) - ASCII_VALUE_OF_A;
                    String row = choice.substring(1);
                    int x = Integer.parseInt(row) - 1;
                    if ((x >= 0 && x < gameBoard.noOfRows) && (y >= 0 && y < gameBoard.noOfCols)) {
                        String result = player.shootShip(x, y, gameBoard);
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
        } while (!choice.equals(quit));
    }
}
