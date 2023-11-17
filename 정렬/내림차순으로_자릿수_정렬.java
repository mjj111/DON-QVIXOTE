package 정렬;

import java.util.Scanner;

public class 내림차순으로_자릿수_정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int[] A =new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            A[i] = Integer.parseInt(N.substring(i,i+1));
        }

        for (int i = 0; i < N.length(); i++) {
            int max = 1;
            for (int j = i+1; j < N.length(); i++) {
                if (A[j] > A[max]) {
                    max = j;
                }
            }
            if (A[i] < A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }
        for (int i = 0; i< N.length(); i++) {
            System.out.println(A[i]);
        }
    }
}
