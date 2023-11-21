package 그래프_탐색;


import java.util.*;

public class 트리의_지름구하기 {
    static ArrayList<Edge>[] arr;
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            while (true) {
                int end = sc.nextInt();
                if (end == -1) {
                    break;
                }
                int value = sc.nextInt();
                arr[start].add(new Edge(end,value));
            }
        }

        int[] visited = new int[N+1];

        bfs(1,visited);
        int max = 1;
        for (int i = 2; i < N+1; i++) {
            if (visited[i] > visited[max]) {
                max = i;
            }
        }

        visited = new int[N+1];
        bfs(max,visited);
        Arrays.sort(visited);
        System.out.println(visited[N+1]);
    }
    void bfs(int start, int[] visited) {
        Deque<Integer> deq = new LinkedList<>();
        deq.add(start);
        while (!deq.isEmpty()) {
            int nowNode = deq.removeFirst();
            for (Edge edge : arr[nowNode]) {
                int e = edge.edge;
                int v = edge.value;
                if (visited[e] == 0) {
                    visited[e] = visited[nowNode] + v;
                    deq.addLast(e);
                }
            }
        }

    }

    class Edge {
        private int edge;
        private int value;

        Edge(int edge, int value) {
            this.edge = edge;
            this.value = value;
        }
    }
}
