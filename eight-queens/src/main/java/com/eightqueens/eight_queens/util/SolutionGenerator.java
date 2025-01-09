package com.eightqueens.eight_queens.util;

import com.eightqueens.eight_queens.model.Solution;

import java.util.ArrayList;
import java.util.List;

public class SolutionGenerator {

    private static final int BOARD_SIZE = 8;
    private List<Solution> solutions = new ArrayList<>();

    public SolutionGenerator() {
        solve(new int[BOARD_SIZE], 0);
    }

    private void solve(int[] queens, int row) {
        if (row == BOARD_SIZE) {
            solutions.add(new Solution(createBoard(queens)));
            return;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                solve(queens, row + 1);
            }
        }
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private int[][] createBoard(int[] queens) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i][queens[i]] = 1;
        }
        return board;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }
}