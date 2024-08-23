package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/70128

import java.util.stream.IntStream;

public class 내적 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }

    public int solution2(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }

}
