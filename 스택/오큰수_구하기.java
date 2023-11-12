package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 오큰수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(0);
        for (int i = 0; i < N; i++) {
            while(!dq.isEmpty() && A[dq.getLast()] < A[i]){
                ans[dq.removeLast()] = A[i];
            }
            dq.addLast(i);
        }

        while(!dq.isEmpty()) {
            ans[dq.removeLast()] = -1;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
