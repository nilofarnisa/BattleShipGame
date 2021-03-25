package com.twaran.battleShip;

import java.util.Scanner;

public class BattleShipGame {

    public static Board gameBoard = new Board();
    public static Player player = new Player();
    public static Computer computer = new Computer();

    public boolean isHit(int xCoordinate, int yCoordinate) {
        if (gameBoard.board[xCoordinate][yCoordinate].equals("1")) {
            gameBoard.board[xCoordinate][yCoordinate] = "X";
            return true;
        }
        gameBoard.board[xCoordinate][yCoordinate] = "*";
        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Setting the board....");
        gameBoard.setBoard();
        System.out.println("Board Set");
        player.printBoard();
        System.out.println("Setting the Ships in positions");
        computer.setShip();
        int choice;
        do {
            System.out.println("Choose your option : 1.SHOOT 2.PRINT BOARD 3.QUIT GAME");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("SHOOT");
                    System.out.println("Enter X and Y co-ordinates: ");
                    int x = input.nextInt();
                    int y = input.nextInt();
                    if ((x >= 0 && x <= 9) && (y >= 0 && y <= 9)) {
                        String result = player.shootShip(x, y);
                        System.out.println(result);
                        if (result.equals("You Won :)"))
                            return;
                    } else {
                        System.out.println("Co-ordinates out of Range. Please enter any value from 0 to 9");
                    }
                    break;
                case 2:
                    System.out.println("PRINT BOARD :");
                    player.printBoard();
                    break;
                case 3:
                    System.out.println("You Lost :(");
                    break;
                default:
                    System.out.println("Wrong choice . Choose correct option");
                    break;
            }
        } while (choice != 3);
    }
}
