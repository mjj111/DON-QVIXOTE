package 투_포인터.슬라이딩_윈도우;

import java.util.*;
import java.io.*;

public class DNA_비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] checkArr = new int[4];
        int [] myArr = new int[4];
        int checkSecret = 0;

        char[] A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            Add(A[i], checkArr, myArr,checkSecret);
        }

        if (checkSecret == 4) {
            result++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i], checkArr, myArr, checkSecret);
            Remove(A[j], checkArr, myArr, checkSecret);

            if (checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void Remove(char c, int[] checkArr, int[] myArr, int checkSecret) {
        if (c =='A') {
            myArr[0]--;
            if (myArr[0] == checkArr[0]) {
                checkSecret--;
            }
        }

        if (c =='C') {
            myArr[1]--;
            if (myArr[1] == checkArr[1]) {
                checkSecret--;
            }
        }

        if (c =='G') {
            myArr[2]--;
            if (myArr[2] == checkArr[2]) {
                checkSecret--;
            }
        }

        if (c =='T') {
            myArr[3]--;
            if (myArr[3] == checkArr[3]) {
                checkSecret--;
            }
        }
    }

    private static void Add(char c, int[] checkArr, int[] myArr, int checkSecret) {
        if (c =='A') {
            myArr[0]++;
            if (myArr[0] == checkArr[0]) {
                checkSecret--;
            }
        }

        if (c =='C') {
            myArr[1]++;
            if (myArr[1] == checkArr[1]) {
                checkSecret--;
            }
        }

        if (c =='G') {
            myArr[2]++;
            if (myArr[2] == checkArr[2]) {
                checkSecret--;
            }
        }

        if (c =='T') {
            myArr[3]++;
            if (myArr[3] == checkArr[3]) {
                checkSecret--;
            }
        }
    }
}
