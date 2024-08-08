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
        int a=0, b=0;

        List<String> wordList = new LinkedList<>();
        wordList.add(words[0]);
        for (int i=1 ; i<words.length ; i++) {
            char c = new StringBuilder().append(wordList.get(i-1)).reverse().charAt(0);
            if (testChar(words[i], c) || wordList.contains(words[i])) {
                a = i%n + 1;  //탈락한 사람의 번호
                b = i/n + 1;  //몇 번째에서 탈락했는지
                break;  //탈락했을 경우 반복문 종료
            }
            wordList.add(words[i]);  //조건을 만족했을 경우 리스트에 추가
        }
        answer[0] = a;
        answer[1] = b;

        return answer;
    }

    public static boolean testChar(String word, char c) {
        if(word.startsWith(String.valueOf(c))) {
            return false;
        }

        return true;
    }

}
