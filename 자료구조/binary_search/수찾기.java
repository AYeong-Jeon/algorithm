package 자료구조.binary_search;

import org.junitㅋ.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1920

public class 수찾기 {

	public static int[] arr;

	@Test
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		///첫 번째 줄에 자연수 N이 주어지고 두 번째 줄에 주어지는 배열의 크기임.
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];

		//두 번째 줄에 주어지는 정수를 arr 배열에 넣는다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		//탐색을 위해 배열을 정렬해놓기
		Arrays.sort(arr);

		//세 번째 줄에는 자연수 M과 M개의 수가 주어진다.
		int M =Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		//주어진 M개의 수 중 arr 배열에 존재하는지 찾는다. 있으면 1, 없으면 0 리턴하기
		for(int i=0 ; i<M ; i++) {
			/*if(Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {  Arrays.binarySearch 메소드를 사용하는 방법도 있음. */
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static int binarySearch(int key) {
		int lo = 0;             //왼쪽 끝 인덱스
		int hi = arr.length-1;  //오른쪽 끝 인덱스

		while (lo <= hi) {

			//이분 탐색을 위해 반으로 나누기
			int mid = (lo + hi) / 2;

			//key가 중간 위치의 값보다 작을 경우 -1을 해서 하나씩 비교함
			if(key < arr[mid]) {
				hi = mid - 1;
			}
			//key가 중간 위치의 값보다 클 경우
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			//key가 중간 위치의 값과 같은 경우
			else {
				return mid;
			}
		}

		//없을 경우는 -1 리턴
		return -1;
	}
}