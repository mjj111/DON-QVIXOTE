package 정말_괜찮았던_문제들;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 물의_양_구하기 {
    static int[] Sender = {0,0,1,1,2,2};
    static int[] Receiver = {1,2,0,2,0,1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] now;
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        visited = new boolean[201][201];
        answer = new boolean[201];
        bfs();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.println(i + " ");
            }
        }
    }
    void bfs() {
        Deque<AB> deq = new LinkedList<>();
        deq.addLast(new AB(0,0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!deq.isEmpty()) {
            AB p = deq.removeFirst();
            int A = p.a;
            int B = p.b;
            int C = now[2] - A - B;
            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};
                next[Receiver[i]] += next[Sender[i]];
                next[Sender[i]] = 0;
                if (next[Receiver[i]] > now[Receiver[i]]) {
                    next[Sender[i]] = next[Receiver[i]] - now[Receiver[i]];
                    next[Receiver[i]] = now[Receiver[i]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    deq.addLast(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
    class AB {
        private int a;
        private int b;

        AB(int a, int b) {
            this.a = a;
            this. b = b;
        }
    }
}
