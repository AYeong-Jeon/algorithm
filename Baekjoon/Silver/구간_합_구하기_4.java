package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11659

public class 구간_합_구하기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // a+1 로 생성하는 이유는 1부터 3까지의 합을 구할 때 0번째가 0이어야하기 때문
        long[] nArray = new long[a+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=a ; i++) {
            nArray[i] = nArray[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<b ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            long num = nArray[end] - nArray[start-1];
            System.out.println(num);
        }
    }

}

/* 구간합을 구하는 법 : 합 배열 s[] 생성 후 s[end] - s[start-1]
*  만약 a 배열 [5, 4, 3, 2, 1]이 주어지면 합 배열 aSum [0, 5, 9, 12, 14, 15] 생성
*  그리고 1, 3까지의 구간 합을 구하려면 aSum[3]-aSum[1-1] = 12로 구간합을 올바르게 구할 수 있다.
* */
