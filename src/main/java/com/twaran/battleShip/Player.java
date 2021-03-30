package com.twaran.battleShip;

public class Player {

    public Board boardObject = BattleShipGame.gameBoard;
    public BattleShipGame gameObject = new BattleShipGame();
    String hit = "X";
    String miss = "*";

    public String shootShip(int xCoordinate, int yCoordinate) {
        if (boardObject.board[xCoordinate][yCoordinate].equals(hit) || boardObject.board[xCoordinate][yCoordinate].equals(miss)) {
            return "Shot Already , Choose other co-ordinates";
        }
        if (gameObject.isHit(xCoordinate, yCoordinate)) {
            return "HIT";
        }
        return "MISS";
    }
}
