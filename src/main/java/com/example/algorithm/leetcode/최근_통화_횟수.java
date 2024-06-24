package com.example.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 최근_통화_횟수 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        RecentCounter recentCounter = new RecentCounter();
        int ping1 = recentCounter.ping(1);// requests = [1], range is [-2999,1], return 1
        int ping2 = recentCounter.ping(100);// requests = [1, 100], range is [-2900,100], return 2
        int ping3 = recentCounter.ping(3001);// requests = [1, 100, 3001], range is [1,3001], return 3
        int ping4 = recentCounter.ping(3002);// requests = [1, 100, 3001, 3002], range is [2,3002], return 3
        System.out.println(ping4);
    }

    static class RecentCounter {

        private final Deque<Integer> time;

        public RecentCounter() {
            this.time = new LinkedList<>();
        }

        public int ping(int t) {
            this.time.addLast(t);
            while (this.time.getFirst() < t - 3000) {
                this.time.removeFirst();
            }
            return this.time.size();
        }
    }
}
