package silver._1.Q1303;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, W_sum = 0, B_sum = 0, temp = 0;    // 가로, 세로, 우리 병사의 위력의 합, 적군 병사의 위력의 합, 계산을 위한 변수
    static int[] dx = {-1, 1, 0, 0};                    // 움직이는 x값
    static int[] dy = {0, 0, -1, 1};                    // 움직이는 y값
    static boolean[][] visit;                           // 방문 여부를 저장할 배열
    static char[][] maps;                               // 전쟁터 저장 배열
    public static void dfs(int x, int y) {              // dfs 탐색 시작
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            // 움직인 좌표가 전쟁터의 범위 안에 포함되며, 방문을 하지 않았고, 같은 병사들일 때만 탐색
            if(mx >= 0 && mx < m && my >= 0 && my < n && !visit[mx][my] && maps[x][y] == maps[mx][my]) {
                temp++;
                dfs(mx, my);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());          // 전쟁터의 가로 입력
        m = Integer.parseInt(stk.nextToken());          // 전쟁터의 세로 입력
        maps = new char[m][n];                          // 배열 생성
        visit = new boolean[m][n];                      // 배열 생성

        for(int i = 0; i < m; i++) {                    // 전쟁터 값 저장
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                maps[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j]) {                      // 방문하지 않은 곳부터 탐색 시작
                    temp = 1;                           // w와 b, 각각의 탐색에 사용되기 때문에 탐색 시작시 초기화 해줌
                    if(maps[i][j] == 'W') {             // W일 경우
                        dfs(i, j);                      // 탐색 후 값을 W_sum에 더해줌
                        W_sum += temp*temp;
                    }
                    else {                              // B일 경우
                        dfs(i, j);                      // 탐색후 값을 B_sum에 더해줌
                        B_sum += temp*temp;
                    }
                }
            }
        }

        System.out.println(W_sum + " " + B_sum);        // 해당 결과값 출력
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}