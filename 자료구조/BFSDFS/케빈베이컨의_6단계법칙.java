package 자료구조.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 케빈베이컨의_6단계법칙 {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());  //유저의 수
        m = Integer.parseInt(st.nextToken());  //친구 관계의 수

        //카운트 체크
        dist = new int[n+1];
        graph = new ArrayList[n+1];
        for (int i=0 ; i<n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);  //x유저와 y유저는 연결되어 있다.
            graph[y].add(x);  //무방향 그래프이기 때문에 반대로도 연결
        }
        solution();
    }

    //n만큼 각각 bfs를 돌려 최댓값 갱신
    public static void solution() {
        int minCnt = Integer.MAX_VALUE; //최소 카운트
        int minIdx = 0; //해당 정점 번호

        //최소 카운트 및 정점 번호 갱신
        for (int i=0 ; i<n ; i++) {
            int cnt = bfs(i);
            if(minCnt > cnt) {
                minCnt = cnt;
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }

    public static int bfs(int start) {
        //방문 여부 및 카운트 초기화
        Arrays.fill(dist, -1);
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : graph[x]) {
                if(dist[y] != -1) continue;
                dist[y] = dist [x] + 1;
                cnt += dist[y];  //이동 횟수 누적
                q.add(y);
            }
        }
        return cnt;
    }
}
