package com.twaran.battleShip;

public class Player {

    public Board boardObject = BattleShipGame.gameBoard;
    public Ship shipObject = Computer.shipObj;
    public BattleShipGame gameObject = new BattleShipGame();

    public String shootShip(int xCoordinate, int yCoordinate) {
        if (boardObject.board[xCoordinate][yCoordinate].equals("X") || boardObject.board[xCoordinate][yCoordinate].equals("*")) {
            return "Shot Already , Choose other co-ordinates";
        }
        if (gameObject.isHit(xCoordinate, yCoordinate)) {
            if (shipObject.isSink()) {
                System.out.println("Ship Sunk");
                shipObject.noOfShips--;
            }
            if (shipObject.noOfShips == 0) {
                return "You Won :)";
            }
            return "HIT";
        }
        return "MISS";
    }
}
