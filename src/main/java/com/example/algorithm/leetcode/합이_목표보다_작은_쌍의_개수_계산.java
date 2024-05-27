package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 합이_목표보다_작은_쌍의_개수_계산 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Integer> numbers = new ArrayList<>(); // 3
        numbers.add(-1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        int target = 2;

        List<Integer> numbers2 = new ArrayList<>(); // 10
        numbers2.add(-6);
        numbers2.add(2);
        numbers2.add(5);
        numbers2.add(-2);
        numbers2.add(-7);
        numbers2.add(-1);
        numbers2.add(3);
        int target2 = -2;

        // 0 <= i < j < n 및 nums[i] + nums[j] < target
        Solution solution = new Solution();
        int i = solution.countPairs(numbers2, target2);
        System.out.println(i);
    }

    class Solution {

        public int countPairs(List<Integer> numbers, int target) {
            int answer = 0;
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = 0; j < numbers.size(); j++) {
                    if (i >= j) {
                        continue;
                    }
                    if (numbers.get(i) + numbers.get(j) >= target) {
                        continue;
                    }
                    answer++;
                }
            }
            return answer;
        }
    }
}
