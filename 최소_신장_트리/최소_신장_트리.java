package 최소_신장_트리;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소_신장_트리 {
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        pq = new PriorityQueue<>(Comparator.comparing(s -> s.value));
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            pq.offer(new Edge(start, end, value));
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge < N-1) {
            Edge now = pq.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result = result + now.value;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent != bParent) {
            parent[bParent] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);

        return parent[a];
    }

    static class Edge {
        int start;
        int end;
        int value;
        Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}
