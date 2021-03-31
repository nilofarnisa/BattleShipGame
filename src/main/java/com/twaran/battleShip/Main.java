package com.twaran.battleShip;

public class Main {
    public static void main(String[] args) {
        Board gameBoard = new Board();
        Computer computer = new Computer();

        gameBoard.setBoard();
        gameBoard.printBoard();
        gameBoard = computer.createShipsOnBoard(gameBoard);
        BattleShipGame.playGame(gameBoard, computer);
    }
}
