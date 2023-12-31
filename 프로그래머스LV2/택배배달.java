package 프로그래머스LV2;

public class 택배배달 {
     /**
     맨 끝 집부터 접근한다.
     현재 가져갈 상자와 택배 수를 추가해준다.
     먄약 현재의 상자와 택배수가 0을 초과된다면 해당 인덱스에 접근해야한다는 의미다.
     왕복을 하게되니, (i+1)*2 만큼 움직인다.
     **/
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            int N = deliveries.length;

            int delivery = 0;
            int pickup = 0;
            for (int i = N-1; i >= 0; i--) {
                delivery += deliveries[i];
                pickup += pickups[i];

                while (delivery > 0 || pickup > 0) {
                    delivery -= cap;
                    pickup -= cap;
                    answer += (i+1) *2;
                }
            }
            return answer;
        }
    }
}
