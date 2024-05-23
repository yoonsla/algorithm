package com.example.algorithm.programmers;

import java.util.Stack;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 같은_숫자는_싫어 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 1,3,0,1
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        // 4, 3
        int[] arr2 = {4, 4, 4, 3, 3};
        int[] answer = answer(arr);
    }

    private int[] answer(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int number : numbers) {
            if (stack.isEmpty()) {
                stack.push(number);
            }
            if (!stack.peek().equals(number)) {
                stack.push(number);
            }
        }
        return stack.stream()
            .mapToInt(v -> v)
            .toArray();
    }
}
