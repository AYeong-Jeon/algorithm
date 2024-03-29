package 자료구조.BFSDFS;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 촌수계산 {
    static List<Integer>[] relation;
    static boolean[] checked;
    static int res = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //전체 사람 수
        int n = Integer.parseInt(br.readLine());
        relation = new ArrayList[n+1];
        checked = new boolean[n+1];
        for(int i=1; i<n+1; i++) {
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        //부모, 자식 번호
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int l = Integer.parseInt(br.readLine());

        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            relation[p].add(c);
            relation[c].add(p);
        }

        dfs(x,y, 0);
        System.out.println(res);
    }

    static void dfs(int start, int end, int cnt) {
        if(start == end) {
            res = cnt;
            return;
        }
        checked[start] = true;
        for(int i=0; i<relation[start].size(); i++) {
            int next = relation[start].get(i);
            if(!checked[next]) {
                dfs(next, end, cnt+1);
            }
        }
    }
}