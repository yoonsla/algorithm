package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 매트릭스의_K개_최약_행 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // [2,0,3]
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;

        // [0,2,3,1]
        int[][] mat2 = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int k2 = 2;

        Solution solution = new Solution();
        int[] result = solution.kWeakestRows(mat2, k2);
        System.out.println("result: " + Arrays.toString(result));
    }

    static class Solution {

        public int[] kWeakestRows(int[][] mats, int k) {

            final Map<Integer, Integer> rowMap = IntStream.range(0, mats.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> Arrays.stream(mats[i]).sum()));

            final Map<Integer, Integer> sortedMap = rowMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(LinkedHashMap::new, (v, entry) -> v.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);

            return sortedMap.keySet().stream()
                .mapToInt(v -> v)
                .limit(k)
                .toArray();
        }
    }
}
