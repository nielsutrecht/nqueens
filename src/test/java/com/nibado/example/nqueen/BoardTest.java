package com.nibado.example.nqueen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;
    @Before
    public void setUp() throws Exception {
        board = new Board(8);
    }

    @Test
    public void testToString() throws Exception {
        board.set(0, 0);
        board.set(2, 1);
        board.set(4, 2);
        board.set(6, 3);
        board.set(1, 4);
        board.set(3, 5);
        board.set(5, 6);
        board.set(7, 7);

        System.out.println(board);
    }
}