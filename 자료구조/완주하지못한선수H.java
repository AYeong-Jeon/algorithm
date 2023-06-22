package 자료구조;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/42576

public class 완주하지못한선수H {
	public String solution1(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> ht = new HashMap<>();

		for (String par : participant) {
			ht.put(par, ht.getOrDefault(par, 0)+1);
		}
		for (String com : completion) {
			ht.put(com, ht.get(com)-1);
		}

		for (Map.Entry<String, Integer> e : ht.entrySet()) {
			if (e.getValue() != 0) {
				answer = e.getKey();
			}
		}
		return answer;
	}

	/*
	*  HashMap의 getOrDefault 메소드는 찾는 key가 존재하면 값을 리턴하고, 없으면 디폴트 값이 리턴된다.
	* */

	public String solution2(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hashMap = new HashMap<>();

		for (String p : participant) {
			hashMap.put(p, hashMap.getOrDefault(p, 0)+1);
		}
		for (String c : completion) {
			hashMap.put(c, hashMap.get(c)-1);
		}

		for(String key : hashMap.keySet()) {
			if (hashMap.get(key) != 0) {
				 answer = key;
			}
		}

		return answer;
	}
}
