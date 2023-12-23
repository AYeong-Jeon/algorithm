package 자료구조.BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1697

public class 숨바꼭질 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  //수빈이 위치
        int k = Integer.parseInt(st.nextToken());  //동생 위치

        //수빈이와 동생의 위치가 같을 땐 0초
        if(n == k) {
            System.out.println(0);
            return;
        }

        //방문했던 인덱스를 체크하기 위한 배열
        boolean[] visited = new boolean[100001];
        visited[n] = true;
        Queue<Integer> q = new LinkedList<>();
        //q에 수빈이 위치 넣어주기
        q.add(n);

        int size = q.size();
        int count = 0;
        while (true) {
            //초 세기
            count++;
            size = q.size();
            for (int i=0 ; i<size ; i++) {
                Integer x = q.poll();
                if(x != null) {
                    visited[x] = true;
                    //수빈이가 이동한 위치가 동생이 있는 위치일 경우
                    if(x-1 == k || x+1 == k || x*2 == k) {
                        System.out.println(count);
                        return;
                    }
                    //수빈이위치 -1 이 0보다 크고 처음 방문한 인덱스임.
                    if(x-1 >= 0 && !visited[x-1]) {
                        visited[x-1] = true;
                        q.add(x-1);
                    }
                    if(x+1 <= 100000 && !visited[x+1]) {
                        visited[x+1] = true;
                        q.add(x+1);
                    }
                    if(x*2 <= 100000 && !visited[x*2]) {
                        visited[x*2] = true;
                        q.add(x*2);
                    }
                }
            }
        }
    }

}

