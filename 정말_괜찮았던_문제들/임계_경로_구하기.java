package 정말_괜찮았던_문제들;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 임계_경로_구하기 {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<City>[] cityMap = new ArrayList[N+1];
        ArrayList<City>[] reverseCityMap = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            reverseCityMap[i] = new ArrayList();
            cityMap[i] = new ArrayList();
        }

        int[] inDegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            cityMap[start].add(new City(end,value));
            reverseCityMap[end].add(new City(start,value));
            inDegree[end]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        Deque<Integer> deq = new LinkedList<>();
        deq.addLast(startCity);
        int[] result = new int[N+1];

        while (!deq.isEmpty()) {
            int now = deq.removeLast();
            for (City next : cityMap[now]) {
                inDegree[next.targetCity]--;
                result[next.targetCity] = Math.max(result[next.targetCity], result[now] + next.value);

                if (inDegree[next.targetCity] == 0) {
                    deq.addLast(next.targetCity);
                }
            }
        }

        int resultCount = 0;
        boolean[] visited = new boolean[N+1];
        deq = new LinkedList<>();
        deq.addLast(endCity);
        visited[endCity] = true;

        while (!deq.isEmpty()) {
            int now = deq.removeLast();
            for (City next : cityMap[now]) {
                if (result[next.targetCity] + next.value == result[now]) {
                    resultCount++;
                    if (visited[next.targetCity] == false) {
                        deq.addLast(next.targetCity);
                    }
                }
            }
        }
        System.out.println(result[endCity]);
        System.out.println(resultCount);

    }
    class City {
        int targetCity;
        int value;

        City(int targetCity, int value) {
            this.targetCity = targetCity;
            this.value = value;
        }
    }
}
