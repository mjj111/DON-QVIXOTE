package 프로그래머스LV2;

import java.util.Arrays;

public class 시소짝꿍 {
    class Solution {
        int N;
        int[] weights;
        public long solution(int[] w) {
            long answer = 0;
            weights = w;
            N = weights.length;
            Arrays.sort(weights);
            int prev  =0 ;
            for(int i = 0; i < N-1; i++){
                if(i > 0 && weights[i] == weights[i-1]){
                    prev--;
                    answer+=prev;
                    continue;
                }
                int j = findRignt(weights[i], i+1);
                prev = 0;
                for(; j > i ;j --){
                    if(weights[i] == weights[j] ||weights[i] * 2== weights[j] ||
                            weights[i] * 3 == weights[j] * 2 || weights[i] * 4 == weights[j] * 3){
                        prev++;
                    }
                }
                answer+=prev;
            }
            return answer;
        }
        public int findRignt(int num, int i){
            int left = i;
            int right = N-1;
            while(left < right){
                int mid = left +(right-left)/2;
                if(weights[mid] > num*2)return mid;
                else left = mid+1;
            }
            return left;
        }
    }
}
