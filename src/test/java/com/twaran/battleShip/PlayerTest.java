package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

    @Test
    void shouldReturnTrueIfPrintBoardIsCalled() {
        MockPlayer mockPlayer = new MockPlayer();

        mockPlayer.printBoard();

        assertTrue(mockPlayer.isPrintCalled);
    }

    @Test
    void shouldReturnHITIfShipIsShot() {
        MockPlayer mockPlayer = new MockPlayer();

        mockBattleShipGame.result = true;

        String message = mockPlayer.shootShip(0, 0);

        assertEquals("HIT", message);
    }

    @Test
    void shouldReturnMISSIfShipIsNotShot() {
        MockPlayer mockPlayer = new MockPlayer();

        String message = mockPlayer.shootShip(0, 0);

        assertEquals("MISS", message);
    }

    @Test
    void shouldReturnTrueIfIsSinkIsCalled() {
        MockShip mockShip = new MockShip();

        assertTrue(mockShip.isSink());
    }

    private class MockPlayer extends Player {

        boolean isPrintCalled = false;

        @Override
        public void printBoard() {
            isPrintCalled = true;
        }

        @Override
        public String shootShip(int xCoordinate, int yCoordinate) {
            if (mockBattleShipGame.isHit(xCoordinate, yCoordinate)) {
                return "HIT";
            }
            return "MISS";
        }
    }

    private static class MockBattleShipGame extends BattleShipGame {
        boolean result = false;

        @Override
        public boolean isHit(int xCoordinate, int yCoordinate) {
            return result;
        }
    }

    private static class MockShip extends Ship {

        @Override
        boolean isSink() {
            return true;
        }
    }
}