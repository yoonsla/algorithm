package com.example.algorithm.programmers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 입국심사 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 28
        int n = 6;
        int[] times = {7, 10};

        // 24
        int n2 = 5;
        int[] times2 = {8, 10};

        Solution solution = new Solution();
        long result = solution.solution(n, times);
        System.out.println("result : " + result);

    }

    static class Solution {
        // FIXME : 실패
        public long solution(int n, int[] times) {
            long count = 0L;
            long anotherCount = 0L;
            int lastTime = 0;
            long anotherTime = 0L;
            while (n - times.length > 0) {
                for (int time : times) {
                    if (lastTime == 0) {
                        lastTime = time;
                    }
                    if (lastTime > time) {
                        lastTime = time;
                    }
                    if (time != lastTime) {
                        anotherTime = time;
                    }
                }
                n -= times.length;
                count += lastTime;
                anotherCount += anotherTime;
            }
            long sumLastTime = count + lastTime;
            return Math.min(sumLastTime + lastTime, anotherCount + anotherTime);
        }


        public long solution2(int n, int[] times) {

            long start = 1L;
            long end = Long.MAX_VALUE;
            while (start <= end) {
                long middle = (start + end) / 2;
                long count = 0L;
                for (int time : times) {
                    count += (middle / time);
                }
                if (n <= count) {
                    end = middle - 1;
                } else {
                    start = middle + 1;

                }
            }
            return start;
        }
    }
}
