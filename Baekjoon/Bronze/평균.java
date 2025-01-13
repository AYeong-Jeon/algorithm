package Baekjoon.Bronze;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1546

public class 평균 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        long sum=0, maxNum=0;
        for(int i=0 ; i<num ; i++) {
            int score = sc.nextInt();
            if(score>maxNum) maxNum=score;
            sum += score;

        }

        System.out.println(sum*100.0/maxNum/num);
    }

}
