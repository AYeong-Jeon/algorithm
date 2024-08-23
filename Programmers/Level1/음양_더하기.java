package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/76501

public class 음양_더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0 ; i<absolutes.length ; i++) {
            if(!signs[i]) absolutes[i] *= -1;
            answer += absolutes[i];
        }

        return answer;
    }
}
