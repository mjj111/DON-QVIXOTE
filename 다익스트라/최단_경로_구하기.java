package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단_경로_구하기 {
    public static void main(String[] args) throws IOException {
        int V, E, K;
        int[] distance;
        boolean[] visited;
        ArrayList<Edge>[] graph;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(s -> s.value));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        graph = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        pq.offer(new Edge(K, 0));
        distance[K] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;
            for (Edge next : graph[now.vertex]) {
                if (distance[next.vertex] > distance[now.vertex] + next.value) {
                    distance[next.vertex] = next.value + distance[now.vertex];
                    pq.offer(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }
        for (int i = 1; i < V+1; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            }
            else {
                System.out.println("INF");
            }
        }
    }
    static class Edge {
        int vertex;
        int value;

        Edge(int vertex, int value) {
            this.value = value;
            this.vertex = vertex;
        }
    }
}
