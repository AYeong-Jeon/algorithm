package 자료구조.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14502
public class 연구소 {

    public static int n, m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] map;
    public static int[][] virusMap;
    public static int max = Integer.MIN_VALUE;  //최댓값을 찾기 위한 최소값 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());  //지도 세로 크기
        m = Integer.parseInt(st.nextToken());  //지도 가로 크기
        map = new int[n][m];

        //연구소 만들기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());  //지도의 모양 출력
            }
        }

        dfs(0);

        System.out.println(max);
    }

    //3개의 벽을 세우는 모든 경우의 수 dfs
    public static void dfs(int wall) {
        //벽이 3개가 설치된 경우 bfs 탐색 시작
        if (wall == 3) {
            bfs();
            return;
        }
        //아닌 경우 벽 설치하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    // 바이러스 퍼뜨리는 과정 bfs
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        virusMap = new int[n][m];
        // virusMap 만드는 이유
        // 벽이 세개 세워질 때마다 bfs를 실행해야하므로
        // 원본 연구소를 바꾸지 않기 위해 벽이 세워진 map을 복사해서 써야함 (초기화 용도)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
                if (virusMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        //bfs 탐색 시작
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //연구소 범위 밖이 아니고 빈칸일 경우에만 퍼트린다.
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && virusMap[nx][ny] == 0) {
                    virusMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 0) {
                    count++;
                }

            }
        }
        max = Math.max(max, count);
    }
}
