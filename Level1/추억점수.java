package Level1;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/176963

public class 추억점수 {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = {};
		Map<String, Integer> map = new HashMap<>();

		for(int i=0; i<name.length; i++){
			if(i < yearning.length){
				map.put(name[i], yearning[i]);
			}else{
				map.put(name[i], 0);
			}
		}

		for(int i=0; i<photo.length; i++){
			int num=0;
			for(int j=0; j<photo[i].length; j++){
				num += map.get(photo[i][j]);
			}
			answer[i] = num;
		}

		return answer;
	}
}
