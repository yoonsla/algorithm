package com.example.algorithm.leetcode;

import java.util.PriorityQueue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 좌석_예약_관리자 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
        <Input>
        ["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
        [[5], [], [], [2], [], [], [], [], [5]]

        <Output>
        [null, 1, 2, null, 2, 3, 4, 5, null]
         */

        SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
        int reserve1 = seatManager.reserve();// All seats are available, so return the lowest numbered seat, which is 1.
        int reserve2 = seatManager.reserve();// The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        int reserve3 = seatManager.reserve();// The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        int reserve4 = seatManager.reserve();// The available seats are [3,4,5], so return the lowest of them, which is 3.
        int reserve5 = seatManager.reserve();// The available seats are [4,5], so return the lowest of them, which is 4.
        int reserve6 = seatManager.reserve();// The only available seat is seat 5, so return 5.
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].

        System.out.println(reserve6);
    }

    static class SeatManager {

        private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                priorityQueue.add(i);
            }
        }

        public int reserve() {
            Integer min = this.priorityQueue.peek();
            priorityQueue.poll();
            return min;
        }

        public void unreserve(int seatNumber) {
            this.priorityQueue.add(seatNumber);
        }
    }
}
