package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12944

import java.util.Arrays;

public class 평균_구하기 {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }
}
