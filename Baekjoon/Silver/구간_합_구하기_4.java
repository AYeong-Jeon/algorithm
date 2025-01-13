package Baekjoon.Silver;

import java.util.Scanner;

//https://www.acmicpc.net/problem/11659

public class 구간_합_구하기_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] oArray = new int[5];
        int[] nArray = new int[5];
        int sum = 0;
        for(int i=0 ; i<a ; i++) {
            int c = sc.nextInt();
            oArray[i] = c;
            nArray[i] = sum+c;
            sum = c;
        }

        for(int i=0 ; i<b ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int num = oArray[end-1] + nArray[end];
            num -= nArray[start+1];
            System.out.println(num);
        }

    }
}
