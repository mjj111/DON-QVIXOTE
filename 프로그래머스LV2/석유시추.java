package 프로그래머스LV2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 석유시추 {
    /**BFS를 통해 자원에 대한 개수를 초기화 한다.
     resourceSequnce 대로 하나씩 값을 주어야한다.
     열에 따라 접근된 resourceSequnce의 값은 Set으로 담아 총합을 저장한다.
     총합 중에 가장 큰 값을 출력한다.
     **/

    class Solution {
        int[] dx = {0, 1, -1, 0};
        int[] dy = {-1, 0, 0, 1};
        int landRow;
        int landColumn;
        HashMap<Integer, Integer> resource = new HashMap<>();

        public int solution(int[][] land) {
            int answer = 0;
            int resourceSequnce = 3;
            landRow = land.length;
            landColumn = land[0].length;

            for (int i = 0; i < landRow; i++) {
                for (int j = 0; j < landColumn; j++) {
                    int now = land[i][j];

                    if (now == 1) {
                        int amount = getResourceAmount(i, j, resourceSequnce, land);
                        resource.put(resourceSequnce, amount);
                        resourceSequnce += 1;
                    }
                }
            }

            HashSet<Integer> resourceCodes = new HashSet<>();
            for (int j = 0; j < landColumn; j++) {
                for (int i = 0; i < landRow; i++) {
                    if (land[i][j] != 0) {
                        resourceCodes.add(land[i][j]);
                    }
                }

                int tmpSum = 0;
                for (int code : resourceCodes) {
                    tmpSum += resource.get(code);
                }

                if (answer < tmpSum) {
                    answer = tmpSum;
                }

                resourceCodes.clear();
            }

            return answer;
        }

        int getResourceAmount(int x, int y, int resourceSequnce, int[][] land) {
            Queue<Location> q = new LinkedList<>();
            q.offer(new Location(x,y));
            int amount = 0;
            land[x][y] = resourceSequnce;

            while (!q.isEmpty()) {
                Location now = q.poll();
                amount += 1;

                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];

                    if (isInRange(nextX, nextY)){
                        if (land[nextX][nextY] == 1) {
                            land[nextX][nextY] = resourceSequnce;
                            q.offer(new Location(nextX, nextY));
                        }
                    }
                }
            }
            return amount;
        }

        class Location {
            int x;
            int y;

            Location (int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        boolean isInRange (int x, int y) {
            if (x > -1 && x < landRow) {
                if (y > -1 && y < landColumn) {
                    return true;
                }
            }
            return false;
        }
    }
}
