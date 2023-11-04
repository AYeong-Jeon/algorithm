package 자료구조.BFSDFS;


//https://www.acmicpc.net/problem/1012

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {

    static int[][] ground;      //2차원 배열로 배추밭을 표현한다
    static boolean[][] check;   //2차원 배열로 배추가 있는 곳을 체크한다
    static int weight;          //배추밭의 가로
    static int height;          //배추밭의 세로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            ground = new int[weight][height];
            check = new boolean[weight][height];

            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[x][y] = 1;   //배추 좌표 입력
            }
            //여기까지는 입력된 내용 저장

            int count=0;    //테스트 케이스마다 지렁이의 개수를 세야한다

            //bfs의 시작좌표를 셋팅해서 다른 곳에 모여있는 배추들도 파악할 수 있게한다
            //가로 세로 좌표들을 하나씩 입력해주고
            for (int j = 0; j < weight; j++) {
                for (int k = 0; k < height; k++) {

                    //좌표에 배추가 있는지 확인, 내가 체크안한 곳인지 확인한다
                    if(ground[j][k] == 1 && !check[j][k]){
                        //배추가 있고 체크안된 좌표에서부터 dfs로 연결된 곳을 파악한다
                        dfs(j, k);

                        //지렁이의 개수는 인접한 곳마다 1개씩이다.
                        //인접한 곳을 모두 파악했으면 지렁이를 한마리 놓는다.
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static void dfs(int startX, int startY) {
        check[startX][startY] = true;
        //시작좌표엔 배추가 있으니 미리 true로 처리해준다.

        int[] X = {0, 0, -1, +1};
        int[] Y = {-1, +1, 0, 0};
        //배추가 상하좌우에 인접하면 이동할 수 있다.
        //현재좌표에서 상하좌우 움직이는 좌표를 지정한다.

        //상하좌우 4가지 방법이니 for문 4번 반복
        for (int i = 0; i < 4; i++) {
            int x = startX + X[i];
            int y = startY + Y[i];
            //상하좌우 좌표 조정

            //좌표가 배추밭을 벗어나게되면 다음 좌표를 체크해야한다
            if(x < 0 || x >= weight || y < 0 || y >= height){
                continue;
            }

            //상하좌우 움직인 좌표에 배추가 있고, 체크하지 않은 좌표이면
            if(ground[x][y] == 1 & !check[x][y]){
                dfs(x, y);	//해당 좌표로 dfs 실행
            }

        }


    }

}
