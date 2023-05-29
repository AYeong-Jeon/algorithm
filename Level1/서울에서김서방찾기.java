package Level1;

import java.util.Arrays;

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
	* */
	public String solution2(String[] seoul) {
		String answer = "";
		int x =  0;

		for(int i=0; i<seoul.length; i++){
			if(seoul[i].equals("Kim")) {
				x = i ;
			}
		}
		answer = "김서방은 "+ x + "에 있다";

		return answer;
	}
}
