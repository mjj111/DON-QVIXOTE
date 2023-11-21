package 그래프_탐색;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 효율적으로_해킹하기 {
    static int N,M;
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[N+1];
        answer = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[start].add(end);
        }

        for (int i = 1; i < N+1; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }

        int maxValue = 0;
        for (int i = 1; i < N+1; i++) {
            maxValue = Math.max(maxValue, answer[i]);
        }

        for (int i = 1; i < N+1; i++) {
            if (answer[i] == maxValue) {
                System.out.print(i + " ");
            }
        }
    }
    public static void bfs(int start) {
        Deque<Integer> deq = new LinkedList<>();
        deq.add(start);
        visited[start] = true;
        while (!deq.isEmpty()) {
            int now = deq.poll();

            for (int next : arr[now]) {
                if (visited[next] == false) {
                    visited[next] = true;
                    deq.add(next);
                    answer[next]++;
                }
            }
        }
    }
}
