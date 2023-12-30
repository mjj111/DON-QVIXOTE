package 프로그래머스LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {
    class Solution {
        int N;
        int M;
        public int solution(String[] boards) {
            N = boards.length; // 행
            M = boards[0].length(); // 열

            boolean[][] visited = new boolean[N][M];
            char[][] board = new char[N][M];


            //char[][] board 초기화
            for (int i = 0; i < N; i++) {
                board[i] = boards[i].toCharArray();
            }

            Node startNode = null;
            Node goalNode = null;

            // 출발지, 목적지 발견
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 'R') {
                        startNode = new Node(i,j,0);
                    }
                    if (board[i][j] == 'G') {
                        goalNode = new Node(i,j,0);
                    }
                }
            }

            return bfs(board, startNode, goalNode, visited);

        }

        class Node {
            int x;
            int y;
            int depth;

            Node(int x, int y, int depth) {
                this.x = x;
                this.y = y;
                this.depth = depth;
            }
        }

        private int bfs(char[][] board, Node startNode, Node goalNode, boolean[][] visited) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(startNode);

            visited[startNode.x][startNode.y] = true;
            int[] dx = {0,0,1,-1};
            int[] dy = {-1, 1,0,0};
            while (!queue.isEmpty()) {
                Node nowNode = queue.poll();

                if (nowNode.x == goalNode.x && nowNode.y == goalNode.y) {
                    return nowNode.depth;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = nowNode.x;
                    int nextY = nowNode.y;

                    // 범위를 벗어나거나 장애물을 만날 때 까지 반복
                    while (inRange(nextX, nextY) && board[nextX][nextY] != 'D') {
                        nextX += dx[i];
                        nextY += dy[i];
                    }

                    // 범위를 벗어나거나 장애물 만나기 '직전'의 상태
                    nextX -= dx[i];
                    nextY -= dy[i];

                    // 방문을 하거나 같은 위치일 경우 스킵
                    if (visited[nextX][nextY] || (nowNode.x == nextX && nowNode.y == nextY)) continue;

                    visited[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, nowNode.depth + 1));
                }
            }

            return -1;
        }

        boolean inRange(int x, int y) {
            return x >= 0 && y >= 0 && x < N && y < M;
        }

    }
}