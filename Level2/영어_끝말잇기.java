package Level2;

//https://school.programmers.co.kr/learn/courses/30/lessons/12981

import java.util.LinkedList;
import java.util.List;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        int[] a = solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int count = 1;
        int a=0, b=0;
        boolean isDrop = false;

        List<String> wordList = new LinkedList<>();
        wordList.add(words[0]);
        for (int i=1 ; i<words.length ; i++) {
            char c = new StringBuilder().append(wordList.get(i-1)).reverse().charAt(0);
            count++;
            if (words[i].startsWith(String.valueOf(c)) && !wordList.contains(words[i])) {
                wordList.add(words[i]);
            } else {
                isDrop = true;
                break;
            }
        }

        if(isDrop) {
            a = count % n;
            b = (count / n) + 1;
            if(b==0) b = a;
        }
        answer[0] = a;
        answer[1] = b;

        return answer;
    }
}
