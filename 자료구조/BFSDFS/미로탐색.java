package 자료구조.BFSDFS;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2178

public class 미로탐색 {

	static int[][] map;
	static int n;
	static int m;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
	static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우

	@Test
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//미로 입력에 공백이 들어가지 않으므로, string으로 받고, 한 글자씩 map에 삽입
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		//방문 체크를 위한 visited 배열을 준비하고, 첫 시작인 0,0 인덱스를 true로 설정
		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(map[n-1][m-1]);
	}

	public static void bfs(int x, int y) {
		//이동 가능한 칸들의 인덱스를 저장할 Queue를 선언, (x,y)쌍의 int형 배열을 저장
		Queue<int[]> q = new LinkedList<>();
		//넘겨받은 x,y를 int형 배열로 만들어 큐에 삽입
		q.add(new int[] {x,y});

		while(!q.isEmpty()) {
			//큐에서 원소 하나를 꺼내 각각 인덱스를 nowX, nowY에 저장
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];

			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
					continue;
				if (visited[nextX][nextY] || map[nextX][nextY] == 0)
					continue;

				//(nowX, nowY)를 기준으로 상하좌우를 확인해서 이동 가능한 인덱스가 있다면 그 인덱스를 큐에 저장
				q.add(new int[] {nextX, nextY});
				//그 인덱스의 값을 현재 인덱스(nowX, nowY)값보다 1 큰 값으로 설정
				map[nextX][nextY] = map[nowX][nowY] + 1;
				//그 인덱스의 방문체크
				visited[nextX][nextY] = true;
			}
		}
	}
}