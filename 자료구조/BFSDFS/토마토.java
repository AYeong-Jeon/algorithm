package 자료구조.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7576
public class 토마토 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //익은 토마토 저장
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        //q가 빌 때까지 반복
        while (!q.isEmpty()) {
            int[] t = q.poll();
            //q에서 빼넨 토마토의 위치인 x,y를 가지고 좌, 우, 위, 아래를 탐색
            int x = t[0];
            int y = t[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //바구니 위치를 벗어났는지 확인하고 아닐 경우 계속
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //안 익은 토마토(0)일 경우 하루 더해주고 q에 넣기
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        //최소 개수 구하기
        int max = Integer.MIN_VALUE;
        //토마토가 들어있지 않은 칸은 -1
        if (checkZero()) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //최댓값 구하기
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }
            //날짜 셀 때 하루 추가했으므로 출력할 땐 하루 빼기
            return max - 1;
        }
    }
    //바구니 전체를 검사해서 0을 찾을 경우 반복문 종료
    private static boolean checkZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
}