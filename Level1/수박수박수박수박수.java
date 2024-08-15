package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12922

public class 수박수박수박수박수 {
    public static void main(String[] args) {
        String c = solution(3);
    }
    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for(int i=0 ; i<n ; i++) {
             answer.append(i%2==0 ? "박" : "수");
        }

        return answer.toString();
    }
}
