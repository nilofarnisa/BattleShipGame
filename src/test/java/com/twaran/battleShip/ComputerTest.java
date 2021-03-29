package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerTest {

    MockBoard mockBoard = new MockBoard();
    MockShip mockShip = new MockShip("Destroyer", 2);

    @Test
    void shouldReturnTrueIfShipIsSetInSetShip() {
        MockComputer mockComputer = new MockComputer();

        mockBoard.setBoard();

        mockComputer.setShip(mockShip);

        assertEquals("1", mockBoard.mockGameBoard[1][1]);
    }

    @Test
    void shouldReturnTrueIfSetShipInHorizontalPositionIsCalled() {
        mockShip.setShipInHorizontalPosition(0, 0);

        assertTrue(mockShip.isHorizontalFunctionCalled);
    }

    @Test
    void shouldReturnTrueIfSetShipInVerticalPositionIsCalled() {
        mockShip.setShipInVerticalPosition(0, 0);

        assertTrue(mockShip.isVerticalFunctionCalled);
    }

    private static class MockShip extends Ship {
        boolean isHorizontalFunctionCalled = false;
        boolean isVerticalFunctionCalled = false;

        public MockShip(String shipName, int shipSize) {
            super(shipName, shipSize);
        }

        @Override
        void setShipInHorizontalPosition(int xCoordinate, int yCoordinate) {
            isHorizontalFunctionCalled = true;
        }

        @Override
        void setShipInVerticalPosition(int xCoordinate, int yCoordinate) {
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
        public void setShip(Ship mockShip) {
            mockXCoordinate = 1;
            mockYCoordinate = 1;
            mockBoard.mockGameBoard[mockXCoordinate][mockYCoordinate] = "1";
        }
    }
}