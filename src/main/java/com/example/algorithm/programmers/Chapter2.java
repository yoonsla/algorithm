package com.example.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

// 완주하지 못한 선수
//@Component
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
    }

    private String answer1(String[] participants, String[] completions) {
        // 참가자 정렬
        Arrays.sort(participants);
        // 완주자 정렬
        Arrays.sort(completions);
        int i;
        for (i = 0; i <= completions.length; i++) {
            if (i == completions.length) {
                return participants[i];
            }
            if (!participants[i].equals(completions[i])) {
                return participants[i];
            }
        }
        return participants[i];
    }

    private String answer2(String[] participants, String[] completions) {

        Map<String, Integer> userMap = new HashMap<>();
        for (String participant : participants) {
            userMap.put(participant, userMap.getOrDefault(participant, 0) + 1);
        }
        for (String completion : completions) {
            int value = userMap.get(completion) - 1;
            if (value == 0) {
                userMap.remove(completion);
            } else {
                userMap.put(completion, value);
            }
        }
        return userMap.keySet().iterator().next();
    }
}
