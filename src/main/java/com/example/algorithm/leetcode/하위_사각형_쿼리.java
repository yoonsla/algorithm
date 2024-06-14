package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 하위_사각형_쿼리 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[][] a = {{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
//        int[] b = {0, 2};
//        int[] c = {0,0,3,2,5};
//        int[] d = {0,2};
//        int[] e = {3,1};
//        int[] f = {3,0,3,2,10};
//        int[] g = {3,1};
//        int[] h = {0,2};

//        ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
//        [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
        SubRectangleQueries subrectangleQueries = new SubRectangleQueries(a); // null
        // 1 2 1
        // 4 3 4
        // 3 2 1
        // 1 1 1
        int param1 = subrectangleQueries.getValue(0, 2); // return 1
        subrectangleQueries.updateSubRectangle(0, 0, 3, 2, 5); // null
//        // 5 5 5
//        // 5 5 5
//        // 5 5 5
//        // 5 5 5
        int param2 = subrectangleQueries.getValue(0, 2); // return 5
        int param3 = subrectangleQueries.getValue(3, 1); // return 5
        subrectangleQueries.updateSubRectangle(3, 0, 3, 2, 10); // null
//        // 5   5   5
//        // 5   5   5
//        // 5   5   5
//        // 10  10  10
        int param4 = subrectangleQueries.getValue(3, 1);// return 10
        int param5 = subrectangleQueries.getValue(0, 2);// return 5

        // return : [null, 1, null, 5, 5, null, 10, 5]
        System.out.println("value: " + param5);
    }

    static class SubRectangleQueries {

        private final int[][] rectangle;

        public SubRectangleQueries(int[][] rectangle) {
            this.rectangle = new int[rectangle.length][];
            System.arraycopy(rectangle, 0, this.rectangle, 0, rectangle.length);
        }

        public void updateSubRectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    this.rectangle[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }
}
