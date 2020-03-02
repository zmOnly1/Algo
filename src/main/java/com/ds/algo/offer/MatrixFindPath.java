package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/18.
 */
public class MatrixFindPath {

    public static void main(String[] args) {
        MatrixFindPath matrixFindPath = new MatrixFindPath();
        //char[] matrix = "abcesfcsadee".toCharArray();
        //char[] str = "abcb".toCharArray();
        char[] matrix = "abccdeacbabbeab".toCharArray();
        char[] str = "bcceabc".toCharArray();
        System.out.println(matrixFindPath.hasPath(matrix, 3, 5, str));
    }

    /**
     * [a b c e]
     * [s f c s]
     * [a d e e]
     * 包含bcced，不包含abcb
     */

    private int rows;
    private int cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;

        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i * cols + j] == str[0]) {
                    boolean found = findPoint(matrix, i, j, str, 0, visited);
                    if (found) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findPoint(char[] matrix, int i, int j, char[] str, int index, boolean[] visited) {
        if (index == str.length) {
            return true;
        }
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        if (!visited[i * cols + j] && matrix[i * cols + j] == str[index]) {
            visited[i * cols + j] = true;
            //right
            boolean found = findPoint(matrix, i, j + 1, str, index + 1, visited) ||
                                //down
                                findPoint(matrix, i + 1, j, str, index + 1, visited) ||
                                //left
                                findPoint(matrix, i, j - 1, str, index + 1, visited) ||
                                //up
                                findPoint(matrix, i - 1, j, str, index + 1, visited);

            visited[i * cols + j] = false;
            return found;
        }
        return false;
    }

}
