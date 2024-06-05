package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 구명보트 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        int limit = 100;
        int[] people1 = {70, 50, 80, 50};   // 3
        int[] people2 = {70, 50, 80};       // 3
        int[] people3 = {50, 40};           // 1

        Solution solution = new Solution();
        int result = solution.solution3(people1, limit);
        System.out.println(result);

    }

    class Solution {

        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            int count = 0;
            int min = 0;
            for (int max = people.length - 1; max >= min; max--) {
                final int maxPerson = people[max];
                final int minPerson = people[min];
                if (people.length == 1) {
                    count++;
                    break;
                }
                if (maxPerson + minPerson <= limit) {
                    min++;
                }
                count++;
            }
            return count;
        }

        public int solution2(int[] people, int limit) {

            Integer[] peopleArray = Arrays.stream(people).boxed().toArray(Integer[]::new);
            Arrays.sort(peopleArray, Comparator.reverseOrder());

            if (peopleArray.length == 1) {
                return 1;
            }
            int count = 0;
            int min = peopleArray.length - 1;
            for (int max = 0; max <= min; max++) {
                if (peopleArray[max] + peopleArray[min] <= limit) {
                    min--;
                }
                count++;
            }
            return count;
        }

        public int solution3(int[] people, int limit) {

            Integer[] passengers = Arrays.stream(people).boxed().toArray(Integer[]::new);
            Deque<Integer> deque = new LinkedList<>(Arrays.asList(passengers));

            int answer = 0;
            while (deque.size() > 1) {
                Integer first = deque.peekFirst();
                Integer last = deque.pollLast();
                if (first + last <= limit) {
                    deque.pollFirst();
                }
                answer++;
            }
            return answer;
        }
    }
}
