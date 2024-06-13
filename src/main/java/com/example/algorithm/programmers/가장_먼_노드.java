package com.example.algorithm.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 가장_먼_노드 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 3
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        Solution solution = new Solution();
        int result = solution.solution(n, vertex);
        System.out.println("result : " + result);
    }

    static class Solution {

        // TODO : 좀 더 확인
        public int solution(int n, int[][] edges) {
            int result = 0;
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                list.get(edge[0]).add(edge[1]);
                list.get(edge[1]).add(edge[0]);
            }
            List<List<Integer>> sortedList = list.stream()
                .map(v -> v.stream().sorted().collect(Collectors.toList()))
                .collect(Collectors.toList());

            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            visited[1] = true;
            while (!queue.isEmpty()) {
                for (int i = 0; i < queue.size(); i++) {
                    int node = queue.poll();
                    for (int j = 0; j < list.get(node).size(); j++) {
                        if (!visited[sortedList.get(node).get(j)]) {
                            visited[sortedList.get(node).get(j)] = true;
                            queue.offer(sortedList.get(node).get(j));
                        }
                    }
                }
                result = queue.size();
            }
            return result;
        }
    }
}
