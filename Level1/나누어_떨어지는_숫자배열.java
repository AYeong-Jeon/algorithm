package Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12910

import java.util.Arrays;

public class 나누어_떨어지는_숫자배열 {
    public static void main(String[] args) {
        int[] a = solution(new int[]{5,9,7,10}, 5);
    }
    public static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(n -> n%divisor == 0).toArray();
        if (answer.length == 0) answer = new int[]{-1};
        Arrays.sort(answer);

        return answer;
    }

    // stream 으로 푸는 것보다 그냥 for문 돌리는게 500배 정도 더 빠름
    public static int[] solution2(int[] arr, int divisor) {
        int[] answer = {};
        int cnt = 0;

        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i]%divisor==0) cnt++;
        }

        if(cnt==0) return answer = new int[]{-1};

        answer = new int[cnt];
        int index = 0;
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i]%divisor==0) {
                answer[index++] = arr[i];
            }
        }
        Arrays.sort(answer);

        return answer;
    }


}
