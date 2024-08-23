package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12903

public class 가운데_글자_가져오기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = s.length()/2;

        if(s.length()%2==0) {
            sb.append(s.charAt(index-1)).append(s.charAt(index));
        } else {
            sb.append(s.charAt(index));
        }

        return sb.toString();
    }

    //조금 더 빠르고 간결하게 바꿔봄
    public String solution2(String s) {
        int index = s.length() / 2;
        return (s.length() % 2 == 0) ? s.substring(index-1,index+1) : s.substring(index, index+1);
    }

}
