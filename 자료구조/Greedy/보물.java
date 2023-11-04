package 자료구조.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1026

public class 보물 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		int[] A = new int[size];
		Integer[] B = new Integer[size];

		StringTokenizer ST = new StringTokenizer(br.readLine());

		for(int i=0; i<size; i++) {
			A[i] = Integer.parseInt(ST.nextToken());
		}
		Arrays.sort(A);			//오름차순 정렬

		ST = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			B[i] = Integer.parseInt(ST.nextToken());
		}

		Arrays.sort(B, Collections.reverseOrder());  //내림차순 정렬

		int sum = 0;
		for(int i=0; i<size; i++) { //A배열의 최솟값과 B배열의 최댓값을 곱해서 더해준다.
			sum+=A[i]*B[i];
		}
		System.out.println(sum);
	}

}