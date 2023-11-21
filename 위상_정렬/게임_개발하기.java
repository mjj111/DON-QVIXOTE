package 위상_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 게임_개발하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] afterWorks = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            afterWorks[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N+1];
        int[] buildTime = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int preWork = Integer.parseInt(st.nextToken());
                if (preWork == -1) {
                    break;
                }
                afterWorks[preWork].add(i);
                inDegree[i]++;
            }
        }

        Deque<Integer> deq = new LinkedList<>();

        for (int i = 1; i < N+1; i++) {
            if (inDegree[i] == 0) {
                deq.addLast(i);
            }
        }

        int[] result = new int[N+1];
        while (!deq.isEmpty()) {
            int now = deq.removeLast();
            for (int next : afterWorks[now]) {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[now] + buildTime[now]);
                if (inDegree[next] == 0) {
                    deq.addLast(next);
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            System.out.println(result[i] + buildTime[i]);
        }
    }
}
