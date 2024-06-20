package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 상위_K_빈번_요소 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 2
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        Solution solution = new Solution();
        int[] result = solution.topKFrequent(nums, k);
        System.out.println("result: " + Arrays.toString(result));
    }

    static class Solution {

        public int[] topKFrequent(int[] numbers, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int number : numbers) {
                map.merge(number, 1, Integer::sum);
            }
            return map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .mapToInt(Entry::getKey)
                .toArray();
        }
    }
}
