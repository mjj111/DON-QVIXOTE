package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 무인도여행 {
    class Solution {
        char[][] maps;
        int N;
        int M;
        boolean[][] visited;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        public int[] solution(String[] mapss) {
            N = mapss.length;
            M = mapss[0].length();
            visited = new boolean[N][M];

            maps = new char[N][M];
            for (int i = 0; i < N; i++) {
                maps[i] = mapss[i].toCharArray();
            }

            ArrayList<Integer> answer = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[i][j] != 'X' && visited[i][j] == false) {
                        answer.add(getFoodAmount(new Iland(i,j)));
                    }
                }
            }

            // 배열 전환
            int[] ans = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                ans[i] = answer.get(i);
            }
            if (answer.size() == 0) {
                int[] falseAns = new int[]{-1};
                return falseAns;
            }
            Arrays.sort(ans);
            return ans;
        }

        int getFoodAmount(Iland nowLand) {
            int nowX = nowLand.x;
            int nowY = nowLand.y;
            int food = maps[nowX][nowY] - '0';
            visited[nowX][nowY] = true;

            Queue<Iland> queue = new LinkedList<>();
            queue.offer(nowLand);

            while (!queue.isEmpty()) {
                Iland now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];

                    if (isInRange(nextX, nextY)) {
                        if (!visited[nextX][nextY] && maps[nextX][nextY] != 'X') {
                            visited[nextX][nextY] = true;
                            food += maps[nextX][nextY] - '0';
                            queue.offer(new Iland(nextX,nextY));
                        }
                    }
                }
            }
            return food;
        }

        boolean isInRange(int x, int y) {
            if ( 0 <= x && x < N) {
                if ( 0 <= y && y < M) {
                    return true;
                }
            }
            return false;
        }


        class Iland {
            int x;
            int y;

            Iland(int x, int y) {
                this.x = x;
                this.y= y;
            }
        }
    }
}
