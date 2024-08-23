package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12982

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int count = 0;
        Arrays.sort(d);

        for(int i=0 ; i<d.length ; i++) {
            budget -= d[i];
            if(budget<0) return count;
            count++;
        }

        return count;
    }
}
