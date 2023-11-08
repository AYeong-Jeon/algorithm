package 자료구조.BFSDFS;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/4963

public class 섬의개수 {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[][] checkArr;  //방문 여부 배열
    static int[][] mapArr; //지도 2차 배열
    static int w, h, count;  //지도의 너비와 높이, 섬의 갯수
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1}; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1}; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
    static class Node{ //Queue에 담기 위해 지도의 좌표를 담는 Node
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    /*
    * 상좌(위쪽 왼쪽 대각선) mapArr[1][-1]
    * 상우(위쪽 오른쪽 대각선) mapArr[1][1]
    * 하좌(아래쪽 왼쪽 대각선) mapArr[-1][-1]
    * 하우(아래쪽 오른쪽 대각선) mapArr[-1][-1]
    * */

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w ==0 && h == 0)
                break;

            mapArr = new int[h][w];
            checkArr = new boolean[h][w];
            count = 0 ;// 섬 갯수 초기화

            for(int i=0;i<h;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++)
                    mapArr[i][j] = Integer.parseInt(st.nextToken());
            }//지도 입력

            //dfs 풀이
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    if(mapArr[i][j] == 1 && !checkArr[i][j]) {
                        //System.out.println("현재 섬 시작 위치 ("+i+","+j+")");
                        checkArr[i][j] = true;
                        dfs(i,j);  //섬이면 dfs로 섬 찾기
                        count++;
                    }
                }
            }

            //bfs 풀이
            /*
             mapArr 지도를 한 점씩 방문하여 방문시에
             bfs로 한 시도당, 방문한 모든 섬의 1의 값을 0으로 변환할 것이기 때문에
             지도에서 좌표가 0인 경우, 바다 or 이미 지워진 섬이다.
             섬의 개수만 세면 되기 때문에 그냥 mapArr에서 차례로 섬을 지워가며 개수 counting한다.
            */
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    if(mapArr[i][j] != 0 ) {
                        count++;
                        bfs(i,j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    //모든 좌표를 탐색하여 연결되어있는 섬의 경우 0으로 변환 해준다.
    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        mapArr[x][y] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            //8방향으로 돌면서 link되어있는지 체크
            for (int i = 0; i < dx.length; i++) {
                int nextX = dx[i] + node.x;
                int nextY = dy[i] + node.y;
                if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
                if (mapArr[nextX][nextY] == 1) {
                    mapArr[nextX][nextY] = 0;
                    q.offer(new Node(nextX, nextY));
                }
            }
        }
    }

    static void dfs(int row,int col) {

        for (int d = 0; d < 8; d++) {
            int nx = row + dx[d];
            int ny = col + dy[d];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w || mapArr[nx][ny] == 0 || checkArr[nx][ny])
                continue; //배열 범위 벗어나면 그만두기

            //방문X이고 섬이면
            checkArr[nx][ny] = true;
            dfs(nx, ny);
        }
    }

}
