package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    MockBoard mockBoard = new MockBoard();
    MockShip mockShip = new MockShip("Carrier", 2);

    @Test
    void shouldReturnArrayWithShipAtVerticalPosition() {
        mockBoard.setBoard();

        mockShip.setShipInVerticalPosition(0, 0);

        assertArrayEquals(new String[][]{{"1", "0", "0"}, {"1", "0", "0"}, {"0", "0", "0"}}, mockBoard.mockGameBoard);
    }

    @Test
    void shouldReturnArrayWithShipAtHorizontalPosition() {
        mockBoard.setBoard();

        mockShip.setShipInHorizontalPosition(0, 0);

        assertArrayEquals(new String[][]{{"1", "1", "0"}, {"0", "0", "0"}, {"0", "0", "0"}}, mockBoard.mockGameBoard);
    }

    @Test
    void shouldReturnFalseIfShipIsNotSunk() {
        mockBoard.setBoard();

        assertFalse(mockShip.isSink());
    }

    @Test
    void shouldReturnTureIfSinkShipIsCalled() {
        mockShip.sinkShip();

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
        int[] mockShipCoordinates = new int[4];
        MockComputer mockComputer = new MockComputer();

        public MockShip(String shipName, int shipSize) {
            super(shipName, shipSize);
        }

        @Override
        void setShipInVerticalPosition(int xCoordinate, int yCoordinate) {
            boardObject.board = mockBoard.mockGameBoard;
            shipLocation = mockShipCoordinates;
            super.setShipInVerticalPosition(0, 0);
        }

        @Override
        void setShipInHorizontalPosition(int xCoordinate, int yCoordinate) {
            boardObject.board = mockBoard.mockGameBoard;
            shipLocation = mockShipCoordinates;
            super.setShipInHorizontalPosition(0, 0);
        }

        @Override
        boolean isSink() {
            computerObject.listOfShipsOnBoard = mockComputer.mockShipRemaining;
            setShipInVerticalPosition(0, 0);
            return super.isSink();
        }

        @Override
        void sinkShip() {
            isSinkShipCalled = true;
        }
    }

    private static class MockComputer extends Computer {
        ArrayList<Ship> mockShipRemaining = new ArrayList<>();
    }
}