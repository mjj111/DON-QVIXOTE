package 그래프_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 친구_관계_파악하기 {
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];
        visited = new boolean[N];
        arrive = false;

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    static void dfs(int start, int depth) {
        if (depth == N-1 || arrive) {
            arrive = true;
            return;
        }

        visited[start] = true;

        for (int next : arr[start]) {
            if (!visited[next]) {
                dfs(next,depth+1);
            }
        }

        visited[start] = false;
    }
}
