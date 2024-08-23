package Programmers.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/147355

public class 크기가_작은_부분_문자열 {
    public int solution(String t, String p) {
        int count = 0;
        for (int i=0 ; i<=(t.length()-p.length()) ; i++) {
            if(Long.parseLong(t.substring(i,p.length()+i))<=Long.parseLong(p)) count++;
        }

        return count;
    }
}
