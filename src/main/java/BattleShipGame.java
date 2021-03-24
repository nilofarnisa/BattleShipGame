import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;

public class BattleShipGame {
    public static int noOfRows = 10;
    public static int noOfCols = 10;
    public static int noOfShips = 5;
    public static String[][] board = new String[noOfRows][noOfCols];
    static ArrayList<Integer> shipSize = new ArrayList<>(Arrays.asList(2,3,3,4,5));
    public static Integer[][] shipCoordinates = new Integer[noOfShips][4];
    public static ArrayList<Integer> shipRemaining = new ArrayList<>(Arrays.asList(0,1,2,3,4));

    public static void setBoard()
    {
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                board[i][j]="0";
            }
        }
    }

    public static void printBoard()
    {
        System.out.print("   0 1 2 3 4 5 6 7 8 9 ");
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i+"| ");
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals("0") || board[i][j].equals("1"))
                {
                    System.out.print("- ");
                }
                else
                {
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    public static void setShip()
    {
        for (int ship = 0; ship < noOfShips;) {
            int xCoOrdinate = (int) (random()*10);
            int yCoOrdinate = (int) (random()*10);
            int direction = (int) (random()*2);
            int shipPointsFilled;
            boolean isShipPlaced = false;

            if((xCoOrdinate >= 0 && xCoOrdinate < noOfRows) && (yCoOrdinate >= 0 && yCoOrdinate < noOfCols) && (board[xCoOrdinate][yCoOrdinate].equals("0")))
            {
                shipPointsFilled = 0;
                if(direction == 0) {
                    for (int j = xCoOrdinate; j < xCoOrdinate + shipSize.get(ship) && j < noOfRows; j++) {
                        if (!board[j][yCoOrdinate].equals("0"))
                            break;
                        else
                            shipPointsFilled++;
                    }
                    if(shipPointsFilled == shipSize.get(ship))
                    {
                        isShipPlaced = true;
                        for (int j = xCoOrdinate; j < xCoOrdinate + shipSize.get(ship); j++)
                            board[j][yCoOrdinate] = "1";
                        shipCoordinates[ship][0] = xCoOrdinate;
                        shipCoordinates[ship][1] = yCoOrdinate;
                        shipCoordinates[ship][2] = xCoOrdinate + shipSize.get(ship) - 1;
                        shipCoordinates[ship][3] = yCoOrdinate;
                    }
                }
                else
                {
                    for (int j = yCoOrdinate; j < yCoOrdinate + shipSize.get(ship) && j < noOfCols; j++) {
                        if (!board[xCoOrdinate][j].equals("0"))
                            break;
                        else
                            shipPointsFilled++;
                    }
                    if(shipPointsFilled == shipSize.get(ship))
                    {
                        isShipPlaced = true;
                        for (int j = yCoOrdinate; j < yCoOrdinate + shipSize.get(ship); j++)
                            board[xCoOrdinate][j] = "1";
                        shipCoordinates[ship][0] = xCoOrdinate;
                        shipCoordinates[ship][1] = yCoOrdinate;
                        shipCoordinates[ship][2] = xCoOrdinate;
                        shipCoordinates[ship][3] = yCoOrdinate + shipSize.get(ship) - 1;
                    }
                }
                if(isShipPlaced) {
                    System.out.println("Ship" + (ship + 1) + " deployed");
                    ship++;
                }
            }
        }

       for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column]+" ");
            }
            System.out.println();
        }
        /*for (int i = 0; i < noOfShips; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(shipCoordinates[i][j]+" ");
            }
            System.out.println();
        }*/
    }

    public static String shootShip(int xCoordinate, int yCoordinate) {
        if(board[xCoordinate][yCoordinate].equals("X") || board[xCoordinate][yCoordinate].equals("*"))
        {
            return "Shot Already , Choose other co-ordinates";
        }
        if(hit(xCoordinate,yCoordinate))
        {
            if(isSink())
            {
                System.out.println("Ship Sunk");
                noOfShips--;
            }
            if(noOfShips == 0)
            {
                return "You Won :)";
            }
            return "HIT";
        }
        return "MISS";
    }

    private static boolean isSink()
    {
        int shipCoordinatesHit;
        int ship = 0;
        while( ship < shipRemaining.size())
        {
            shipCoordinatesHit = 0;
            int flag = 1;
            for (int xPositionOfShip = shipCoordinates[shipRemaining.get(ship)][0]; xPositionOfShip <= shipCoordinates[shipRemaining.get(ship)][2]; xPositionOfShip++) {
                for (int yPositionOfShip = shipCoordinates[shipRemaining.get(ship)][1]; yPositionOfShip <= shipCoordinates[shipRemaining.get(ship)][3]; yPositionOfShip++) {
                    if (board[xPositionOfShip][yPositionOfShip].equals("X"))
                        shipCoordinatesHit++;
                    else {
                        flag = 0;
                        break;
                    }
                }
                if(flag==0)
                {
                    break;
                }
            }
            if (shipCoordinatesHit == shipSize.get(shipRemaining.get(ship))) {
                shipRemaining.remove(ship);
                System.out.println("Number of ships remaining : " + shipRemaining.size());
                return true;
            }
            ship++;
        }
        return false;
    }
    private static boolean hit(int xCoordinate, int yCoordinate) {
        if(board[xCoordinate][yCoordinate].equals("1"))
        {
            board[xCoordinate][yCoordinate] = "X";
            return true;
        }
        board[xCoordinate][yCoordinate] = "*";
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Setting the board....");
        setBoard();
        System.out.println("Board Set");
        printBoard();
        System.out.println("Setting the Ships in positions");
        setShip();
        int choice;
        do {
            System.out.println("Choose your option : 1.SHOOT 2.PRINT BOARD 3.QUIT GAME");
            choice = input.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("SHOOT");
                    System.out.println("Enter X and Y co-ordinates: ");
                    int x = input.nextInt();
                    int y = input.nextInt();
                    if((x>=0 && x<=9) && (y>=0 && y<=9) )
                    {
                        String result = shootShip(x, y);
                        System.out.println(result);
                        if(result.equals("You Won :)"))
                            return;
                    }
                    else{
                        System.out.println("Co-ordinates out of Range. Please enter any value from 0 to 9");
                    }
                    break;
                case 2:
                    System.out.println("PRINT BOARD :");
                    printBoard();
                    break;
                case 3:
                    System.out.println("You Lost :(");
                    break;
                default :
                    System.out.println("Wrong choice . Choose correct option");
                    break;
            }
        }while(choice!=3);
    }
}
