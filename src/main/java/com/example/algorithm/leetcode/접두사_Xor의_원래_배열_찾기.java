package com.example.algorithm.leetcode;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 접두사_Xor의_원래_배열_찾기 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // [5,7,2,3,2]
        int[] pref = {5, 2, 0, 3, 1};

        Solution solution = new Solution();
        int[] array = solution.findArray(pref);
        System.out.println(Arrays.toString(array));
    }

    static class Solution {

        public int[] findArray(int[] pref) {
            int[] result = new int[pref.length];
            result[0] = pref[0];
            for (int i = 1; i < pref.length; i++) {
                result[i] = pref[i] ^ pref[i - 1];
            }
            return result;
        }
    }
}
