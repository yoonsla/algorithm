package com.example.algorithm.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 별_그래프의_중심_찾기 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};           // 2
        int[][] edges2 = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};  // 1

        Solution solution = new Solution();
        int result = solution.findCenter2(edges);
        System.out.println("result: " + result);
    }

    static class Solution {

        // 효율 똥망
        public int findCenter(int[][] edges) {
            final Map<Integer, Integer> map = Arrays.stream(edges)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> 1, Integer::sum));

            int result = 0;
            int maxCount = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    result = entry.getKey();
                }
            }
            return result;
        }

        // 중복된다는 건 배열에 무조건 들어간다는 것이기 때문에, 두번째 배열까지만 찾으면 됨
        public int findCenter2(int[][] edges) {

            if (edges[0][0] == edges[1][1]) {
                return edges[0][0];
            }
            if (edges[0][0] == edges[1][0]) {
                return edges[0][0];
            }
            return edges[0][1];
        }
    }
}
