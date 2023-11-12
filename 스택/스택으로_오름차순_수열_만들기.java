package 스택;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 스택으로_오름차순_수열_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i  = 0; i< N; i++) {
            A[i] = sc.nextInt();
        }

        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int num = 1;
        boolean result = true;

        for (int i = 0; i < A.length; i++) {
            int su = A[i];
            if (su >= num) {
                while (su >= num) {
                    dq.push(num++);
                    sb.append("+\n");
                }
                dq.pop();
                sb.append("-\n");
            }
            else {
                int n = dq.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    sb.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(sb);
        }
    }
}
