package Programmers.Level1;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/176963

public class 추억점수 {
	public int[] solution1(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];
		Map<String, Integer> score = new HashMap<>();

		for(int i=0; i<name.length; i++){
			if(i < yearning.length){
				score.put(name[i], yearning[i]);
			}else{
				score.put(name[i], 0);
			}
		}

		for(int i=0; i<photo.length; i++){
			int num=0;
			for(int j=0; j<photo[i].length; j++){
				num += score.getOrDefault(photo[i][j], 0);
			}
			answer[i] = num;
		}

		return answer;
	}

	/* 내 코드의 문제점
	1. int[] 배열을 선언하지 않음.
	2. .get()으로 가져오기만 하고 default 값을 지정해주지 않아서 널포인트익셉션 남.


	-------------------다른 사람 코드 보고 고친 부분----------------------*/
	public int[] solution2(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];

		for(int i=0 ; i<photo.length ; i++) {
			for(int j=0 ; j<photo[i].length ; j++) {
				if(Arrays.asList(name).indexOf(photo[i][j]) != -1) {
					answer[i] += yearning[Arrays.asList(name).indexOf(photo[i][j])];
				}
			}
		}

		return answer;
	}
}
