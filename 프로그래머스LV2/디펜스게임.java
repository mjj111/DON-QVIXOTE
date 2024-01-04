package 프로그래머스LV2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = enemy.length;
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            int my = n;
            int card = k;
            for (int i = 0; i < enemy.length; i++) {
                my -= enemy[i];
                pq.add(enemy[i]);

                if (my < 0) {
                    if (card > 0) {
                        my += pq.poll();
                        card--;
                    } else {
                        return i;
                    }
                }
            }

            return answer;
        }
    }
}
