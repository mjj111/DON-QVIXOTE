package 프로그래머스LV2;

import java.util.Arrays;

public class 호텔대실 {
    /**
     이분탐색 사용
     book_item의 크기에 따라 접근하도록 한다.
     반환된 최소 크기의 result 반환
     class 시작시간, 끝나는 시간 + 10 계산

     방의 개수만큼 int[] 를 만들어준다.
     book_time을 시작시간 기준으로 정렬한다.
     book_time 만큼 순차접근한다.
     room에 순차적으로 접근하여 시작시간과 비교해 만약 가능하다면,
     끝나는시간 + 10으로 변경해준다.
     만약 가능한 방이 없다면 -1을 반환한다.
     book_time 을 모두 접근했다면 1을 반환한다.
     **/
    class Solution {
        int N;
        public int solution(String[][] book_time) {
            int answer = 0;
            N = book_time.length;

            Reservation[] reservations = new Reservation[N];
            for (int i = 0; i < N; i++) {
                reservations[i] = new Reservation(book_time[i][0], book_time[i][1]);
            }
            Arrays.sort(reservations);

            int result = Integer.MAX_VALUE;
            int start = 1;
            int end = N;
            while (start <= end) {
                int mid = (start + end) / 2;
                boolean possible = isPossibleRoomAmount(mid, reservations);
                System.out.println(mid);
                System.out.println(possible);
                if (possible) {
                    end = mid - 1;
                    if (mid < result) result = mid;
                }
                else {
                    start = mid + 1;
                }
            }

            return result;
        }

        boolean isPossibleRoomAmount(int roomAmount, Reservation[] reservations) {
            int[] rooms = new int[roomAmount];
            for (Reservation r : reservations) {
                boolean isReserved = false;
                for (int i = 0; i < roomAmount; i ++) {
                    if (rooms[i] <= r.startTime) {
                        rooms[i] = r.endTime;
                        isReserved = true;
                        break;
                    }
                }
                if (!isReserved) return false;
            }
            return true;
        }

        class Reservation implements Comparable<Reservation> {
            int startTime;
            int endTime;

            Reservation (String startTime, String endTime) {
                this.startTime = getNumberTime(startTime);
                this.endTime = getNumberTime(endTime) + 10;
            }

            private int getNumberTime(String time) {
                String[] parsed = time.split(":");
                return (Integer.parseInt(parsed[0]) * 60) + (Integer.parseInt(parsed[1]));
            }

            @Override
            public int compareTo (Reservation r) {
                return this.startTime - r.startTime;
            }
        }
    }
}
