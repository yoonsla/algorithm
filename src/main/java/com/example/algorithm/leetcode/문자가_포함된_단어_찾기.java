package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 문자가_포함된_단어_찾기 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] words = {"leet", "code"};
        char x = 'e';

        Solution solution = new Solution();
        List<Integer> result = solution.findWordsContaining(words, x);
        System.out.println("result: " + Arrays.toString(result.toArray()));

    }

    static class Solution {

        public List<Integer> findWordsContaining(String[] words, char x) {
            List<Integer> wordIndexList = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                boolean isContainWord = words[i].contains(String.valueOf(x));
                if (isContainWord) {
                    wordIndexList.add(i);
                }
            }
            return wordIndexList;
        }
    }
}
