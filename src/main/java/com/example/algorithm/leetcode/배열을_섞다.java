package com.example.algorithm.leetcode;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 배열을_섞다 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        Solution solution = new Solution();
        int[] result = solution.shuffle(nums, n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class Solution {

        public int[] shuffle(int[] nums, int n) {

            final int half = nums.length / 2;
            final int[] x = Arrays.copyOfRange(nums, 0, half);
            final int[] y = Arrays.copyOfRange(nums, half, nums.length);

            int[] result = new int[nums.length];
            for (int i = 0; i < n; i++) {
                final int calculate = 2 * i;
                result[calculate] = x[i];
                result[calculate + 1] = y[i];
            }
            return result;
        }
    }
}
