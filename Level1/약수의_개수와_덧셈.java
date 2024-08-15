package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/77884

import java.util.HashSet;
import java.util.stream.IntStream;

public class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        int a=solution(13,17);
    }
    public static int solution(int left, int right) {
        int answer = 0;

        for (int i=left ; i<right+1 ; i++) {
            HashSet<Integer> numSet = new HashSet<>();
            int finalI = i;
            IntStream.rangeClosed(1, i).filter(num -> finalI%num ==0).forEach(j -> numSet.add(j));
            int count = numSet.size();

            if (count%2==0) {
               answer += i;
            } else {
                answer -= i;
            }
        }


        return answer;
    }

    public static int solution2(int left, int right) {
        int answer = 0;

        for(int i=left ; i<right+1 ; i++) {
            if(i%Math.sqrt(i)==0) {   //제곱수인 경우 약수의 개수가 홀수
                answer -= i;
            } else {  //제곱수가 아닌 경우 약수의 개수가 짝수
                answer += i;
            }
        }

        return answer;
    }

}
