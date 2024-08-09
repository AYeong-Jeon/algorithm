package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12912

public class 두_정수_사이의_합 {
    public static void main(String[] args) {
        long a = solution(5,3);
    }

    public static long solution(int a, int b) {
        long answer = 0;
        for(int i = (Math.min(a, b)) ; i <= (Math.max(a, b)) ; i++) {
            answer += i;
        }

        return answer;
    }


    /* 등차수열의 합 공식을 사용한 풀이 */
    public long solution2(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }
    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }

}
