package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class H_INDEX_2 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] citations = {0, 1, 3, 5, 6};  // 3
        int[] citations2 = {1, 2, 100};     // 2
        int[] citations3 = {0};             // 0

        Solution solution = new Solution();
        int result = solution.hIndex2(citations3);
        System.out.println("result: " + result);
    }

    static class Solution {

        public int hIndex(int[] citations) {
            int result = 0;
            int[] numbers = Arrays.stream(citations).boxed()
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

        public int hIndex2(int[] citations) {
            int start = 0;
            int end = citations.length - 1;
            while (start <= end) {
                int middle = start + (end - start) / 2;
                if (citations[middle] < citations.length - middle) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            return citations.length - start;
        }
    }
}
