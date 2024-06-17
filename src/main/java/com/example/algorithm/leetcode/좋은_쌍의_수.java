package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 좋은_쌍의_수 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] nums = {1, 2, 3, 1, 1, 3}; // 4

        Solution solution = new Solution();
        int result = solution.numIdenticalPairs(nums);
        System.out.println("result: " + result);

    }

    static class Solution {

        public int numIdenticalPairs(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
