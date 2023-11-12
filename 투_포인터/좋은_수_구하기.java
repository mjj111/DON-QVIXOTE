package 투_포인터;

import java.io.*;
import java.util.*;

public class 좋은_수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        Arrays.sort(A);
        for (int k = 0; k < N; k++) {
            long target = A[k];
            int left = 0;
            int right = N-1;

            while(right > left) {
                int sumPoint = A[right] + A[left];
                if (sumPoint == target) {
                    if (left != k && right != k) {
                        result++;
                        break;
                    }
                }else if (left == k) {
                    left++;
                }else if (right == k) {
                    right++;
                }
            }
            System.out.println(result);
            br.close();
        }

    }
}
