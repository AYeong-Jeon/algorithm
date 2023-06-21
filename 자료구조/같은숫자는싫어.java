package 자료구조;

//https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자는싫어 {

	public int[] solution1(int []arr) {
		Queue<Integer> q = new LinkedList<>();

		q.add(arr[0]);
		for(int i=1 ; i<arr.length-1 ; i++) {
			if(q.peek() != arr[i]) {
				q.add(arr[i]);
			}
		}

		int[] result = new int[q.size()];
		for(int i=0; i<result.length-1; i++) {
			result[i] = q.peek();
			q.poll();
		}

		return result;
	}
	/*
	문제점 : q.peek()으로 계속 가장 첫번째 수랑 arr[i] 숫자를 비교하니까 애초에 q에 올바른 값이 들어가지 않음.
	해결법 : 먼저 q에 arr 값을 모두 넣은 다음 q[0]와 arr[1] 값을 비교해서 add해준다. 그리고 앞의 값을 모두 poll 하고 int형 배열에 담아서 반환해준다.
	 */

	public int[] solution2(int []arr) {
		Queue<Integer> q = new LinkedList<>();

		for(int i : arr) {
			q.add(i);
		}
		q.add(arr[0]);
		for(int i=1 ; i<arr.length ; i++) {
			if(q.peek() != arr[i]) {
				q.add(arr[i]);
			}
			q.poll();
		}

		q.poll();
		int[] result = new int[q.size()];
		for(int i=0 ; i<result.length ; i++) {
			result[i] = q.peek();
			q.poll();
		}

		return result;
	}

}
