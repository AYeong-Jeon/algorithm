package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12916?language=java

public class 문자열내_p와y의_개수 {
    boolean solution(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            String alpa = String.valueOf(s.charAt(i));
            if(alpa.equalsIgnoreCase("p")){
                a++;
            } else if(alpa.equalsIgnoreCase("y")){
                a--;
            }
        }

        return a==0;
    }

    //좋은 답
    boolean solutionAnswer(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }

    boolean repeatAnswer(String s) {
        s = s.toLowerCase();

        return s.chars().filter(e -> 'p'==e).count() == s.chars().filter(e -> 'y'==e).count();
    }
    
}