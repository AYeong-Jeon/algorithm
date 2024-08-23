package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12954

public class X만큼_간격이_있는_N개의_숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for(int i=1 ; i<n ; i++) {
            answer[i] = answer[i-1]+x;
        }

        return answer;
    }
}
