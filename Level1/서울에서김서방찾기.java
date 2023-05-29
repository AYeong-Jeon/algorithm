package Level1;

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
	
	/*
	내 코드 문제점
	1. asList가 생각이 안나서 배열 index 찾는거 검색해봄,,
	
	==================================다른 사람 풀이 보고 고치기 (다른 방법으로 푼 사람 코드!)
	1. .equals를 사용해서 비교할 때는 null이 들어올 수 있는 seoul[i] 값보다 "Kim"으로 비교해주는 것이 좋다.
	만약 null 값으로 .equals를 비교하게되면 널포인트 익셉션이 날 수 있다.
	* */
	public String solution2(String[] seoul) {
		String answer = "";
		int x =  0;

		for(int i=0; i<seoul.length; i++){
			if("Kim".equals(seoul[i])) {
				x = i ;
			}
		}
		answer = "김서방은 "+ x + "에 있다";

		return answer;
	}
}
