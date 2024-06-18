package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 셔플_스트링 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // "leetcode"
        String str = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};

        String str2 = "abc";
        int[] indices2 = {0, 1, 2};

        Solution solution = new Solution();
        String result = solution.restoreString(str, indices);
        System.out.println("result: " + result);

    }

    static class Solution {

        public String restoreString(String s, int[] indices) {
            char[] charArray = new char[indices.length];
            for (int i = 0; i < indices.length; i++) {
                charArray[indices[i]] = s.charAt(i);
            }
            return String.valueOf(charArray);
        }
    }
}
