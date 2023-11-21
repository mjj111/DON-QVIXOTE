package 유니온_파인드;

import java.util.Scanner;

public class 여행_계획_짜기 {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] city = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                city[i][j] = sc.nextInt();
            }
        }

        int[] route = new int[N+1];
        for (int i = 1; i < M+1; i++) {
            route[i] = sc.nextInt();
        }

        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (city[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int index = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent != bParent) {
            parent[bParent] = aParent;
        }
    }

    static int find(int now) {
        if (parent[now] == now) {
            return now;
        }
        parent[now] = find(parent[now]);
        return parent[now];
    }
}
