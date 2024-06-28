package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 배열_크기를_절반으로_줄이기 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7}; // 2
        int[] arr2 = {7, 7, 7, 7, 7, 7}; // 1

        Solution solution = new Solution();
        int result = solution.minSetSize(arr);
        System.out.println("result: " + result);
    }

    // FIXME : 다시 풀어보기
    static class Solution {

        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int element : arr) {
                map.put(element, map.getOrDefault(element, 0) + 1);
            }
            if (map.size() == 1) {
                return 1;
            }
            List<Integer> ordered = new ArrayList<>(map.values());
            ordered.sort(Collections.reverseOrder());

            int index = 0;
            int count = 0;
            while (count * 2 < arr.length) {
                Integer value = ordered.get(index);
                count = count + value;
                index++;
            }
            return index;
        }
    }
}
