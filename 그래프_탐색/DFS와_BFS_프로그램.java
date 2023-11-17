package 그래프_탐색;

import java.util.*;

public class DFS와_BFS_프로그램 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int START = sc.nextInt();
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr[s].add(e);
            arr[e].add(s);
        }
        // 번호가 작은 것부터 탐색하도록 정렬한다.
        for (int i = 1; i < N +1; i++) {
            Collections.sort(arr[i]);
        }

        dfs(START);
        System.out.println();

        visited = new boolean[N+1];
        bfs(START);
        System.out.println();
    }
    static void dfs(int now) {
        System.out.print(now + " ");
        visited[now] = true;
        for (int i : arr[now]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        System.out.println();
    }

    static void bfs(int start) {
        Deque<Integer> deq = new LinkedList<>();
        deq.addLast(start);
        visited[start] = true;

        while(!deq.isEmpty()) {
            int now = deq.removeFirst();
            System.out.println(now + " ");

            for (int next : arr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    deq.addLast(next);
                }
            }

        }
    }
}
