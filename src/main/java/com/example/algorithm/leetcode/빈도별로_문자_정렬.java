package com.example.algorithm.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 빈도별로_문자_정렬 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // eetr or eert
        String str = "tree";

        // cccaaa or aaaccc
        String str2 = "cccaaa";

        Solution solution = new Solution();
        String result = solution.frequencySort(str2);
        System.out.println("result: " + result);
    }

    static class Solution {

        public String frequencySort(String str) {

            final Map<Character, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                frequencyMap.merge(str.charAt(i), 1, Integer::sum);
            }

            final List<Entry<Character, Integer>> sortedList = frequencyMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toList());

            final StringBuilder stringBuilder = new StringBuilder();
            for (Entry<Character, Integer> entry : sortedList) {
                if (entry.getValue() > 1) {
                    stringBuilder.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
                } else {
                    stringBuilder.append(entry.getKey());
                }
            }
            return stringBuilder.toString();
        }
    }
}
