package 투_포인터;

import java.util.Scanner;

public class 연속된_자연수의_합_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        while (endIndex != N) {
            if (sum == N) {
                count++;
                endIndex++;
                sum = sum + endIndex;
            } else if (sum > N) {
                sum = sum - startIndex;
                startIndex++;
            }
        }
        System.out.println(count);
    }
}
