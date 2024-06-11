package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 정렬된_행렬에서_음수_계산 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}; // 8
        int[][] grid2 = {{3, 2}, {1, 0}}; // 0
        int[][] grid3 = {{5,1,0},{-5,-5,-5}}; // 3

        Solution solution = new Solution();
        int result = solution.countNegatives(grid3);
        System.out.println("result: " + result);

    }

    static class Solution {

        public int countNegatives(int[][] gridArray) {

            int count = 0;
            for (int[] grid : gridArray) {
                int start = 0;
                int end = grid.length - 1;
                while (start <= end) {
                    int middle = start + (end - start) / 2;
                    if (grid[middle] < 0) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                }
                count += grid.length - start;
            }
            return count;
        }

        // 일반 for문
        public int countNegatives2(int[][] gridArray) {

            int count = 0;
            for (int[] grid : gridArray) {
                for (int i : grid) {
                    if (i < 0) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
