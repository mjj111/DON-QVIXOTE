package 프로그래머스LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    /**
     bfs
     start로 부터 시작해서 움직이는데,
     만약 O 라면 갈 수 있다. X 라면 갈 수 없다. L을 찍고 E를 찍어야한다.
     L찍고, E를 찍는 최소 depth를 반환한다.
     L에 먼저 최소 접근 depth를 구한다. 구하지 못했다면 -1
     L에서 부터 E로 최소 접근 depth를 구한다. 구하지 못했다면 -1
     **/
    class Solution {

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int N;
        int M;
        char[][] maps;
        public int solution(String[] mapss) {
            N = mapss.length;
            M = mapss[0].length();
            maps = new char[N][M];

            // maps 초기화
            for (int i = 0; i < N; i++) {
                maps[i] = mapss[i].toCharArray();
            }

            Node startNode = null;
            Node endNode = null;
            Node leberNode = null;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[i][j] == 'S') {
                        startNode = new Node('S',i,j);
                    }

                    if (maps[i][j] == 'L') {
                        leberNode = new Node('L',i,j);
                    }

                    if (maps[i][j] == 'E') {
                        endNode = new Node('E',i,j);
                    }
                }
            }

            return getMinMumAccessWithBfs(startNode, endNode, leberNode);
        }

        private int getMinMumAccessWithBfs(Node startNode, Node endNode, Node leberNode) {
            // StartNode에서 LeverNode 찾기
            int findedLeberDepth = findNode(startNode, leberNode);
            if (findedLeberDepth == -1) return -1;
            leberNode.depth = findedLeberDepth;

            //LeberNode에서 EndNode 찾기
            int findedEndDepth = findNode(leberNode, endNode);
            return findedEndDepth;
        }

        private int findNode(Node startNode, Node destinationNode) {
            boolean[][] visited = new boolean[N][M];
            Queue<Node> queue = new LinkedList<>();

            queue.offer(startNode);
            visited[startNode.x][startNode.y] = true;

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];

                    if (isInRange(nextX, nextY)) {
                        if (maps[nextX][nextY] == destinationNode.name) return now.depth + 1;

                        if (maps[nextX][nextY] != 'X' && visited[nextX][nextY] == false) {
                            visited[nextX][nextY] = true;
                            queue.offer(new Node('_',nextX, nextY, now.depth + 1));
                        }
                    }
                }
            }
            return -1;
        }
        private boolean isInRange(int x, int y) {
            if ( 0 <= x && x < N) {
                if ( 0 <= y && y < M) {
                    return true;
                }
            }
            return false;
        }

        class Node {
            char name;
            int x;
            int y;
            int depth = 0;

            Node(char name, int x, int y) {
                this.name = name;
                this.x = x;
                this.y = y;
            }

            Node(char name, int x, int y, int depth) {
                this.name = name;
                this.x = x;
                this.y = y;
                this.depth = depth;
            }
        }
    }
}
