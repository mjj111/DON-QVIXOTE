package 프로그래머스LV2;

import java.util.Stack;

public class 뒤에있는큰수찾기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int N = numbers.length;
            int[] answer = new int[N];
            Stack<Integer> indexs = new Stack<>();

            for (int i = 0; i < N; i++) {
                if (indexs.isEmpty()) {
                    indexs.push(i);
                }
                while (!indexs.isEmpty() && (numbers[i] > numbers[indexs.peek()])) {
                    answer[indexs.pop()] = numbers[i];
                }
                indexs.push(i);
            }

            if (!indexs.isEmpty()) {
                for (int i : indexs) {
                    answer[i] = -1;
                }
            }

            return answer;
        }
    }
}
