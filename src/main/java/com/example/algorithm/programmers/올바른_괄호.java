package com.example.algorithm.programmers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 올바른_괄호 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String input = "()()";          // true
        String input2 = "(())()";       // true
        String input3 = ")()(";         // false;
        String input4 = "(()(";         // false;

        Solution solution = new Solution();
        boolean answer = solution.solution(input4);
        System.out.println(answer);
    }

    static class Solution {
        boolean solution(String input) {
            char[] parentheses = input.toCharArray();
            if (parentheses.length % 2 != 0) {
                return false;
            }
            int count = 0;
            for (char parenthesis : parentheses) {
                if (Parenthesis.isFirst(parenthesis)) {
                    count++;
                }
                if (Parenthesis.isLast(parenthesis)) {
                    if (count == 0) {
                        continue;
                    }
                    count--;
                }
                System.out.println(":::::" + count);
            }
            System.out.println(count);
            return count == 0;
        }

        enum Parenthesis {
            FIRST('('),
            LAST(')');

            private final char value;

            Parenthesis(char value) {
                this.value = value;
            }

            public static boolean isFirst(char parenthesis) {
                return Parenthesis.FIRST.getValue() == parenthesis;
            }

            public static boolean isLast(char parenthesis) {
                return Parenthesis.LAST.getValue() == parenthesis;
            }

            public char getValue() {
                return value;
            }
        }
    }
}
