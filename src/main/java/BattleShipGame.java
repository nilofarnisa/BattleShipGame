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
        //printBoard();
       // setShip();

    }
}
