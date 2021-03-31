package com.twaran.battleShip;

public class Player {

    public String shootShip(int xCoordinate, int yCoordinate, Board boardObject) {
        if (boardObject.board[xCoordinate][yCoordinate].equals(boardObject.hit) || boardObject.board[xCoordinate][yCoordinate].equals(boardObject.miss)) {
            return "Shot Already , Choose other co-ordinates";
        }
        if (boardObject.isHit(xCoordinate, yCoordinate)) {
            return "HIT";
        }
        return "MISS";
    }
}
