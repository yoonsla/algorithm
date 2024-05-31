package com.example.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 게임_맵_최단거리 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[][] arr = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}; // 11
        int[][] arr2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}; // -1

        Solution solution = new Solution();
        int result = solution.solution(arr2);
        System.out.println(result);

    }

    class Solution {

        public int solution(int[][] maps) {

            int n = maps.length;
            int m = maps[0].length;

            return 0;
        }

        private void bfs(int x, int y, int[][] maps) {
            Queue<Point> queue = new LinkedList<>();
            for (int i = 0; i < maps.length; i++) {
                queue.offer(new Point(x, y));
            }
        }
    }

    class Point {

        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
