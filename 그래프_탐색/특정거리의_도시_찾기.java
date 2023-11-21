package 그래프_탐색;

import java.util.*;

public class 특정거리의_도시_찾기 {

    static int[] visited;
    static ArrayList<Integer>[] arr;
    static int N,M,K,X;
    static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        arr = new ArrayList[N];
        answer = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[start].add(end);
        }

        visited = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            visited[i] = -1;
        }
        bfs(X);

        for (int i = 0; i < N+1; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);
            for (int ans : answer) {
                System.out.println(ans);
            }
        }
    }
    static void bfs(int start) {
        Deque<Integer> deq = new LinkedList<>();
        deq.addLast(start);
        visited[start] += 1;
        while (!deq.isEmpty()) {
            int now = deq.removeFirst();
            for (int next : arr[now]) {
                if (visited[next] == -1) {
                    visited[next] = visited[now] + 1;
                    deq.add(next);
                }
            }
        }
    }
}
