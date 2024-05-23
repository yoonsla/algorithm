package com.example.algorithm.leetcode;


import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

//@Component
public class 유효한_괄호 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String input = "()";        // true
        String input2 = "()[]{}";   // true
        String input3 = "(]";       // false
        String input4 = "()[}{]";   // false
        String input5 = "{[]}";        // true

        Solution solution = new Solution();
        boolean valid = solution.isValid(input5);
        System.out.println(valid);
    }

    static class Solution {

        public boolean isValid(String input) {
            char[] chars = input.toCharArray();
            Stack<Parenthesis> stack = new Stack<>();
            for (Character ch : chars) {
                final Parenthesis parenthesis = Parenthesis.typeOf(ch);
                if (parenthesis.isFirst()) {
                    stack.push(parenthesis);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    final Parenthesis popStack = stack.pop();
                    if (!isMatchingPair(popStack, parenthesis)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatchingPair(Parenthesis first, Parenthesis last) {
            return (first == Parenthesis.SMALL_FIRST && last == Parenthesis.SMALL_LAST) ||
                (first == Parenthesis.MEDIUM_FIRST && last == Parenthesis.MEDIUM_LAST) ||
                (first == Parenthesis.LARGE_FIRST && last == Parenthesis.LARGE_LAST);
        }

        enum Parenthesis {
            SMALL_FIRST('(', true),
            SMALL_LAST(')', false),
            MEDIUM_FIRST('{', true),
            MEDIUM_LAST('}', false),
            LARGE_FIRST('[', true),
            LARGE_LAST(']', false);

            Parenthesis(char value, boolean first) {
                this.value = value;
                this.first = first;
            }

            private final char value;
            private final boolean first;

            public char getValue() {
                return value;
            }

            public boolean isFirst() {
                return first;
            }

            private static final Map<Character, Parenthesis> findByType = Collections.unmodifiableMap(Stream.of(values())
                .collect(Collectors.toMap(Parenthesis::getValue, Function.identity())));

            public static Parenthesis typeOf(char value) {
                return Optional.ofNullable(findByType.get(value)).orElseThrow();
            }
        }
    }
}
