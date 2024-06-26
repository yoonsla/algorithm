package com.example.algorithm.leetcode;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 상점_특별_할인이_포함된_최종_가격 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] prices = {8, 4, 6, 2, 3}; // 4, 2, 4, 2, 3
        Solution solution = new Solution();
        int[] result = solution.finalPrices(prices);
        System.out.println("result: " + Arrays.toString(result));

    }

    class Solution {

        public int[] finalPrices(int[] prices) {
            int[] result = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                result[i] = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] >= prices[j]) {
                        result[i] = prices[i] - prices[j];
                        break;
                    }
                }
            }
            return result;
        }
    }
}
