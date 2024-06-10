package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 삽입_위치_검색 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] numbers = {1, 3, 5, 6};
        int target = 5;     // 2
        int target2 = 2;    // 1
        int target3 = 7;    // 4
        int target4 = 0;    // 0

        int[] numbers2 = {3, 6, 7, 8, 10};
        int target5 = 5;    // 1

        int[] numbers3 = {2, 3, 4, 7, 8, 9};
        int target6 = 11;   // 6

        int[] numbers4 = {-1,3,5,6};
        int target7 = 0;    // 1

        Solution solution = new Solution();
        int result = solution.searchInsert(numbers4, target7);
        System.out.println("result: " + result);

    }

    static class Solution {

        public int searchInsert(int[] numbers, int target) {
            int start = 0;
            int end = numbers.length - 1;
            while (start <= end) {
                int middle = start + (end - start) / 2;
                if (numbers[middle] == target) {
                    return middle;
                }
                if (numbers[middle] > target) {
                    end = middle - 1;
                }
                if (numbers[middle] < target) {
                    start = middle + 1;
                }
            }
            return start;
        }
    }
}
