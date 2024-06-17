package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 사람들이_속한_그룹_크기에_따라_사람들을_그룹화 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3}; // [[5],[0,1,2],[3,4,6]]

        Solution solution = new Solution();
        List<List<Integer>> result = solution.groupThePeople(groupSizes);
        System.out.println(Arrays.toString(result.toArray()));
    }

    static class Solution {

        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            final List<List<Integer>> resultList = new ArrayList<>();
            final Map<Integer, List<Integer>> groupMap = new HashMap<>();

            for (int i = 0; i < groupSizes.length; i++) {
                final int groupSize = groupSizes[i];
                final List<Integer> groupList = groupMap.computeIfAbsent(groupSize, mapping -> new ArrayList<>());
                groupList.add(i);
                if (groupList.size() == groupSize) {
                    resultList.add(new ArrayList<>(groupList));
                    groupList.clear();
                }
            }
            return resultList;
        }
    }
}
