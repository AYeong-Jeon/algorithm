package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12928

public class 약수의_합 {
    public static void main(String[] args) {
        int a = solution(16);
    }
    public static int solution(int n) {
        int sum = 0;
        int sqrt = (int) Math.sqrt(n);

        for (int i=1; i<=sqrt; i++) {
            if (n%i == 0) {
                sum += i + (n/i);
                if (i == (n/i)) sum -= i;
            }
        }

        return sum;
    }
}
