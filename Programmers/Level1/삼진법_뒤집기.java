package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/68935

public class 삼진법_뒤집기 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n!=0) {
            sb.append(n%3);
            n/=3;
        }

        return Integer.parseInt(String.valueOf(sb), 3);
    }
}
