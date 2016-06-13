package com.nibado.example.nqueen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solver {
    public List<Board> solve(int size) {
        List<Board> solutions = new ArrayList<>();
        Set<Board> evaluated = new HashSet<>();
        Board current = new Board(size);

        solve(solutions, evaluated, current);

        return solutions;
    }

    private void solve(List<Board> solutions, Set<Board> evaluated, Board current) {
        if(current.getCount() == current.size) {
            solutions.add(current);
            return;
        }
        List<Board> nextBoards = new ArrayList<>();
        for(int y = 0;y < current.size;y++) {
            for(int x = 0;x < current.size;x++) {
                if(current.inColumn(x) || current.inRow(y) || current.inDiagonal(x, y)) {
                    continue;
                }
                Board newBoard = new Board(current);
                newBoard.set(x, y);
                if(evaluated.contains(newBoard)) {
                    continue;
                }
                evaluated.add(newBoard);
                nextBoards.add(newBoard);
            }
        }

        for(Board b : nextBoards) {
            solve(solutions, evaluated, b);
        }
    }
}
