package 자료구조.정렬;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2750

class 수정렬하기 {

	@Test
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//첫 줄은 수의 개수가 주어진다.
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for(int i=0 ; i<n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//오름차순 정렬
		Arrays.sort(arr);

		for(int num : arr) {
			System.out.println(num);
		}
	}


	//카운팅 정렬 사용, 다른 풀이
	@Test
	public static void solution2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		/*
		  range : -1000 ~ 1000
		  0 은 index[1000] 을 의미
		*/
		boolean[] arr = new boolean[2001];

		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000] = true;
		}

		// 정렬 과정이 따로 필요 없음
		for(int i = 0; i < 2001; i++) {
			if(arr[i]) {
				sb.append(i - 1000).append('\n');
			}
		}
		System.out.println(sb);
	}

}