package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 피보나치_수열 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int n = 2;  // 1
        int n2 = 3; // 2
        int n3 = 4; // 3

        Solution solution = new Solution();
        int fib = solution.fib(n3);
        System.out.println(fib);

    }

    static class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n < 2) {
                return 1;
            } else {
                return fib(n - 1) + fib(n - 2);
            }
        }
    }
}
