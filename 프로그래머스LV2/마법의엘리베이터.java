package 프로그래머스LV2;


public class 마법의엘리베이터 {
    class Solution {
        public int solution(int storeyy) {
            int answer = 0;
            String storey = String.valueOf(storeyy);
            int N = storey.length();
            int[] intStorey = new int[N];
            for (int i = 0; i < N; i++) {
                intStorey[i] = storey.charAt(i) - '0';
            }


            for (int i = N-1; i >0; i--) {
                if (intStorey[i] > 5 && intStorey[i] != 10) { // 6,7,8,9
                    answer += (10 - intStorey[i]);
                    intStorey[i-1] += 1;
                }
                else if (intStorey[i] == 5) {
                    answer += intStorey[i];
                    if (intStorey[i -1] + 1 > 5) {
                        intStorey[i -1]+=1;
                    }
                }

                else if (intStorey[i] == 10) { // 10
                    intStorey[i-1] += 1;
                }

                else { // 0,1,2,3,4
                    answer += intStorey[i];
                }
            }


            // 만약 가장 큰 수가 6,7,8,9라면
            if (intStorey[0] > 5 && intStorey[0] != 10) {
                answer += 10 - intStorey[0] + 1;
            }
            else if (intStorey[0] == 10) { //만약 10이라면
                answer += 1;
            }

            else { //만약 0,1,2,3,4,5라면
                answer += intStorey[0];
            }
            return answer;
        }
    }
}
