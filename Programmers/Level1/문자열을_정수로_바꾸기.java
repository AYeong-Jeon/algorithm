package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12925

public class 문자열을_정수로_바꾸기 {
    public int solution(String s) {
        String number = "";

        if(s.contains("+") || s.contains("-")) {
            number = s.substring(1);
        } else {
            number = s;
        }
        int answer = Integer.parseInt(number);

        return s.startsWith("-") ? (answer*-1) : answer;
    }

    public int betterSolution(String s) {
        //바보같이,, 똑똑한 자바는 부호도 인식한다 ㅠ
        return Integer.parseInt(s);
    }
}
