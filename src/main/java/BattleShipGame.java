import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;

public class BattleShipGame {
    public static int noOfRows = 10;
    public static int noOfCols = 10;
    public static int noOfShips = 5;
    public static String[][] board = new String[noOfRows][noOfCols];
    static ArrayList<Integer> ship_size = new ArrayList<>(Arrays.asList(2,3,3,4,5));
    public static Integer[][] shipCoordinates = new Integer[noOfShips][4];
    public static ArrayList<Integer> shipSunk = new ArrayList<>(Arrays.asList(0,1,2,3,4));
    private static int noOfHits = 0;

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
                if(board[i][j] == "0" || board[i][j] == "1")
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
        for (int i = 0; i < noOfShips;) {
            int x = (int) (random()*10);
            int y = (int) (random()*10);
            int direction = (int) (random()*2);
            int shipPointsFilled = 0;
            boolean isShipPlaced = false;

            if((x >= 0 && x < noOfRows) && (y >= 0 && y < noOfCols) && (board[x][y] == "0"))
            {
                shipPointsFilled = 0;
                if(direction == 0) {
                    for (int j = x; j < x + ship_size.get(i) && j < noOfRows; j++) {
                        if (board[j][y] != "0")
                            break;
                        else
                            shipPointsFilled++;
                    }
                    if(shipPointsFilled == ship_size.get(i))
                    {
                        isShipPlaced = true;
                        for (int j = x; j < x + ship_size.get(i); j++)
                            board[j][y] = "1";
                        shipCoordinates[i][0] = x;
                        shipCoordinates[i][1] = y;
                        shipCoordinates[i][2] = x + ship_size.get(i) - 1;
                        shipCoordinates[i][3] = y;
                    }
                }
                else
                {
                    for (int j = y; j < y + ship_size.get(i) && j < noOfCols; j++) {
                        if (board[x][j] != "0")
                            break;
                        else
                            shipPointsFilled++;
                    }
                    if(shipPointsFilled == ship_size.get(i))
                    {
                        isShipPlaced = true;
                        for (int j = y; j < y + ship_size.get(i); j++)
                            board[x][j] = "1";
                        shipCoordinates[i][0] = x;
                        shipCoordinates[i][1] = y;
                        shipCoordinates[i][2] = x;
                        shipCoordinates[i][3] = y + ship_size.get(i) - 1;
                    }
                }
                if(isShipPlaced) {
                    System.out.println("Ship" + (i + 1) + " deployed");
                    i++;
                }
            }
        }

       for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+" ");
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
        if(board[xCoordinate][yCoordinate] == "X" || board[xCoordinate][yCoordinate] == "*")
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
        int shipCoordinatesFilled = 0;
        int i = 0;
        while( i < shipSunk.size())
        {
            shipCoordinatesFilled = 0;
            int flag = 1;
            for (int j = shipCoordinates[shipSunk.get(i)][0]; j <= shipCoordinates[shipSunk.get(i)][2]; j++) {
                for (int k = shipCoordinates[shipSunk.get(i)][1]; k <= shipCoordinates[shipSunk.get(i)][3]; k++) {
                    if (board[j][k] == "X")
                        shipCoordinatesFilled++;
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
            if (shipCoordinatesFilled == ship_size.get(shipSunk.get(i))) {
                shipSunk.remove(i);
                System.out.println("Number of ships remaining : " + shipSunk.size());
                return true;
            }
            i++;
        }
        return false;
    }
    private static boolean hit(int xCoordinate, int yCoordinate) {
        if(board[xCoordinate][yCoordinate] == "1")
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
                        if(result == "You Won :)")
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
