package 투_포인터.슬라이딩_윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값_찾기 {
    // A [i-L +1] ~ A[i] 중에 가장 작은 최소값들을 출력
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().value > now) {
                dq.removeLast();
            }

            dq.addLast(new Node(now, i));

            if (dq.getFirst().index <= i -L) {
                dq.removeFirst();
            }

            System.out.print(dq.getFirst().value + " ");
        }
    }
    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
