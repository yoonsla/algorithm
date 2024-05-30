package com.example.algorithm.programmers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class 모의고사 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
            1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
            2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
            3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
         */
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 2};

        Solution solution = new Solution();
        int[] result = solution.solution(arr2);
        for (int i : result) {
            System.out.println("test");
        }
    }

    class Solution {
        public int[] solution(int[] answers) {
            int[] userAnswer1 = {1, 2, 3, 4, 5};
            int[] userAnswer2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] userAnswer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int[] result = new int[3];
            for (int i = 0; i < answers.length; i++) {
                if (userAnswer1[i % userAnswer1.length] == answers[i]) {
                    result[0]++;
                }
                if (userAnswer2[i % userAnswer2.length] == answers[i]) {
                    result[1]++;
                }
                if (userAnswer3[i % userAnswer3.length] == answers[i]) {
                    result[2]++;
                }
            }
            int max = Math.max(result[0], Math.max(result[1], result[2]));
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < result.length; i++) {
                if (max == result[i]) {
                    list.add(i);
                }
            }
            return list.stream().mapToInt(i -> i + 1).toArray();
        }
    }
}
