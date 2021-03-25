package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldReturnArrayIfSetBoardFunctionIsCalled() {
        MockBoard mockBoardObject = new MockBoard();

        mockBoardObject.setBoard();

        assertArrayEquals(new String[][]{{"0", "0"},
                {"0", "0"}}, mockBoardObject.mockBoard);
    }

    private static class MockBoard extends Board {

        public String[][] mockBoard;

        @Override
        public void setBoard() {
            mockBoard = new String[][]{{"0", "0"}, {"0", "0"}};
        }
    }
}