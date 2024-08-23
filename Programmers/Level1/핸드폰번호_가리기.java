package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12948

public class 핸드폰번호_가리기 {
    public static void main(String[] args) {
        String a = solution("2341");
    }
    public static String solution(String phone_number) {
        StringBuilder number = new StringBuilder();
        for (int i=0 ; i<phone_number.length()-4 ; i++) {
            number.append("*");
        }

        return number.append(phone_number, phone_number.length()-4, phone_number.length()).toString();
    }
}