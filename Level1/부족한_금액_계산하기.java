package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/82612

public class 부족한_금액_계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i=1 ; i<=count ; i++) {
            answer += price*i;
        }

        return answer-money<0 ? 0 : answer-money;
    }

    //등차수열의 합을 사용한 풀이
    public long solution2(int price, int money, int count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }

}
