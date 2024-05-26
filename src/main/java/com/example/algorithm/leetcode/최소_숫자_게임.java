package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 최소_숫자_게임 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Solution solution = new Solution();

        int[] numbers = {5, 4, 2, 3}; // 3,2,5,4
        int[] numbers2 = {2, 5}; // 5, 2
        int[] answer = solution.numberGame(numbers);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    static class Solution {

        public int[] numberGame(int[] nums) {
            Queue<Integer> priorityQueue = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
            int[] answer = new int[nums.length];
            int i = 0;
            while (!priorityQueue.isEmpty()) {
                final Integer first = priorityQueue.poll();
                final Integer second = priorityQueue.poll();
                if (second != null) {
                    answer[i++] = second;
                }
                if (first != null) {
                    answer[i++] = first;
                }
            }
            return answer;
        }
    }
}
