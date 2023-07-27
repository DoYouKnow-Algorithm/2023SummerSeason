package silver._2.Q21736;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, meet = 0;                  // 행, 열, 만나는 사람 수
    static int[] dx = {-1, 1, 0, 0};            // 이동하는 x 좌표
    static int[] dy = {0, 0, -1, 1};            // 이동하는 y 좌표
    static char[][] map;                        // 캠퍼스 정보
    static boolean[][] visit;                   // 방문 여부
    public static void dfs(int x, int y) {      // dfs 탐색
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            // 움직인 x, y 좌표가 캠퍼스의 범위 안에 들어가고, 방문하지 않았으며, 벽이 아닐 경우 탐색 시작
            if(mx >= 0 && my >= 0 && mx < n && my < m && !visit[mx][my] && map[mx][my] != 'X') {
                if(map[mx][my] == 'P') {        // 만일 사람이 있다면 meet 1 증가
                    meet++;
                }
                dfs(mx, my);                    // 재탐색
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());          // 행 입력
        m = Integer.parseInt(stk.nextToken());          // 열 입력
        map = new char[n][m];
        visit = new boolean[n][m];
        int x = 0, y = 0;                               // 탐색 시작 좌표 초기화

        for(int i = 0; i < n; i++) {                    // 캠퍼스 정보 입력
            String row = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'I') {                  // dfs 탐색 시작 위치를 알아냄
                    x = i; y = j;
                }
            }
        }

        dfs(x, y);                                      // 탐색 시작

        System.out.println(meet > 0 ? meet : "TT");     // 만일 사람을 만난다면 그 수를 만나지 않는다면 "TT"를 출력
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}