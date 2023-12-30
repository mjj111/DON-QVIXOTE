package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Collections;

public class 광물캐기 {
    /**
     미네랄에서 각 순서대로 5개씩 묶어서 스톤일 시, 다이아몬드일 시, 강철일 시에 따른 값들을 만든다.(만약 5가 되지 않을 수도 있다.)
     묶음 중 곡갱이의 개수 * 5 만큼만 접근한다.
     5개의 스톤일 시, 다이아몬드일 시, 강철일 시에 따른 값들을 만든다.(스톤일 시에 대한 값으로 오름차순 정렬한다.)
     스톤 개수, 강철 개수, 다이아몬드 개수 만큼 값을 곱해서 리턴한다.
     **/
    class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;

            int pickSum = 0;
            for (int i : picks) {
                pickSum += i;
            }

            ArrayList<String> fiveMineral = new ArrayList<>();
            ArrayList<Mineral>fiveMinerals = new ArrayList<>();
            int idx = 0;

            while (pickSum != 0 && idx < minerals.length) {
                if (fiveMineral.size() == 5) {
                    fiveMinerals.add(new Mineral(fiveMineral));
                    fiveMineral = new ArrayList<>();
                    pickSum -= 1;
                }

                fiveMineral.add(minerals[idx]);
                idx += 1;

                if (pickSum != 0 && idx >= minerals.length) {
                    fiveMinerals.add(new Mineral(fiveMineral));
                }
            }


            Collections.sort(fiveMinerals);
            for (Mineral mi : fiveMinerals) {
                if (picks[0] > 0) {
                    answer += mi.getDiamonHomiPrice();
                    picks[0] -= 1;
                }

                else if (picks[1] > 0) {
                    answer += mi.getIronHomiPrice();
                    picks[1] -= 1;
                }

                else if (picks[2] > 0) {
                    answer += mi.price;
                    picks[1] -= 1;
                }
            }

            return answer;
        }
        class Mineral implements Comparable<Mineral> {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            int price = 0;

            public int getIronHomiPrice() {
                return diamond*5 + iron + stone;
            }

            public int getDiamonHomiPrice() {
                return diamond + iron + stone;
            }

            Mineral (ArrayList<String> arr) {
                for (String a: arr) {
                    if (a.equals("diamond")) {
                        diamond += 1;
                    }
                    if (a.equals("iron")) {
                        iron += 1;
                    }
                    if (a.equals("stone")) {
                        stone += 1;
                    }
                }

                price += (stone);
                price += (iron * 5);
                price += (diamond * 25);
            }

            @Override
            public int compareTo(Mineral o2) {
                return o2.price - this.price;
            }
        }
    }
}
