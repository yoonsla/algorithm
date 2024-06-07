package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 파스칼의_삼각형 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int n = 5;  // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        int n2 = 1; // [[1]]

        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(n);
        System.out.println("result");

    }

    static class Solution {

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        list.add(1);
                    } else {
                        list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                    }
                }
                result.add(list);
            }
            return result;
        }
    }
}
