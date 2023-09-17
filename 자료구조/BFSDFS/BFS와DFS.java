package 자료구조.BFSDFS;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1260

public class BFS와DFS {

	static StringBuilder sb = new StringBuilder();
	static boolean[] check;
	static int[][] arr;
	static int node, line, start;

	static Queue<Integer> q = new LinkedList<>();

	@Test
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start= Integer.parseInt(st.nextToken());

		//노드의 간선
		arr = new int[node+1][node+1];
		//방문 여부 체크 (반드시 검사하기! 검사하지 않을 경우 무한 루프에 빠질 위험성이 있다.)
		check = new boolean[node+1];

		for(int i=0 ; i<line ; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());

			arr[a][b] = arr[b][a] =  1;
		}

		dfs(start);
		sb.append("\n");
		check = new boolean[node+1];

		bfs(start);

		System.out.println(sb);

	}

	public static void dfs(int start) {

		check[start] = true;
		sb.append(start + " ");

		for(int i=0 ; i<=node ; i++) {
			if(arr[start][i] == 1 && !check[i])
				dfs(i);
		}
	}

	public static void bfs(int start) {
		q.add(start);
		check[start] = true;

		while(!q.isEmpty()) {

			start = q.poll();
			sb.append(start + " ");

			for(int i=1 ; i<=node ; i++) {
				if(arr[start][i] == 1 && !check[i]) {
					q.add(i);
					check[i] = true;
				}
			}
		}
	}

}
