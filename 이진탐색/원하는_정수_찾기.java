package 이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 원하는_정수_찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();

            int start = 0;
            int end = arr.length-1;

            while (start <= end) {
                int mid = (start+end) / 2;
                int midValue = arr[mid];

                if (midValue > target) {
                    end = mid -1;
                    continue;
                }
                if (midValue < target) {
                    start = mid + 1;
                    continue;
                }

                find = true;
                break;
            }
            if (find) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
