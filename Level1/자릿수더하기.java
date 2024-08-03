package Level1;

import java.util.LinkedList;

//https://school.programmers.co.kr/learn/courses/30/lessons/12931

public class 자릿수더하기 {
	public int solution(int n) {
		int answer = 0;
		if (n>9) {
			String s = String.valueOf(n);
			for (int i = 0; i < s.toCharArray().length; i++) {
				answer += Integer.parseInt(String.valueOf(s.charAt(i)));
			}
		} else {
			answer = n;
		}

		return answer;
	}

	public int solution2(int n) {
		int answer = 0;

		while (n != 0) {
			answer += n % 10;
			if (n < 10) break;

			n = n / 10;
		}

		return answer;
	}

}