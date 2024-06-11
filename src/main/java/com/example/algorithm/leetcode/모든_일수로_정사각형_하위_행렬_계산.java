package com.example.algorithm.leetcode;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 모든_일수로_정사각형_하위_행렬_계산 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[][] doubleArray = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        Solution solution = new Solution();
        int result = solution.countSquares(doubleArray);
        System.out.println("result: " + result);
    }

    static class Solution {

        int count = 0;

        public int countSquares(int[][] matrix) {
            for (int[] row : matrix) {
                count += Arrays.stream(row)
                    .filter(v -> v == 1)
                    .count();
            }
            for (int i = 0; i <= matrix.length; i++) {
                int matrix1 = matrix[0][i];
//                System.out.println(matrix1);
                for (int j = 0; j <= i; j++) {
                    System.out.println(j);
                }
            }
            return 0;
        }
    }
}
