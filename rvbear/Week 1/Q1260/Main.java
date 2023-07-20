package silver._2.Q1260;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[][] map;
    static boolean[] visit;
    public static void dfs(int i) {         // 깊이 우선 탐색
        visit[i] = true;
        System.out.print(i + " ");
        for(int j = 1; j < n+1; j++) {
            if(map[i][j] == true && visit[j] == false) {
                dfs(j);
            }
        }
    }
    public static void bfs(int i) {         // 너비 우선 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");
            for(int j = 1; j < n+1; j++) {
                if(map[temp][j] == true && visit[j] == false) {
                    queue.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());                  // 정점의 개수
        m = Integer.parseInt(stk.nextToken());                  // 간선의 개수
        v = Integer.parseInt(stk.nextToken());                  // 정점의 번호

        map = new boolean[n+1][n+1];
        for(int i = 0; i < m; i++) {                            // map의 값 대입
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            map[a][b] = map[b][a] = true;
        }

        visit = new boolean[n+1];
        dfs(v);             // 깊이 우선 탐색 시작
        System.out.println();
        visit = new boolean[n+1];
        bfs(v);             // 너비 우선 탐색 시작

        br.close();         // 입력 버퍼 스트림 닫아줌
        bw.close();         // 출력 버퍼 스트림 닫아줌
    }
}