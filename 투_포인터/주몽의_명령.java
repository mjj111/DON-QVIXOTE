package 투_포인터;

import java.io.*;
import java.util.*;

public class 주몽의_명령 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int left = 0;
        int right = N-1;

        while (right > left) {
            if (A[right] + A[left] < M) {
                left++;
            } else if (A[right] + A[left] > M) {
                right--;
            }else if (A[right] + A[left] == M) {
                count++;
                left++;
                right--;
            }
        }
        System.out.println(count);
    }
}
