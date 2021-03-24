package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BattleShipGameTest {
    @Test
    void shouldReturnFunctionCalledIfTheShootShipFunctionIsCalled() {
        MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

        String shootResult = mockBattleShipGame.shootShip(0, 0);

        assertEquals("shootShip function called",shootResult);
    }

    @Test
    void shouldReturnTrueIfTheIsHitFunctionIsCalled() {
        MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

        boolean shootResult = mockBattleShipGame.isHit(0,0);

        assertTrue(shootResult);
    }

    @Test
    void shouldReturnTrueIfTheIsPrintFunctionIsCalled() {
        MockBattleShipGame mockBattleShipGame = new MockBattleShipGame();

        mockBattleShipGame.printBoard();

        assertTrue(mockBattleShipGame.isPrintCalled);
    }

    static class MockBattleShipGame extends BattleShipGame{

        boolean isPrintCalled = false;
        @Override
        public String shootShip(int x,int y) {
            return "shootShip function called";
        }

        @Override
        public  boolean isHit(int x,int y)
        {
            return true;
        }

        @Override
        public void printBoard() {
            isPrintCalled = true;
        }

    }

}
