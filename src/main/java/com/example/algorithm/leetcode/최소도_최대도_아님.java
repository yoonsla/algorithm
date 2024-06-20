package com.example.algorithm.leetcode;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 최소도_최대도_아님 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] nums = {3, 2, 1, 4}; // 2 or 3

        Solution solution = new Solution();
        int result = solution.findNonMinOrMax(nums);
        System.out.println("result: " + result);

    }

    static class Solution {

        public int findNonMinOrMax(int[] numbers) {
            final int max = Arrays.stream(numbers).max().orElse(-1);
            final int min = Arrays.stream(numbers).min().orElse(-1);
            return Arrays.stream(numbers)
                .filter(v -> v != max && v != min)
                .findFirst()
                .orElse(-1);
        }
    }
}
