package 자료구조;

import java.util.Stack;


//https://school.programmers.co.kr/learn/courses/30/lessons/12906

public class 같은숫자는싫어S {
	public int[] solution1(int []arr) {
		Stack<Integer> stack = new Stack<>();

		stack.push(arr[0]);
		for(int i=1 ; i<arr.length ; i++) {
			if(stack.peek() != arr[i]) {
				stack.push(arr[i]);
			}
		}

		int[] result = new int[stack.size()];
		for (int i=0 ; i<result.length ; i++) {
			result[i] = stack.peek();
			stack.pop();
		}

		return result;
	}

	/*
	문제점 : stack은 LIFO 이기 때문에 peek() 했을 때 가장 위의 값이 나오는데 마지막에 result 배열에 넣을때 0번째부터 넣어서 거꾸로 들어갔다.
	해결법 : result 배열에 담을 때 반대로 넣어준다.
	 */

	public int[] solution2(int []arr) {
		Stack<Integer> stack = new Stack<>();

		stack.push(arr[0]);
		for(int i=1 ; i<arr.length ; i++) {
			if(stack.peek() != arr[i]) {
				stack.push(arr[i]);
			}
		}

		int[] result = new int[stack.size()];
		for (int i=result.length-1 ; i>=0 ; i--) {
			result[i] = stack.peek();
			stack.pop();
		}

		return result;
	}
}
