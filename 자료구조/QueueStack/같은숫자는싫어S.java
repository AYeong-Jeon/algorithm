package 자료구조.QueueStack;

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

		//스택의 0번째와 arr의 1번째를 비교하기 위해 먼저 스택에 arr[0]을 넣어줌
		stack.push(arr[0]);
		//stack의 가장 위의 값과 arr[i]번째가 같지 않을 경우 push (연속되지 않는 숫자만 들어감.)
		for(int i=1 ; i<arr.length ; i++) {
			if(stack.peek() != arr[i]) {
				stack.push(arr[i]);
			}
		}

		//스택의 크기만큼 int형 배열 생성해서 넣어준 후 리턴
		int[] result = new int[stack.size()];
		for (int i=result.length-1 ; i>=0 ; i--) {
			result[i] = stack.peek();
			stack.pop();
		}

		return result;
	}
}
