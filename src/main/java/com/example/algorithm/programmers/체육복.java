package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 체육복 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 5
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        // 4
        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};

        // 2
        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        Solution solution = new Solution();
        int result = solution.solution(n3, lost3, reserve3);
        System.out.println("result : " + result);
    }

    class Solution {

        public int solution(int member, int[] lostArray, int[] reserveArray) {

            Arrays.sort(reserveArray);
            Set<Integer> set = Arrays.stream(lostArray).boxed().collect(Collectors.toSet());

            for (int i = 0; i < reserveArray.length; i++) {
                if (set.contains(reserveArray[i])) {
                    set.remove(reserveArray[i]);
                    reserveArray[i] = -1;
                }
            }

            for (int reserve : reserveArray) {
                if (set.contains(reserve - 1)) {
                    set.remove(reserve - 1);
                } else {
                    set.remove(reserve + 1);
                }
            }
            return member - set.size();
        }
    }
}
