package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12935

import java.util.Arrays;

public class 제일_작은_수_제거 {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int cnt = 0;

        if(arr.length==1) return answer = new int[]{-1};

        int a = arr[0];
        for(int i=1 ; i<arr.length ; i++) {
            if(a>arr[i]) a = arr[i];
        }

        answer = new int[arr.length-1];
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i]!=a) answer[cnt++] = arr[i];
        }

        return answer;
    }

    // stream을 사용한 풀이 방법
    public int[] solution2(int[] arr) {
        if (arr.length <= 1) return new int[]{ -1 };
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

}
