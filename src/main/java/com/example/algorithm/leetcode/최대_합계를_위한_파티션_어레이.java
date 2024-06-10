package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 최대_합계를_위한_파티션_어레이 implements ApplicationRunner {

    // 84
    int [] arr = {1,15,7,9,2,5,10};
    int k = 3;

    // 83
    int [] arr2 = {1,4,1,5,7,3,6,1,9,9,3};
    int k2 = 4;

    // 1
    int [] arr3 = {1};
    int k3 = 1;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Solution solution = new Solution();
        int result = solution.maxSumAfterPartitioning(arr, k);
        System.out.println("result: " + result);

    }

    // FIXME : 실패
    static class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {

            int[] dpArray = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int max = arr[i];
                for (int j = 0; j < k; j++) {
                    max = Math.max(max, arr[j]);
                }
            }
            return 0;
        }
    }
}
