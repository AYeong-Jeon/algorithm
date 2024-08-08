package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12947

public class 하샤드_수 {
    public static void main(String[] args) {
        boolean a =  solution(13);
    }
    public static boolean solution(int x) {
        int a=0, b=x;

        while(x>0) {
            a += x%10;
            x = x/10;
        }

        return b%a==0;
    }
}
