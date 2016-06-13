package com.nibado.example.nqueen;

import org.junit.Ignore;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

public class SolverTest {
    private static final int[] DISTINCTS = {1, 0, 0, 2, 10, 4, 40, 92, 352, 724};

    private Solver solver = new Solver();

    @Test
    public void testSolve1() {
        testSolve(1);
    }

    @Test
    public void testSolve2() {
        testSolve(2);
    }

    @Test
    public void testSolve3() {
        testSolve(3);
    }

    @Test
    public void testSolve4() {
        testSolve(4);
    }

    @Test
    public void testSolve5() {
        testSolve(5);
    }

    @Test
    public void testSolve6() {
        testSolve(6);
    }

    @Test
    public void testSolve7() {
        testSolve(7);
    }

    @Test
    public void testSolve8() {
        List<Board> solutions = testSolve(8);

        solutions.forEach(System.out::println);
    }

    @Test
    public void testSolve9() {
        testSolve(9);
    }

    @Test
    @Ignore //takes 100 seconds on my machine
    public void testSolve10() {
        testSolve(10);
    }

    private List<Board> testSolve(int n) {
        LocalDateTime start = now();
        List<Board> solutions = solver.solve(n);
        assertThat(solutions).hasSize(DISTINCTS[n - 1]);

        print(n, solutions.size(), Duration.between(start, now()));

        return solutions;
    }

    private static void print(int n, int solutions, Duration duration) {
        long millis = duration.toMillis();
        long seconds = millis / 1000;
        millis = millis - (seconds * 1000);
        System.out.printf("%s queens has %s solutions (%s seconds and %s milliseconds)\n", n, solutions, seconds, millis);
    }
}