package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/19.
 */
public class MatrixWalkThrough {

    public static void main(String[] args) {
        MatrixWalkThrough walkThrough = new MatrixWalkThrough();
        System.out.println(walkThrough.movingCount(10, 41, 41));
    }

    private int rows;
    private int cols;
    private boolean[][] visited;
    private int threshold;
    private int steps;

    public int movingCount(int threshold, int rows, int cols) {
        this.visited = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        this.steps = 0;
        moving(0, 0);
        return steps;
    }

    private void moving(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || isPointNotAllow(row, col, threshold)) {
            return;
        }
        if (!visited[row][col]) {
            visited[row][col] = true;
            steps++;
            //right
            moving(row, col + 1);
            //down
            moving(row + 1, col);
            //left
            moving(row, col - 1);
            //up
            moving(row - 1, col);
        }
    }

    private boolean isPointNotAllow(int row, int col, int threshold) {
        return sumAllNumbers(row) + sumAllNumbers(col) > threshold;
    }

    private int sumAllNumbers(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num = num / 10;
        }
        return result;
    }

}
