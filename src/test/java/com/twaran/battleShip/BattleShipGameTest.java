package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleShipGameTest {

    @Test
    void shouldReturnTrueIfTheShipIsHit() {
        MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

        assertTrue(mockBattleShipGame.isHit(0,5));
    }

    @Test
    void shouldReturnFalseIfTheShipIsMissed() {
        MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

        assertFalse(mockBattleShipGame.isHit(0,0));
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

        assertEquals("Function called",message);

    }

    @Test
    void shouldReturnTrueIfSetShipIsCalled() {
        MockComputer mockComputer = new MockComputer();

        mockComputer.setShip();

        assertTrue(mockComputer.isFunctionCalled);
    }

    @Test
    void shouldReturnTrueIfSetBoardIsCalled() {
        MockBoard mockBoard = new MockBoard();

        mockBoard.setBoard();

        assertTrue(mockBoard.isFunctionCalled);
    }

    private static class MockPlayer extends Player{

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

    private static class MockBattleShipGame extends BattleShipGame{
        MockComputer mockComputerObject = new MockComputer();

        @Override
        public boolean isHit(int xCoordinate, int yCoordinate) {
            mockComputerObject.setShip();
            return xCoordinate == mockComputerObject.xCoordinateOfShip && yCoordinate == mockComputerObject.yCoordinateOfShip;
        }
    }

    private static class MockComputer extends Computer{
        int xCoordinateOfShip;
        int yCoordinateOfShip;
        boolean isFunctionCalled = false;

        @Override
        void setShip() {
            xCoordinateOfShip = 0;
            yCoordinateOfShip = 5;
            isFunctionCalled = true;
        }
    }

    private static class MockBoard extends Board{
        boolean isFunctionCalled =false;

        @Override
        public void setBoard() {
            isFunctionCalled = true;
        }
    }
}
