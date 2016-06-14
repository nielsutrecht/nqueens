package com.nibado.example.nqueen;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(8);
    }

    @Test
    public void testToString() throws Exception {
        String expected = "X . . . . . . .\n" +
                ". . X . . . . .\n" +
                ". . . . X . . .\n" +
                ". . . . . . X .\n" +
                ". X . . . . . .\n" +
                ". . . X . . . .\n" +
                ". . . . . X . .\n" +
                ". . . . . . . X\n";
        board.set(0, 0);
        board.set(2, 1);
        board.set(4, 2);
        board.set(6, 3);
        board.set(1, 4);
        board.set(3, 5);
        board.set(5, 6);
        board.set(7, 7);

        assertThat(board.toString()).isEqualTo(expected);
    }

    @Test
    public void testInDiagonal() {
        board.set(3, 4);
        assertThat(board.inDiagonal(1, 1)).isFalse();
        assertThat(board.inDiagonal(1, 2)).isTrue();
        assertThat(board.inDiagonal(6, 7)).isTrue();
        assertThat(board.inDiagonal(4, 3)).isTrue();
        assertThat(board.inDiagonal(1, 6)).isTrue();
    }

    @Test
    public void testRotate() {
        board = new Board(3);
        board.set(1, 0);
        board.set(2, 1);
        board.set(0, 1);

        Board original = new Board(board);

        board = board.rotate();
        assertThat(board.isSet(1, 0)).isTrue();
        assertThat(board.isSet(1, 2)).isTrue();
        assertThat(board.isSet(0, 0)).isFalse();
        board = board.rotate();
        assertThat(board.isSet(0, 1)).isTrue();
        assertThat(board.isSet(1, 0)).isFalse();
        assertThat(board.isSet(0, 0)).isFalse();
        board = board.rotate();
        assertThat(board.isSet(1, 0)).isTrue();
        assertThat(board.isSet(2, 1)).isFalse();
        assertThat(board.isSet(0, 0)).isFalse();
        board = board.rotate();

        assertThat(board).isEqualTo(original);
    }
}