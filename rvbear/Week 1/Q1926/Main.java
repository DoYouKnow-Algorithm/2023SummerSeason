package silver._1.Q1926;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, count = 0, max = 0, temp = 0;      // 행, 열, 그림의 개수, 가장 넓은 그림의 넓이, 넓이 구하기 위한 변수
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};                    // 연속된 부분 탐색을 위한 x값 배열
    static int[] dy = {0, 0, 1, -1};                    // 연속된 부분 탐색을 위한 y값 배열
    public static void dfs(int x, int y) {              // dfs를 통해 탐색
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {                    // 상, 하, 좌, 우를 검색
            int mx = x + dx[i];
            int my = y + dy[i];
            // 0 <= x < n, 0 <= y < m, 방문하지 않았지만 연속된 그림 부분일 경우
            if(mx >= 0 && my >= 0 && mx < n && my < m && !visit[mx][my] && map[mx][my] == 1) {
                temp++;                                 // 넓이 증가
                dfs(mx, my);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++) {                    // 초깃값 설정
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {                    // 탐색을 통해 그림의 개수와 가장 넓은 그림의 넓이 구함
            for(int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    temp = 1;
                    count++;
                    dfs(i, j);
                    max = Math.max(temp, max);
                }
            }
        }

        System.out.println(count);                      // 그림의 개수 출력
        System.out.println(max);                        // 가장 넓은 그림의 넓이 출력
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}