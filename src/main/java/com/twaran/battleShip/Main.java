package com.twaran.battleShip;

public class Main {
    public static void main(String[] args) {
        Board gameBoard = new Board(10, 10);
        Computer computer = new Computer();

        gameBoard.setBoard();
        gameBoard.printBoard();
        gameBoard = computer.createShipsOnBoard(gameBoard);
        BattleShipGame.playGame(gameBoard, computer);
    }
}
