package com.example.algorithm.programmers;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// TODO
@Component
public class 더_맵게 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
        -- 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2) --

        스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
        새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
        가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

        스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
        새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
        가진 음식의 스코빌 지수 = [13, 9, 10, 12]

        모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
         */

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        Solution solution = new Solution();
        solution.solution(scoville, k);
    }

    class Solution {

        public int solution(int[] scoville, int K) {
            int answer = 0;
            return answer;
        }
    }
}
