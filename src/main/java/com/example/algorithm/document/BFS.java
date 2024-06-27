package com.example.algorithm.document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BFS implements ApplicationRunner {

    /*
        (A)---(B)---(C)
         |     |     |
        (D)---(E)---(F)

        여기서 각 정점은 알파벳으로 표시되어 있고, 간선은 정점 사이의 연결을 나타낸다. 이 그래프는 방향 없는 그래프이며, 각 정점에 대해 양방향으로 간선이 존재한다.

         A
        / \
       /   \
      D-----B
      |     |
      |     |
      E-----C
       \   /
         F

       위 그림에서 각 알파벳은 그래프의 정점을 나타내며, 각 선은 정점 사이의 간선을 표시한다.
       정점 A에서 정점 B로 간선이 있으며, 정점 D에서 정점 E로도 간선이 있다 ....
     */

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 정점의 개수를 지정하여 그래프 생성
        Graph graph = new Graph(6);

        // 간선 추가
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println("BFS 탐색 순서:");
        graph.BFS(0); // BFS 탐색 시작 정점을 지정
        System.out.println(); // 줄바꿈
    }

    static class Graph {

        private final int numVertices; // 정점의 개수
        private final List<List<Integer>> adjacencyList; // 인접 리스트

        // 그래프 초기화
        public Graph(int numVertices) {
            this.numVertices = numVertices;
            adjacencyList = new ArrayList<>(this.numVertices);
            for (int i = 0; i < this.numVertices; ++i) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        // 정점에 간선 추가
        public void addEdge(int fromVertex, int toVertex) {
            adjacencyList.get(fromVertex).add(toVertex);
            // 무방향 그래프이므로 양쪽에 추가
            adjacencyList.get(toVertex).add(fromVertex);
        }

        // BFS 탐색
        public void BFS(int startVertex) {
            // 방문 여부 체크를 위한 배열
            boolean[] visited = new boolean[numVertices];
            // 큐 생성
            Queue<Integer> queue = new LinkedList<>();
            // 시작 정점 방문 표시
            visited[startVertex] = true;
            // 큐에 시작 정점 추가
            queue.offer(startVertex);

            while (!queue.isEmpty()) {
                // 큐에서 정점을 하나 꺼내어 방문
                startVertex = queue.poll();
                // 방문한 정점 출력
                System.out.print(startVertex + " ");
                // 모든 인접 정점에 대해
                for (int neighbor : adjacencyList.get(startVertex)) {
                    // 방문하지 않은 정점이면
                    if (!visited[neighbor]) {
                        // 방문 표시 후
                        visited[neighbor] = true;
                        // 큐에 추가
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
}
