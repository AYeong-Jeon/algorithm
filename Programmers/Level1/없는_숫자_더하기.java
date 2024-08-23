package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/86051

import java.util.stream.IntStream;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        int a = solution(new int[]{5,8,4,0,6,7,9});
    }
    public static int solution(int[] numbers) {
        int answer = IntStream.rangeClosed(0,9).sum();  //작은 숫자이니까 계산해서 45로 적는게 훨씬 빠름.
        for (int num : numbers) {
            answer -= num;
        }

        return answer;
    }
}
