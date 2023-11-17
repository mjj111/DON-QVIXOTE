package 스택;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 카드게임 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deq = new LinkedList<>();
        int N = sc.nextInt();

        for (int i = 1; i < N+1; i++) {
            deq.addFirst(i);
        }
        while (deq.size() > 1) {
            deq.removeLast();
            deq.addFirst(deq.removeLast());
        }
        System.out.println(deq.removeLast());
    }
}
