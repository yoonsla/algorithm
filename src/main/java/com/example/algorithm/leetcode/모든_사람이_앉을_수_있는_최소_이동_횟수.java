package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 모든_사람이_앉을_수_있는_최소_이동_횟수 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 4
        int[] seats = {3, 1, 5};
        int[] students = {2, 7, 4};

        // 7
        int[] seats2 = {4, 1, 5, 9};
        int[] students2 = {1, 3, 2, 6};

        Solution solution = new Solution();
        int result = solution.minMovesToSeat(seats2, students2);
        System.out.println("result: " + result);
    }

    static class Solution {

        public int minMovesToSeat(int[] seats, int[] students) {
            Arrays.sort(seats);
            Arrays.sort(students);
            return IntStream.range(0, seats.length)
                .map(i -> Math.abs(seats[i] - students[i]))
                .sum();
        }
    }
}
