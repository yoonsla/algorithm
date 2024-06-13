package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class D일_이내에_소화물을_배송할_수_있는_능력 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 15
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        // 6
        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int days2 = 3;

        Solution solution = new Solution();
        int result = solution.shipWithinDays(weights, days);
        System.out.println("result : " + result);
    }

    static class Solution {

        // FIXME : 이해 안됨
        public int shipWithinDays(int[] weights, int days) {

            int sum = 0;
            int max = 0;
            for (var weight : weights) {
                sum += weight;
                max = Math.max(max, weight);
            }
            int start = max;
            int end = sum;
            while (start <= end) {
                int ship = 0;
                int count = 0;
                int middle = start + (end - start) / 2;
                for (int weight : weights) {
                    if (ship + weight > middle) {
                        ship = 0;
                        count++;
                    }
                    ship += weight;
                }
                if (count >= days) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            return start;
        }
    }
}
