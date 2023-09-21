package 자료구조.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {
	static boolean[] check;
	static int[][] arr;
	static int count = 0;
	static int node, line;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//노드의 개수
		node = Integer.parseInt(br.readLine());
		//간선의 개수
		line = Integer.parseInt(br.readLine());

		//인접 행렬을 표현하기 위한 배열
		arr = new int[node+1][node+1];
		//감염여부를 판단하는 배열
		check = new boolean[node+1];

		for(int i = 0 ; i < line ; i ++) {
			StringTokenizer str = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());

			arr[a][b] = arr[b][a] =  1;
		}

		dfs(1);
		System.out.println(count-1);

	}
	public static void dfs(int start) {

		//감염된 컴퓨터 true
		check[start] = true;
		//감염된 컴퓨터의 개수 세기
		count++;

		for(int i = 0 ; i <= node ; i++) {
			//연결되어 있고, 감염 안되어 있으면 들어가기
			if(arr[start][i] == 1 && !check[i])
				dfs(i);
		}

	}

}
