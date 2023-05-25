package Level1;

import java.util.LinkedList;

//https://school.programmers.co.kr/learn/courses/30/lessons/12931


public class 자릿수더하기 {
	public int solution1(int num) {
		int sum = 0;
		LinkedList<Integer> numList = new LinkedList<>();

		while (num > 0) {
			int a = num % 10;
			num /= 10;
			numList.add(a);
		}

		for(int i=0 ; i<numList.size() ; i++) {
			sum += numList.get(i);
		}

		return sum;
	}

	/* 내 코드의 문제점
	1. 처음에 num /= 10; 이 부분을 빼먹어서 계속 타임아웃이 떴다.
	num 값은 바꿔주지 않아서 그대로인데 생각을 못했다..!
	2. 왜 굳이 굳이 LinkedList를 썼을까..!

	*===================고친 부분
	* */
	public int solution2(int num) {
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		return sum;
	}
}