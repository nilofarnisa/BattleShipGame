package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.Collections;

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
    void shouldReturnFalseIfShipIsNotSunk() {
        MockShip mockShip = new MockShip();

        mockBoard.setBoard();

        assertFalse(mockShip.isSink());
    }

    @Test
    void shouldReturnTureIfSinkShipIsCalled() {
        MockShip mockShip = new MockShip();

        mockShip.sinkShip(0);

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
        int mockNoOfShips = 1;
        Integer[][] mockShipCoordinates = new Integer[mockNoOfShips][4];
        ArrayList<Integer> mockShipRemaining = new ArrayList<>(Collections.singletonList(0));

        @Override
        void setShipInVerticalPosition(int xCoordinate, int yCoordinate, int ship) {
            shipSize.set(0, 2);
            boardObject.board = mockBoard.mockGameBoard;
            shipCoordinates = mockShipCoordinates;
            super.setShipInVerticalPosition(0, 0, 0);
        }

        @Override
        void setShipInHorizontalPosition(int xCoordinate, int yCoordinate, int ship) {
            shipSize.set(0, 2);
            boardObject.board = mockBoard.mockGameBoard;
            shipCoordinates = mockShipCoordinates;
            super.setShipInHorizontalPosition(0, 0, 0);
        }

        @Override
        boolean isSink() {
            shipRemaining = mockShipRemaining;
            setShipInVerticalPosition(0, 0, 0);
            return super.isSink();
        }

        @Override
        void sinkShip(int ship) {
            isSinkShipCalled = true;
        }
    }
}