package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/9.
 */
public class Matrix {

    public static void main(String[] args) {
        //int[][] arrays = {
        //    {1, 2, 3, 4},
        //    {5, 6, 7, 8},
        //    {9, 10, 11, 12},
        //    {13, 14, 15, 16}
        //};
        //int[][] arrays = {
        //    {1},
        //    {2},
        //    {3},
        //    {4},
        //    {5}
        //};
        int[][] arrays = {
            {1,2,3,4,5}
        };
        //int[][] arrays = {
        //    {1, 2, 3, 4, 5},
        //    {6, 7, 8, 9, 10},
        //    {11, 12, 13, 14, 15}
        //};
        Matrix matrix = new Matrix();
        System.out.println(matrix.printMatrix(arrays));
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        print(list, matrix, 0, 0, row, col);
        return list;
    }

    private void print(ArrayList<Integer> list, int[][] matrix,
                       int leftUpX, int leftUpY,
                       int rightDownX, int rightDownY) {
        if (leftUpX > rightDownX || leftUpY > rightDownY) {
            return;
        }
        //1: (leftUpX,leftUpY) to (leftUpX,rightDownY)
        for (int i = leftUpY; i <= rightDownY; i++) {
            list.add(matrix[leftUpX][i]);
        }
        if(leftUpX == rightDownX){
            return;
        }
        //2: (leftUpX + 1,rightDownY) to (rightDownX,rightDownY)
        for (int i = leftUpX + 1; i <= rightDownX; i++) {
            list.add(matrix[i][rightDownY]);
        }
        if(leftUpY == rightDownY){
            return;
        }
        //3: (rightDownX,rightDownY - 1) down (rightDownX, leftUpY)
        for (int i = rightDownY - 1; i >= leftUpY; i--) {
            list.add(matrix[rightDownX][i]);
        }
        //4: (rightDownX - 1,leftUpY) down (leftUpX + 1,leftUpY)
        for (int i = rightDownX - 1; i >= leftUpX + 1; i--) {
            list.add(matrix[i][leftUpY]);
        }
        print(list, matrix, leftUpX + 1, leftUpY + 1, rightDownX - 1, rightDownY - 1);
    }


}
