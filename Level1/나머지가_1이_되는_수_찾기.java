package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/87389

import java.util.stream.IntStream;

//https://school.programmers.co.kr/learn/courses/30/lessons/87389?language=java

public class 나머지가_1이_되는_수_찾기 {
    public int solution(int n) {
        int answer = 1;
        for (int i=2 ; i<n ; i++) {
            if (n % i == 1) {
                return i;
            }
        }

        return answer;
    }

    /* intstream 공부해보기 */
    public int solution2(int n) {
        return IntStream.range(2, n).filter(i -> n % i == 1).findFirst().orElse(0);
    }

}
