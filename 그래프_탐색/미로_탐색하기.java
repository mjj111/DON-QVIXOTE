package 그래프_탐색;

import java.util.Scanner;

public class 미로_탐색하기 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[][] graph = new int[N][M];
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        int[] start = {0,0};
        visited[0][0] = 1;
        dfs(start, visited,graph);
        System.out.println(visited[N-1][M-1]);
    }
    static void dfs(int[] start, int[][] visited, int[][] graph) {
        int nowX = start[0];
        int nowY = start[1];

        for (int i = 0; i < 4; i++) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];

            if (nextX < N && nextX >= 0 && nextY < M && nextY >= 0) {
                if (visited[nextX][nextY] == 0 && graph[nextX][nextY] == 1) {
                    visited[nextX][nextY] = visited[nowX][nowY] + 1;
                    dfs(new int[]{nextX, nextY}, visited, graph);
                }
            }
        }
    }
}
