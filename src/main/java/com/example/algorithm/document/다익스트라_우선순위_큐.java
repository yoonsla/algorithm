package com.example.algorithm.document;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 다익스트라_우선순위_큐 implements ApplicationRunner {

    /*

        A -- 1 -- B -- 3 -- C
        |         |         |
        4         2         5
        |         |         |
        D -- 6 -- E -- 1 -- F

        1. 초기화:
            - 출발점 A의 거리를 0으로 설정하고, 나머지 정점의 거리를 무한대로 설정한다.
            - distances = {
                A: 0,
                B: infinity,
                C: infinity,
                D: infinity,
                E: infinity,
                F: infinity
            }
            - 우선순위 큐를 초기화하고, A를 거리 0으로 큐에 추가한다.
            - priorityQueue = [(A, 0)]

       2. 첫 번째 반복:
            - 큐에서 A를 추출한다.
            - A의 인접 정점 B와 D의 거리를 갱신하고, 큐에 추가한다.
                B의 새로운 거리 = 1, 큐에 추가
                D의 새로운 거리 = 4, 큐에 추가
            - distances = {
                A: 0,
                B: 1,
                C: infinity,
                D: 4,
                E: infinity,
                F: infinity
            }
            - priorityQueue = [(B, 1), (D, 4)]

        3. 두 번째 반복:
            - 큐에서 B를 추출한다.
            - B의 인접 정점 C와 E의 거리를 갱신하고, 큐에 추가한다.
                C의 새로운 거리 = 4, 큐에 추가
                E의 새로운 거리 = 3, 큐에 추가
            - distances = {
                A: 0,
                B: 1,
                C: 4,
                D: 4,
                E: 3,
                F: infinity
            }
            - priorityQueue = [(E, 3), (D, 4), (C, 4)]

        4. 세 번째 반복:
            - 큐에서 E를 추출한다.
            - E의 인접 정점 D와 F의 거리를 갱신하고, 큐에 추가한다.
                D의 새로운 거리 = 9 (갱신하지 않음, 기존 4가 더 짧음)
                F의 새로운 거리 = 4, 큐에 추가
            - distances = {
                A: 0,
                B: 1,
                C: 4,
                D: 4,
                E: 3,
                F: 4
            }
            - priorityQueue = [(D, 4), (C, 4), (F, 4)]

        5. 네 번째 반복:
            - 큐에서 D를 추출한다.
            - D의 인접 정점 E의 거리를 갱신하지 않는다. (이미 최단 거리 갱신됨).
            - distances = {
                A: 0,
                B: 1,
                C: 4,
                D: 4,
                E: 3,
                F: 4
            }
            - priorityQueue = [(C, 4), (F, 4)]

        6. 다섯 번째 반복:
            - 큐에서 C를 추출한다.
            - C의 인접 정점 F의 거리를 갱신하지 않는다. (이미 최단 거리 갱신됨).
            - distances = {
                A: 0,
                B: 1,
                C: 4,
                D: 4,
                E: 3,
                F: 4
            }
            - priorityQueue = [(F, 4)]

        7. 여섯 번째 반복:
            - 큐에서 F를 추출한다.
            - F는 이미 최단 거리 갱신된 상태이다.
            - distances = {
                A: 0,
                B: 1,
                C: 4,
                D: 4,
                E: 3,
                F: 4
            }
            - priorityQueue = []
     */

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 그래프 초기화
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<>());
        graph.get("A").put("B", 1);
        graph.get("A").put("D", 4);

        graph.put("B", new HashMap<>());
        graph.get("B").put("A", 1);
        graph.get("B").put("C", 3);
        graph.get("B").put("E", 2);

        graph.put("C", new HashMap<>());
        graph.get("C").put("B", 3);
        graph.get("C").put("F", 5);

        graph.put("D", new HashMap<>());
        graph.get("D").put("A", 4);
        graph.get("D").put("E", 6);

        graph.put("E", new HashMap<>());
        graph.get("E").put("B", 2);
        graph.get("E").put("D", 6);
        graph.get("E").put("F", 1);

        graph.put("F", new HashMap<>());
        graph.get("F").put("C", 5);
        graph.get("F").put("E", 1);

        // 시작점 설정
        String startVertex = "A";
        Map<String, Integer> distances = dijkstra(graph, startVertex);

        // 결과 출력
        System.out.println("최단 거리 (우선순위 큐): " + distances);
    }

    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        // 최단 거리 저장용 맵 및 시작점 초기화
        Map<String, Integer> distances = new HashMap<>();
        for (String vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // 우선순위 큐 초기화
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        priorityQueue.add(new Node(start, 0));

        // 우선순위 큐가 비어있지 않은 동안 반복
        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            String currentVertex = currentNode.vertex;

            // 현재 정점의 인접한 정점들의 거리 갱신
            for (Map.Entry<String, Integer> neighborEntry : graph.get(currentVertex).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
                int distance = currentNode.distance + weight;

                // 더 짧은 경로 발견 시 거리 갱신 및 우선순위 큐에 추가
                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    priorityQueue.add(new Node(neighbor, distance));
                }
            }
        }
        return distances;
    }

    // 우선순위 큐 사용을 위한 Node 정의
    record Node(String vertex, int distance) {

    }
}
