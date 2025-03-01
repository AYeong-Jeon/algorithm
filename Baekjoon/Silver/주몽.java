package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1940 - 투포인터 문제

public class 주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int materialNum = Integer.parseInt(br.readLine());
        int totalNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] materialArr = new int[materialNum];
        for(int i=0; i<materialNum; i++) {
            materialArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(materialArr);

        int i = 0;
        int j = materialNum-1;
        int result = 0;
        while(i < j) {
            int sum = materialArr[i] + materialArr[j];
            if(sum < totalNum) {
                i++;
            } else if(sum > totalNum) {
                j--;
            } else {
                i++;
                j--;
                result++;
            }
        }
        System.out.println(result);

    }
}
