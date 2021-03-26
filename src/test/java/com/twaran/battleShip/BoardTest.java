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
            Board gameBoard = mockBoardObject;
            gameBoard.noOfRows = 2;
            gameBoard.noOfCols = 2;
            mockBoard = new String[noOfRows][noOfCols];
            gameBoard.board = mockBoard;
            super.setBoard();
        }
    }
}