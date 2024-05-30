package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class H_INDEX implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] citations = {3, 0, 6, 1, 5}; // 3

        Solution solution = new Solution();
        int result = solution.solution(citations);
        System.out.println("result: " + result);
    }

    class Solution {

        public int solution(int[] citations) {
            int result = 0;
            final int[] numbers = Arrays.stream(citations).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] >= i + 1) {
                    result = i + 1;
                }
            }
            return result;
        }
    }
}
