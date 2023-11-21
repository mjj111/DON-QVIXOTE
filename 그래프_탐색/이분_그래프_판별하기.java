package 그래프_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class 이분_그래프_판별하기 {
    static ArrayList<Integer>[] arr;
    static int[] check;
    static boolean visited[];
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int time = 0; time < N; time++ ) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(br.readLine());
            int E = Integer.parseInt(br.readLine());
            arr = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            isEven = true;
            for (int i = 1; i < V+1; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                arr[start].add(end);
                arr[end].add(start);
            }

            for (int i = 1; i < V+1; i++) {
                if (isEven) {
                    dfs(i);
                }
                else{
                    break;
                }
            }
            check[1] = 0;
            if (isEven) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
    public static void dfs(int now) {
        visited[now] = true;
        for (int next : arr[now]) {
            if (!visited[next]) {
                check[next] = (check[next] + 1) % 2;
                dfs(next);
            }
            else if (check[next] == check[now]) {
                isEven = false;
            }
        }
    }
}