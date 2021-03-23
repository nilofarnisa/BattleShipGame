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

    public String shootShip(int xCoordinate, int yCoordinate) {
        if(hit(xCoordinate,yCoordinate))
        {
            return "HIT";
        }
        return "MISS";
    }

    private boolean hit(int xCoordinate, int yCoordinate) {
        if(board[xCoordinate][yCoordinate] == "1")
        {
            board[xCoordinate][yCoordinate] = "X";
            playerBoard[xCoordinate][yCoordinate] = "X";
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        setBoard();
        printBoard();
       // setShip();

    }
}
