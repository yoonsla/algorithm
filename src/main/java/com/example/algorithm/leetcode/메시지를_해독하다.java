package com.example.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 메시지를_해독하다 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // "this is a secret"
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        Solution solution = new Solution();
        String result = solution.decodeMessage(key, message);
        System.out.println("result: " + result);
    }

    static class Solution {

        public String decodeMessage(String key, String message) {
            String replaceKey = key.replaceAll(" ", "");

            Set<Character> characterSet = new LinkedHashSet<>();
            for (char character : replaceKey.toCharArray()) {
                characterSet.add(character);
            }

            Map<Character, Character> map = new HashMap<>();
            int index = 0;
            for (Character character : characterSet) {
                map.put(character, (char) ('a' + index));
                index++;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (char character : message.toCharArray()) {
                if (character == ' ') {
                    stringBuilder.append(' ');
                } else {
                    stringBuilder.append(map.get(character));
                }
            }
            return stringBuilder.toString();
        }
    }
}
