package com.example.algorithm.leetcode;

import java.util.Comparator;
import java.util.stream.IntStream;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 배열의_두_요소의_최대_곱 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] numbers = {3, 4, 5, 2};  // 12
        int[] numbers2 = {1, 5, 4, 5}; // 16
        int[] numbers3 = {3, 7};     // 12

        // nums[i]-1) * (nums[j]-1)
        Solution solution = new Solution();
        int i = solution.maxProduct(numbers2);
        System.out.println(i);
    }

    class Solution {
        public int maxProduct(int[] numbers) {
            if(numbers.length == 2) {
                return (numbers[0] -1) * (numbers[1] - 1);
            }
            final int[] newArray = IntStream.of(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
            return (newArray[0] -1) * (newArray[1] -1);
        }
    }
}
