package 자료구조.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1541

public class 잃어버린괄호 {

	static long ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(),"-");

		while(st.hasMoreTokens()) {

			int temp = 0;

			StringTokenizer str = new StringTokenizer(st.nextToken(),"+");

			while(str.hasMoreTokens()) {
				temp += Integer.parseInt(str.nextToken());
			}

			if(ans == Integer.MAX_VALUE) {
				ans = temp;
			} else {
				ans -= temp;
			}
		}
		System.out.println(ans);
	}
}
