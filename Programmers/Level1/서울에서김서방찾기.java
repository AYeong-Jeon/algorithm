package Programmers.Level1;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12919

public class 서울에서김서방찾기 {
	public String solution1(String[] seoul) {
		String answer = "";
		int index = Arrays.asList(seoul).indexOf("Kim");

		if(index != -1) {
			answer = "김서방은 " + index + "에 있다";
		}

		return answer;
	}
	
	/* SpringBuilder를 사용하면 String을 사용하는 것보다 훨씬 빠름. */
	public String solution2(String[] seoul) {
		int index = Arrays.asList(seoul).indexOf("Kim");

		return String.valueOf(new StringBuilder("김서방은 ").append(index).append("에 있다"));
	}
}
