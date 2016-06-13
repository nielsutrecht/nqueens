package com.nibado.example.nqueen;

import java.util.BitSet;

public class Board {
    public final int size;
    private final BitSet squares;
    private final BitSet rows;
    private final BitSet columns;
    private int count;

    public Board(int size) {
        this.count = 0;
        this.size = size;
        this.squares = new BitSet(size * size);
        this.rows = new BitSet(size);
        this.columns = new BitSet(size);
    }

    public Board(Board other) {
        this(other.size);

        squares.or(other.squares);
        rows.or(other.rows);
        columns.or(other.columns);
        this.count = other.count;
    }

    public boolean isSet(int x, int y) {
        return squares.get(x + y * size);
    }

    public boolean inRow(int y) {
        return rows.get(y);
    }

    public boolean inColumn(int x) {
        return columns.get(x);
    }

    public boolean inDiagonal(int x, int y) {
        int min = Math.min(x, y);

        int x2 = x - min;
        int y2 = y - min;
        while(x2 < size && y2 < size) {
            if(isSet(x2, y2)) {
                return true;
            }
            x2++;
            y2++;
        }

        int max = Math.min(size - x, y);
        x2 = x + max;
        y2 = y - max;

        while(x2 >= 0 && y2 < size) {
            if(isSet(x2, y2)) {
                return true;
            }
            x2--;
            y2++;
        }

        return false;
    }

    public void set(int x, int y) {
        squares.set(x + y * size);
        rows.set(y);
        columns.set(x);
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return squares.equals(board.squares);
    }

    @Override
    public int hashCode() {
        return squares.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for(int y = 0;y < size;y++) {
            for(int x = 0;x < size;x++) {
                if(x > 0) {
                    b.append(' ');
                }
                b.append(isSet(x, y) ? 'X' : '.');
            }
            b.append('\n');
        }

        return b.toString();
    }
}
