package 유니온_파인드;

import java.util.Scanner;

public class 집합_표현하기 {
    public static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int qeustion = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (qeustion == 0) {
                union(a, b);
            }
            else {
                if (checkSame(a, b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if( a != b) {
            parent[b] = a;
        }
    }

    public static int find(int now) {
        if (now == parent[now]) {
            return now;
        }
        parent[now] = find(parent[now]); // 중요
        return parent[now];
    }

    public static boolean checkSame(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        return aParent == bParent;
    }
}
