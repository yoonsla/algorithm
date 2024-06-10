package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 제수_게임 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int n = 2;  // true
        int n2 = 3; // false

        Solution solution = new Solution();
        boolean result = solution.divisorGame(n2);
        System.out.println(result);
    }

    static class Solution {


        int count = 0;

        public boolean divisorGame(int n) {

            if (n < 2) {
                return false;
            }
            divisorGame(n - 1);
            count ++;
            return count % 2 != 0;
        }
    }
}
