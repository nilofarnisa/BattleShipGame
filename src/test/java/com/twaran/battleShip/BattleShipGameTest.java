package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleShipGameTest {

    static MockBoard mockBoard = new MockBoard();
    MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();
    MockShip mockShip = new MockShip("Destroyer", 2);

    @Test
    void shouldReturnTrueIfTheShipIsHit() {
        mockBoard.setBoard();

        assertTrue(mockBattleShipGame.isHit(1, 1));
    }

    @Test
    void shouldReturnFalseIfTheShipIsMissed() {
        mockBoard.setBoard();

        assertFalse(mockBattleShipGame.isHit(0, 0));
    }

    @Test
    void shouldReturnTrueIfPrintBoardIsCalled() {
        mockBoard.printBoard();

        assertTrue(mockBoard.isPrintBoardCalled);
    }

    @Test
    void shouldReturnTrueIfPrintOpponentBoardIsCalled() {
        mockBoard.printOpponentBoard();

        assertTrue(mockBoard.isPrintOpponentBoardCalled);
    }

    @Test
    void shouldReturnFunctionCalledIfShootShipIsCalled() {
        MockPlayer mockPlayer = new MockPlayer();

        String message = mockPlayer.shootShip(0, 5);

        assertEquals("Function called", message);

    }

    @Test
    void shouldReturnTrueIfSetShipIsCalled() {
        MockComputer mockComputer = new MockComputer();

        mockBoard.setBoard();

        mockComputer.setShip(mockShip);

        assertTrue(mockComputer.isFunctionCalled);
    }

    @Test
    void shouldReturnTrueIfSetBoardIsCalled() {
        MockBoard mockBoard = new MockBoard();

        mockBoard.setBoard();

        assertTrue(mockBoard.isFunctionCalled);
    }

    @Test
    void shouldReturnTrueIfIsSinkIsCalled() {
        assertTrue(mockShip.isSink());
    }

    private static class MockPlayer extends Player {

        @Override
        public String shootShip(int xCoordinate, int yCoordinate) {
            return "Function called";
        }

    }

    private static class MockBattleShipGame extends BattleShipGame {
        MockComputer mockComputerObject = new MockComputer();
        private final MockShip mockship = new MockShip("BattleShip", 3);
        BattleShipGame gameObject = new BattleShipGame();

        @Override
        public boolean isHit(int xCoordinate, int yCoordinate) {
            mockComputerObject.setShip(mockship);
            gameObject.gameBoard.board = mockBoard.mockGameBoard;
            return super.isHit(xCoordinate, yCoordinate);
        }
    }

    private static class MockComputer extends Computer {
        int xCoordinateOfShip = 1;
        int yCoordinateOfShip = 1;
        boolean isFunctionCalled = false;

        @Override
        public void setShip(Ship mockShip) {
            isFunctionCalled = true;
            mockBoard.mockGameBoard[xCoordinateOfShip][yCoordinateOfShip] = "1";
        }
    }

    private static class MockBoard extends Board {
        String[][] mockGameBoard;
        boolean isFunctionCalled = false;
        boolean isPrintBoardCalled = false;
        private boolean isPrintOpponentBoardCalled = false;

        @Override
        public void setBoard() {
            mockGameBoard = new String[][]{{"0", "0", "0"}, {"0", "0", "0"}, {"0", "0", "0"}};
            isFunctionCalled = true;
        }

        @Override
        public void printBoard() {
            isPrintBoardCalled = true;
        }

        @Override
        public void printOpponentBoard() {
            isPrintOpponentBoardCalled = true;
        }
    }

    private static class MockShip extends Ship {

        public MockShip(String shipName, int shipSize) {
            super(shipName, shipSize);
        }

        @Override
        boolean isSink() {
            return true;
        }
    }
}
