package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 균형_잡힌_문자열로_문자열_분할 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String text1 = "RLRRLLRLRL"; // 4
        String text2 = "RLRRRLLRLL"; // 2
        String text3 = "LLLLRRRR";   // 1

        Solution solution = new Solution();
        int result = solution.balancedStringSplit(text1);
        System.out.println(result);
    }

    static class Solution {
        public int balancedStringSplit(String text) {
            int count = 0;
            int result = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == 'R') {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    result++;
                }
            }
            return result;
        }
    }
}
