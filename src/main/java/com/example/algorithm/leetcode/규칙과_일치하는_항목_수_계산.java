package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 규칙과_일치하는_항목_수_계산 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 1
        String[][] items = {{"phone", "blue", "pixel"}, {"computer", "silver", "lenovo"}, {"phone", "gold", "iphone"}};
        String ruleKey = "color";
        String ruleValue = "silver";

        List<List<String>> list = Arrays.stream(items)
            .map(Arrays::asList)
            .collect(Collectors.toList());
        Solution solution = new Solution();

        int result = solution.countMatches(list, ruleKey, ruleValue);
        System.out.println("result: " + result);

    }

    static class Solution {

        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int result = 0;
            int index = switch (ruleKey) {
                case "type" -> 0;
                case "color" -> 1;
                case "name" -> 2;
                default -> -1;
            };
            for (List<String> item : items) {
                if (item.get(index).equals(ruleValue)) {
                    result++;
                }
            }
            return result;
        }
    }
}
