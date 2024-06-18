package com.example.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 조합을_위한_반복자 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String characters = "abc";
        int combinationLength = 2;

        CombinationIterator combinationIterator = new CombinationIterator(characters, combinationLength);
        String next = combinationIterator.next();// return "ab"
        boolean hasNext = combinationIterator.hasNext();// return True
        combinationIterator.next();    // return "ac"
        combinationIterator.hasNext(); // return True
        combinationIterator.next();    // return "bc"
        combinationIterator.hasNext(); // return False

        // [null, "ab", true, "ac", true, "bc", false]
        System.out.println("result");

    }

    static class CombinationIterator {

        private final Queue<String> queue = new LinkedList<>();
        private final String characters;

        public CombinationIterator(String characters, int combinationLength) {
            this.characters = characters;
            generateCombinations(0, combinationLength, new StringBuilder());
        }

        private void generateCombinations(int index, int combinationLength, StringBuilder stringBuilder) {
            if (combinationLength == 0) {
                queue.add(stringBuilder.toString());
                return;
            }
            int length = characters.length() - combinationLength;
            for (int i = index; i <= length; i++) {
                stringBuilder.append(characters.charAt(i));
                generateCombinations(i + 1, combinationLength - 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
