package com.example.algorithm.leetcode;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 각_행의_최대값_삭제 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[][] grids = {{1, 2, 4}, {3, 3, 1}}; // 8
        int[][] grids2 = {{10}}; // 10

        Solution solution = new Solution();
        int result = solution.deleteGreatestValue(grids);
        System.out.println("result: " + result);

    }

    static class Solution {

        public int deleteGreatestValue(int[][] grids) {
            if (grids.length == 1) {
                for (int[] grid : grids) {
                    return Arrays.stream(grid).sum();
                }
            }
            for (int[] grid : grids) {
                Arrays.sort(grid);
            }
            int result = 0;
            for (int i = 0; i < grids[0].length; i++) {
                int max = 0;
                for (int[] grid : grids) {
                    max = Math.max(max, grid[i]);
                }
                result += max;
            }
            return result;
        }
    }
}
