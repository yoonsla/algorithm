package com.example.algorithm.programmers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 조이스틱 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String name = "JEROEN"; // 56
        String name2 = "JAN";   // 23
        String name3 = "JAAVAVV";
        String test = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Solution solution = new Solution();
        int result = solution.solution(name);
        System.out.println("result : " + result);
    }

    class Solution {

        // 정확한 쓰레기
        public int solution(String name) {
            int upDown = 0;
            int move = name.length() - 1;
            for (int i = 0; i < name.length(); i++) {
                upDown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
                int a = i + 1;
                while (a < name.length()) {
                    if (name.charAt(a) != 'A') {
                        break;
                    }
                    a++;
                }
                move = Math.min(move, name.length() - a + i);
            }
            System.out.println("upDown : " + upDown);
            System.out.println("move: " + move);
            return upDown + move;
        }
    }
}
