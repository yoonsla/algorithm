package com.example.algorithm.programmers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class K번째_수 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution solution = new Solution();
        int[] answer = solution.solution(array, commands);

        // [5,6,3]
        for (int i : answer) {
            System.out.println(i);
        }
    }

    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            return Arrays.stream(commands)
                .mapToInt(command -> {
                    final int[] ints = Arrays.copyOfRange(array, command[0] - 1, command[1]);
                    Arrays.sort(ints);
                    return ints[command[2] - 1];
                })
                .toArray();
        }
    }
}
