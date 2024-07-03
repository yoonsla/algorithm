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

    // 우선순위 큐 사용을 위한 Node 클래스 정의
    static class Node {

        String vertex;
        int distance;

        Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
