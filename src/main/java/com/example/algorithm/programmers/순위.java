package com.example.algorithm.programmers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 순위 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 2
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        Solution solution = new Solution();
        int result = solution.solution(n, results);
        System.out.println("result : " + result);
    }

    static class Solution {

        // graph[A][B] = graph[A][C] + graph[C][B]
        public int solution(int n, int[][] results) {

            int[][] grade = new int[n + 1][n + 1];
            for (int[] result : results) {
                final int winner = result[0];
                final int loser = result[1];
                grade[winner][loser] = 1;
                grade[loser][winner] = -1;
            }
            for (int c = 1; c <= n; c++) {
                for (int a = 1; a <= n; a++) {
                    for (int b = 1; b <= n; b++) {
                        // c를 거쳐서 a가 c한테 이기고 c가 b한테 이기면 a가 b를 이긴다.
                        if (grade[a][c] == 1 && grade[c][b] == 1) {
                            grade[a][b] = 1;
                            grade[b][a] = -1;
                        }
                        // c를 거쳐서 a가 c한테 지고 c가 b한테 지면 b가 a를 이긴다.
                        if (grade[a][c] == -1 && grade[c][b] == -1) {
                            grade[a][b] = -1;
                            grade[b][a] = 1;
                        }
                    }
                }
            }
            // 결과 값이 0이 아니면 확실
            int answer = 0;
            for (int a = 1; a <= n; a++) {
                int count = 0;
                for (int b = 1; b <= n; b++) {
                    if (grade[a][b] == 0) {
                        count ++;
                    }
                }
                if (count == 1) {
                    answer ++;
                }
            }
            return answer;
        }
    }
}
