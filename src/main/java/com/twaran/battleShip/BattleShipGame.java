package com.twaran.battleShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;

public class BattleShipGame {
    int noOfRows = 10;
    int noOfCols = 10;
    int noOfShips = 5;
    String[][] board = new String[noOfRows][noOfCols];
    ArrayList<Integer> shipSize = new ArrayList<>(Arrays.asList(2, 3, 3, 4, 5));
    Integer[][] shipCoordinates = new Integer[noOfShips][4];
    ArrayList<Integer> shipRemaining = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));

    public void setBoard() {
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfCols; column++) {
                board[row][column] = "0";
            }
        }
    }

    public void printBoard() {
        System.out.print("   0 1 2 3 4 5 6 7 8 9 ");
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            System.out.print(row + "| ");
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

    private void setShip() {
        for (int ship = 0; ship < noOfShips; ) {
            int xCoordinate = (int) (random() * 10);
            int yCoordinate = (int) (random() * 10);
            int direction = (int) (random() * 2);
            int shipPointsFilled;
            boolean isShipPlaced = false;

            if ((xCoordinate >= 0 && xCoordinate < noOfRows) && (yCoordinate >= 0 && yCoordinate < noOfCols) && (board[xCoordinate][yCoordinate].equals("0"))) {
                shipPointsFilled = 0;
                if (direction == 0) {
                    for (int currentXCoordinate = xCoordinate; currentXCoordinate < xCoordinate + shipSize.get(ship) && currentXCoordinate < noOfRows; currentXCoordinate++) {
                        if (!board[currentXCoordinate][yCoordinate].equals("0"))
                            break;
                        else
                            shipPointsFilled++;
                    }
                    if (shipPointsFilled == shipSize.get(ship)) {
                        isShipPlaced = true;
                        for (int xPositionOfShip = xCoordinate; xPositionOfShip < xCoordinate + shipSize.get(ship); xPositionOfShip++)
                            board[xPositionOfShip][yCoordinate] = "1";
                        shipCoordinates[ship][0] = xCoordinate;
                        shipCoordinates[ship][1] = yCoordinate;
                        shipCoordinates[ship][2] = xCoordinate + shipSize.get(ship) - 1;
                        shipCoordinates[ship][3] = yCoordinate;
                    }
                } else {
                    for (int currentYCoordinate = yCoordinate; currentYCoordinate < yCoordinate + shipSize.get(ship) && currentYCoordinate < noOfCols; currentYCoordinate++) {
                        if (!board[xCoordinate][currentYCoordinate].equals("0"))
                            break;
                        else
                            shipPointsFilled++;
                    }
                    if (shipPointsFilled == shipSize.get(ship)) {
                        isShipPlaced = true;
                        for (int yPositionOfShip = yCoordinate; yPositionOfShip < yCoordinate + shipSize.get(ship); yPositionOfShip++)
                            board[xCoordinate][yPositionOfShip] = "1";
                        shipCoordinates[ship][0] = xCoordinate;
                        shipCoordinates[ship][1] = yCoordinate;
                        shipCoordinates[ship][2] = xCoordinate;
                        shipCoordinates[ship][3] = yCoordinate + shipSize.get(ship) - 1;
                    }
                }
                if (isShipPlaced) {
                    System.out.println("Ship" + (ship + 1) + " deployed");
                    ship++;
                }
            }
        }

        /*for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < noOfShips; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(shipCoordinates[i][j]+" ");
            }
            System.out.println();
        }*/
    }

    public String shootShip(int xCoordinate, int yCoordinate) {
        if (board[xCoordinate][yCoordinate].equals("X") || board[xCoordinate][yCoordinate].equals("*")) {
            return "Shot Already , Choose other co-ordinates";
        }
        if (isHit(xCoordinate, yCoordinate)) {
            if (isSink()) {
                System.out.println("Ship Sunk");
                noOfShips--;
            }
            if (noOfShips == 0) {
                return "You Won :)";
            }
            return "HIT";
        }
        return "MISS";
    }

    private boolean isSink() {
        int shipCoordinatesHit;
        int ship = 0;
        while (ship < shipRemaining.size()) {
            shipCoordinatesHit = 0;
            int isShipHit = 1;
            for (int xPositionOfShip = shipCoordinates[shipRemaining.get(ship)][0]; xPositionOfShip <= shipCoordinates[shipRemaining.get(ship)][2]; xPositionOfShip++) {
                for (int yPositionOfShip = shipCoordinates[shipRemaining.get(ship)][1]; yPositionOfShip <= shipCoordinates[shipRemaining.get(ship)][3]; yPositionOfShip++) {
                    if (board[xPositionOfShip][yPositionOfShip].equals("X"))
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
                board[xPositionOfShip][yPositionOfShip] = "S";
            }
        }
    }

    public boolean isHit(int xCoordinate, int yCoordinate) {
        if (board[xCoordinate][yCoordinate].equals("1")) {
            board[xCoordinate][yCoordinate] = "X";
            return true;
        }
        board[xCoordinate][yCoordinate] = "*";
        return false;
    }

    public static void main(String[] args) {
        BattleShipGame battleShipGame = new BattleShipGame();
        Scanner input = new Scanner(System.in);
        System.out.println("Setting the board....");
        battleShipGame.setBoard();
        System.out.println("Board Set");
        battleShipGame.printBoard();
        System.out.println("Setting the Ships in positions");
        battleShipGame.setShip();
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
                        String result = battleShipGame.shootShip(x, y);
                        System.out.println(result);
                        if (result.equals("You Won :)"))
                            return;
                    } else {
                        System.out.println("Co-ordinates out of Range. Please enter any value from 0 to 9");
                    }
                    break;
                case 2:
                    System.out.println("PRINT BOARD :");
                    battleShipGame.printBoard();
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
