package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerTest {

    MockBoard mockBoard = new MockBoard();

    @Test
    void shouldReturnTrueIfShipIsSetInSetShip() {
        MockComputer mockComputer = new MockComputer();

        mockBoard.setBoard();

        mockComputer.setShip();

        assertEquals("1", mockBoard.mockGameBoard[1][1]);
    }

    @Test
    void shouldReturnTrueIfSetShipInHorizontalPositionIsCalled() {
        MockShip mockShip = new MockShip();

        mockShip.setShipInHorizontalPosition(0, 0, 0);

        assertTrue(mockShip.isHorizontalFunctionCalled);
    }

    @Test
    void shouldReturnTrueIfSetShipInVerticalPositionIsCalled() {
        MockShip mockShip = new MockShip();

        mockShip.setShipInVerticalPosition(0, 0, 0);

        assertTrue(mockShip.isVerticalFunctionCalled);
    }

    private static class MockShip extends Ship {
        boolean isHorizontalFunctionCalled = false;
        boolean isVerticalFunctionCalled = false;

        @Override
        void setShipInHorizontalPosition(int xCoordinate, int yCoordinate, int ship) {
            isHorizontalFunctionCalled = true;
        }

        @Override
        void setShipInVerticalPosition(int xCoordinate, int yCoordinate, int ship) {
            isVerticalFunctionCalled = true;
        }
    }

    private static class MockBoard extends Board {
        String[][] mockGameBoard;

        @Override
        public void setBoard() {
            mockGameBoard = new String[][]{{"0", "0", "0"}, {"0", "0", "0"}, {"0", "0", "0"}};
        }
    }

    private class MockComputer extends Computer {
        int mockXCoordinate;
        int mockYCoordinate;

        @Override
        public void setShip() {
            mockXCoordinate = 1;
            mockYCoordinate = 1;
            mockBoard.mockGameBoard[mockXCoordinate][mockYCoordinate] = "1";
        }
    }
}