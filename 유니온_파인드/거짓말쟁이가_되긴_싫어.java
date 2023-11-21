package 유니온_파인드;

import java.util.ArrayList;
import java.util.Scanner;

public class 거짓말쟁이가_되긴_싫어 {
    public static int[] parent;
    public static int[] truePeople;
    public static ArrayList<Integer>[] party;
    public static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        result = 0;
        truePeople = new int[T];
        for (int i = 0; i < T; i++) {
            truePeople[i] = sc.nextInt();
        }

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            int partSize = sc.nextInt();
            for (int j = 0; j < partSize; j++) {
                party[i].add(sc.nextInt());
            }
        }

        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int now = party[i].get(0);

            for (int j = 0; j < truePeople.length; j++) {
                if (find(now) == find(truePeople[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                result += 1;
            }
        }
        System.out.println(result);
    }

    static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent != bParent) {
            parent[bParent] = aParent;
        }
    }
    static int find(int now) {
        if (parent[now] == now) {
            return now;
        }
        parent[now] = find(parent[now]);
        return parent[now];
    }
}
