import java.util.Scanner;

import static java.lang.Math.random;

public class BattleShipGame {
    public static int noOfRows = 10;
    public static int noOfCols = 10;
    public static int noOfShips = 5;
    public static String[][] board = new String[noOfRows][noOfCols];
    public static String[][] playerBoard = new String[noOfRows][noOfCols];

    public static void setBoard()
    {
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                board[i][j]="0";
                playerBoard[i][j]="-";
            }
        }
    }

    public static void printBoard()
    {
        System.out.print("   0 1 2 3 4 5 6 7 8 9 ");
        System.out.println();
        for (int i = 0; i < playerBoard.length; i++) {
            System.out.print(i+"| ");
            for (int j = 0; j < playerBoard[i].length; j++) {
                System.out.print(playerBoard[i][j]+" ");
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

            if((x >= 0 && x < noOfRows) && (y >= 0 && y < noOfCols) && (board[x][y] == "0"))
            {
                board[x][y] = "1";
                System.out.println("Ship"+(i+1)+" deployed");
                i++;
            }
        }

       for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static String shootShip(int xCoordinate, int yCoordinate) {
        if(board[xCoordinate][yCoordinate] == "X" || board[xCoordinate][yCoordinate] == "*")
        {
            return "Shot Already , Choose other co-ordinates";
        }
        if(hit(xCoordinate,yCoordinate))
        {
            noOfShips--;
            if(noOfShips == 0)
            {
                return "You Won :)";
            }
            return "HIT";
        }
        return "MISS";
    }

    private static boolean hit(int xCoordinate, int yCoordinate) {
        if(board[xCoordinate][yCoordinate] == "1")
        {
            board[xCoordinate][yCoordinate] = "X";
            playerBoard[xCoordinate][yCoordinate] = "X";
            return true;
        }
        board[xCoordinate][yCoordinate] = "*";
        playerBoard[xCoordinate][yCoordinate] = "*";
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
                        //printBoard();
                    }
                    System.out.println("Co-ordinates out of Range. Please enter any value from 0 to 9");
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
