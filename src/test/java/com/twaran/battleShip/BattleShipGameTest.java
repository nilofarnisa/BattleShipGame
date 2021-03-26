package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleShipGameTest {

    static MockBoard mockBoard = new MockBoard();

    @Test
    void shouldReturnTrueIfTheShipIsHit() {
        MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

        mockBoard.setBoard();

        assertTrue(mockBattleShipGame.isHit(1, 1));
    }

    @Test
    void shouldReturnFalseIfTheShipIsMissed() {
        MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

        mockBoard.setBoard();

        assertFalse(mockBattleShipGame.isHit(0, 0));
    }

    @Test
    void shouldReturnTrueIfPrintBoardIsCalled() {
        MockPlayer mockPlayer = new MockPlayer();

        mockPlayer.printBoard();

        assertTrue(mockPlayer.isPrintBoardCalled);
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

        mockComputer.setShip();

        assertTrue(mockComputer.isFunctionCalled);
    }

    @Test
    void shouldReturnTrueIfSetBoardIsCalled() {
        MockBoard mockBoard = new MockBoard();

        mockBoard.setBoard();

        assertTrue(mockBoard.isFunctionCalled);
    }

    private static class MockPlayer extends Player {

        boolean isPrintBoardCalled = false;

        @Override
        public String shootShip(int xCoordinate, int yCoordinate) {
            return "Function called";
        }

        @Override
        public void printBoard() {
            isPrintBoardCalled = true;
        }
    }

    private static class MockBattleShipGame extends BattleShipGame {
        MockComputer mockComputerObject = new MockComputer();

        @Override
        public boolean isHit(int xCoordinate, int yCoordinate) {
            mockComputerObject.setShip();
            BattleShipGame.gameBoard.board = mockBoard.mockGameBoard;
            return super.isHit(xCoordinate, yCoordinate);
        }
    }

    private static class MockComputer extends Computer {
        int xCoordinateOfShip = 1;
        int yCoordinateOfShip = 1;
        boolean isFunctionCalled = false;

        @Override
        public void setShip() {
            isFunctionCalled = true;
            mockBoard.mockGameBoard[xCoordinateOfShip][yCoordinateOfShip] = "1";
        }
    }

    private static class MockBoard extends Board {
        String[][] mockGameBoard;
        boolean isFunctionCalled = false;

        @Override
        public void setBoard() {
            mockGameBoard = new String[][]{{"0", "0", "0"}, {"0", "0", "0"}, {"0", "0", "0"}};
            isFunctionCalled = true;
        }
    }
}
