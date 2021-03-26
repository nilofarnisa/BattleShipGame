package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    MockBoard mockBoard = new MockBoard();

    @Test
    void shouldReturnArrayWithShipAtVerticalPosition() {
        MockShip mockShip = new MockShip();

        mockBoard.setBoard();

        mockShip.setShipInVerticalPosition(0, 0, 0);

        assertArrayEquals(new String[][]{{"1", "0", "0"}, {"1", "0", "0"}, {"0", "0", "0"}}, mockBoard.mockGameBoard);
    }

    @Test
    void shouldReturnArrayWithShipAtHorizontalPosition() {
        MockShip mockShip = new MockShip();

        mockBoard.setBoard();

        mockShip.setShipInHorizontalPosition(0, 0, 0);

        assertArrayEquals(new String[][]{{"1", "1", "0"}, {"0", "0", "0"}, {"0", "0", "0"}}, mockBoard.mockGameBoard);
    }

    @Test
    void shouldReturnTrueIfIsSinkAndSinkShipIsCalled() {
        MockShip mockShip = new MockShip();

        assertTrue(mockShip.isSink());

        assertTrue(mockShip.isSinkShipCalled);
    }

    private static class MockBoard extends Board {
        String[][] mockGameBoard;

        @Override
        public void setBoard() {
            mockGameBoard = new String[][]{{"0", "0", "0"}, {"0", "0", "0"}, {"0", "0", "0"}};
        }
    }

    private class MockShip extends Ship {

        boolean isSinkShipCalled = false;

        @Override
        void setShipInVerticalPosition(int xCoordinate, int yCoordinate, int ship) {
            shipSize.set(0, 2);
            boardObject.board = mockBoard.mockGameBoard;
            super.setShipInVerticalPosition(0, 0, 0);
        }

        @Override
        void setShipInHorizontalPosition(int xCoordinate, int yCoordinate, int ship) {
            shipSize.set(0, 2);
            boardObject.board = mockBoard.mockGameBoard;
            super.setShipInHorizontalPosition(0, 0, 0);
        }

        @Override
        boolean isSink() {
            sinkShip(0);
            return true;
        }

        @Override
        void sinkShip(int ship) {
            isSinkShipCalled = true;
        }
    }
}