package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 비트_계산 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int n = 2;  // [0,1,1]
        int n2 = 5; // [0,1,1,2,1,2]

        Solution solution = new Solution();
        int[] result = solution.countBits(n2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class Solution {

        public int[] countBits(int n) {

            List<String> binaryList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                String binary = Integer.toBinaryString(i);
                binaryList.add(binary);
            }
            return binaryList.stream()
                .map(v -> {
                    if (v.length() >= 2) {
                        return Arrays.stream(v.split(""))
                            .map(i -> {
                                int count = 0;
                                if (i.contains("1")) {
                                    count++;
                                }
                                return count;
                            }).mapToInt(Integer::intValue)
                            .sum();
                    }
                    return Integer.parseInt(v);
                })
                .mapToInt(Integer::intValue)
                .toArray();
        }
    }
}
