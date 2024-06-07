package com.example.algorithm.leetcode;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 정렬된_모음_문자열_개수_계산 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // ["a","e","i","o","u"].
        // ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu"," oo","ou","uu"].

        int n = 1;      // 5
        int n2 = 2;     // 15
        int n3 = 33;    // 66045

        Solution solution = new Solution();
        int result = solution.countVowelStrings2(n2);
        System.out.println(result);
    }

    static class Solution {

        public int countVowelStrings(int n) {
            int[] arr = new int[5];
            Arrays.fill(arr, 1);
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum += arr[j];
                    arr[j] = sum;
                }
            }
            return Arrays.stream(arr).max().stream().sum();
        }

        public int countVowelStrings2(int n) {
            return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
        }
    }
}
