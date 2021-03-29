package com.twaran.battleShip;

public class Player {

    public Board boardObject = BattleShipGame.gameBoard;
    public BattleShipGame gameObject = new BattleShipGame();

    public String shootShip(int xCoordinate, int yCoordinate) {
        // TODO = Having X/* is not readable. Could be improved
        if (boardObject.board[xCoordinate][yCoordinate].equals("X") || boardObject.board[xCoordinate][yCoordinate].equals("*")) {
            return "Shot Already , Choose other co-ordinates";
        }
        if (gameObject.isHit(xCoordinate, yCoordinate)) {
            return "HIT";
        }
        return "MISS";
    }
}
