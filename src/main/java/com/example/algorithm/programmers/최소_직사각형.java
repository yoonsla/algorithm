package com.example.algorithm.programmers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 최소_직사각형 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[][] array1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}; // 4000
        int[][] array2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}; // 120
        int[][] array3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}; // 133

        Solution solution = new Solution();
        int result = solution.solution(array1);
        System.out.println(result);
    }

    class Solution {

        public int solution(int[][] doubleArray) {
            int width = 0;
            int height = 0;
            for (int[] array : doubleArray) {
                int max = Math.max(array[0], array[1]);
                int min = Math.min(array[0], array[1]);
                width = Math.max(max, width);
                height = Math.max(min, height);
            }
            return width * height;
        }
    }
}
