package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12934

public class 정수_제곱근_판별 {
    public static void main(String[] args) {
        long a =solution(3);
    }

    public static long solution(long n) {
        int x = (int) Math.sqrt(n);
        return Math.pow(x, 2)==n ? (long) Math.pow(x+1, 2) : -1;
    }

}
