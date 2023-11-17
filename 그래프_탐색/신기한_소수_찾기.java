package 그래프_탐색;

import java.util.Scanner;

public class 신기한_소수_찾기 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }
    static void dfs(int number, int numberIndex) {
        if (numberIndex == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(number * 10 +i)) {
                dfs(number * 10 + i, numberIndex + 1);
            }
        }
    }
    static boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return  false;
            }
        }
        return true;
    }
}
