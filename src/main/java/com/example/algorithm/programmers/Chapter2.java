package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// 완주하지 못한 선수
@Component
public class Chapter2 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] participants = {"leo", "kiki", "eden"};
        String[] completions = {"eden", "kiki"};

        String[] participants2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completions2 = {"josipa", "filipa", "marina", "nikola"};

        String[] participants3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completions3 = {"stanko", "ana", "mislav"};

        String extracted = answer2(participants2, completions2);
        System.out.println(extracted);
    }

    private String answer1(String[] participants, String[] completions) {
        // 참가자 정렬
        Arrays.sort(participants);
        // 완주자 정렬
        Arrays.sort(completions);
        int i;
        for (i = 0; i <= completions.length; i++) {
            // 참가자가 완주자 보다 많기 때문에 완주자 만큼 돌았으면 정렬한 마지막 인원
            if (i == completions.length) {
                return participants[i];
            }
            // 참가자와 완주자가 다른 인원
            if (!participants[i].equals(completions[i])) {
                return participants[i];
            }
        }
        // 정렬한 마지막 인원
        return participants[i];
    }

    private String answer2(String[] participants, String[] completions) {

        Map<String, Integer> userMap = new HashMap<>();
        for (String participant : participants) {
            // 참가한 인원 userMap 에 추가
            userMap.put(participant, userMap.getOrDefault(participant, 0) + 1);
        }
        for (String completion : completions) {
            // 완주한 인원은 userMap 에서 제거
            int value = userMap.get(completion) - 1;
            if (value == 0) {
                userMap.remove(completion);
            } else {
                userMap.put(completion, value);
            }
        }
        // 완주한 인원 key 값 제거
        return userMap.keySet().iterator().next();
    }
}
