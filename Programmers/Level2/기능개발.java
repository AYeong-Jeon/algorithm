package Programmers.Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();  //결과를 반환할 int형을 담는 ArrayList answer 선언
        Queue<Integer> queue = new LinkedList<Integer>();   // progresses의 각 인덱스 값이 100을 넘는 최소일수


        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));  //progresses 각 인덱스 값이 100을 넘기 위한 최소일수 계산 후 queue에 add 메소드로 넣기
        }

        while (!queue.isEmpty()) {
            int minDays = queue.poll();
            //해당 일자에 배포되는 총 기능의 수를 담기 위한 변수
            int count = 1;

            //queue.peek()의 값이 그 전에 poll()을 통해 얻은 값, 즉 minDays 보다 작은 동안
            while (!queue.isEmpty() && queue.peek() <= minDays) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }

        return answer;
    }
}
