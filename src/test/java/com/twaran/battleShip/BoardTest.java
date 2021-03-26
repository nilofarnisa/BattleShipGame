package com.twaran.battleShip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    static MockBoard mockBoardObject = new MockBoard();

    @Test
    void shouldReturnArrayIfSetBoardFunctionIsCalled() {
        mockBoardObject.setBoard();

        assertArrayEquals(new String[][]{{"0", "0"},
                {"0", "0"}}, mockBoardObject.mockBoard);
    }

    private static class MockBoard extends Board {

        public String[][] mockBoard;

        @Override
        public void setBoard() {
            Board b1 = mockBoardObject;
            b1.noOfRows = 2;
            b1.noOfCols = 2;
            mockBoard = new String[noOfRows][noOfCols];
            b1.board = mockBoard;
            super.setBoard();
        }
    }
}