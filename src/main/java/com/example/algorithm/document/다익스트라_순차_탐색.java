package com.example.algorithm.document;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 다익스트라_순차_탐색 implements ApplicationRunner {

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
        System.out.println("최단 거리 (순차 탐색): " + distances);

    }

    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        // 최단 거리 저장용 맵 및 시작점 초기화
        Map<String, Integer> distances = new HashMap<>();
        for (String vertex : graph.keySet()) {
            // 초기에는 Integer.MAX_VALUE로 설정
            distances.put(vertex, Integer.MAX_VALUE);
        }
        // 시작 정점의 거리를 0으로 설정
        distances.put(start, 0);

        // 방문한 정점 저장
        Set<String> visited = new HashSet<>();

        // 모든 정점을 방문할 때까지 반복
        while (visited.size() != graph.size()) {
            // 방문하지 않은 정점 중 최단 거리를 가진 정점을 선택
            String currentVertex = getMinDistanceVertex(distances, visited);
            visited.add(currentVertex);

            // 현재 정점의 인접한 정점들의 거리 갱신
            for (Map.Entry<String, Integer> neighborEntry : graph.get(currentVertex).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();

                // 방문하지 않은 정점의 거리를 갱신
                if (!visited.contains(neighbor)) {
                    int newDist = distances.get(currentVertex) + weight;
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                    }
                }
            }
        }
        return distances;
    }

    // 방문하지 않은 정점 중 최단 거리를 가진 정점을 선택하는 함수
    private static String getMinDistanceVertex(Map<String, Integer> distances, Set<String> visited) {
        int minDistance = Integer.MAX_VALUE;
        String minVertex = null;
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            String vertex = entry.getKey();
            int distance = entry.getValue();

            if (!visited.contains(vertex) && distance < minDistance) {
                minDistance = distance;
                minVertex = vertex;
            }
        }
        return minVertex;
    }
}
