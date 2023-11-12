package 구간_합;

import java.util.Scanner;

public class 숫자의_합_구하기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(char c : cNum){
            System.out.println(c);
            sum += c - '0';
        }
        System.out.println(sum);
    }
}
