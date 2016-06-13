package com.nibado.example.nqueen;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    public List<Board> solve(int size) {

    }

    public void solve(List<Board> solutions, Board current) {
        if(current.getCount() == current.size) {
            solutions.add(current);
            return;
        }
        List<Board> nextBoards = new ArrayList<Board>();
        for(int y = 0;y < current.size;y++) {
            for(int x = 0;x < current.size;x++) {
                if(current.inColumn(x) || current.inRow(y) || current.inDiagonal(x, y)) {
                    continue;
                }
                Board newBoard = new Board(current);
                newBoard.set(x, y);
                nextBoards.add(newBoard);
            }
        }

        nextBoards.forEach(System.out::println);
    }
}
