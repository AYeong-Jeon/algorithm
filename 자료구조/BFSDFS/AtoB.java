package 자료구조.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB {

    static long a,b;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int cnt = bfs(a,b);
        System.out.println(cnt);
    }

    public static int bfs (long a, long b) {
        Queue<Long> q = new LinkedList<>();
        q.add(a*2);
        q.add(a*10+1);

        int result = 0;
        while (!q.isEmpty()) {
            result++;
            int size = q.size();
            for (int i=0; i<size; i++) {
                long now = q.poll();
                if(now > b) continue;
                if(now == b) {
                    return result;
                }
                q.add(now*2);
                q.add(now*10+1);
            }
        }
        return -1;
    }
}
