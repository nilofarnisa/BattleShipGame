package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

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

    private class MockPlayer extends Player {

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
}