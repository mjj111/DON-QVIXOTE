package 프로그래머스LV2;

import java.util.Arrays;

public class 숫자변환하기 {
    class Solution {
        int[] dp;
        public int solution(int x, int y, int n) {
            int answer = 0;
            // x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return
            dp = new int[y+1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            dp[x] = 0;
            for(int i=x; i<=y; i++){
                if(dp[i]==Integer.MAX_VALUE) continue;
                if(i+n<=y){
                    dp[i+n] = Math.min(dp[i+n], dp[i]+1);
                }
                if(i*2<=y){
                    dp[i*2] = Math.min(dp[i*2], dp[i]+1);
                }
                if(i*3<=y){
                    dp[i*3] = Math.min(dp[i*3], dp[i]+1);
                }
            }

            if(dp[y]==Integer.MAX_VALUE) return -1;
            return dp[y];
        }
    }
}
