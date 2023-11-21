package 위상_정렬;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 줄_세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int before = sc.nextInt();
            int after = sc.nextInt();
            arr[before].add(after);
            inDegree[after]++;
        }

        Deque<Integer> deq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                deq.addLast(i);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!deq.isEmpty()) {
            int now = deq.removeFirst();
            result.append(now).append(" ");
            for (int next : arr[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    deq.addLast(next);
                }
            }
        }

        System.out.println(result.toString().trim());
    }
}

