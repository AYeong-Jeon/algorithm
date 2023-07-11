package 자료구조.BruteForce;

import org.junit.Test;

// https://www.acmicpc.net/problem/4673

public class 셀프넘버 {

	@Test
	public static void main(String[] args) {
		boolean[] numCk = new boolean[10001];
		StringBuilder sb = new StringBuilder();

		for(int i=1 ; i<10001 ; i++) {
			int n = d(i);
			if(n < 10001) { //인덱스에 숫자 있으면 true로 넣어줌
				numCk[n] = true;
			}
		}

		for(int i=1 ; i<10001 ; i++) {
			if(!numCk[i]) { //false 인 경우만 셀프넘버
				sb.append(i).append('\n');
			}
		}

		System.out.println(sb);
	}
	public static int d(int number) {
		int sum = number;

		//셀프 넘버 찾기
		while (number != 0) {
			//전체자리 수 + 한자리 수 더하기
			sum += number % 10;
			//한자리 수 구하기
			number = number/10;
		}

		return sum;
	}
}
