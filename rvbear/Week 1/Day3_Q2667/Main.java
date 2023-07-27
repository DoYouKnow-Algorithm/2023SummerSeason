package silver._1.Q2667;

import java.io.*;
import java.util.*;

public class Main {
    static int n, count = 0, temp = 0;              // 크기, 단지의 개수, 단지의 크기
    static int[][] map;                             // 단지 지도
    static boolean[][] visit;                       // 방문 여부
    static int[] dx = {-1, 1, 0, 0};                // 변화하는 x값
    static int[] dy = {0, 0, -1, 1};                // 변화하는 y값
    public static void dfs(int x, int y) {          // dfs를 통해 탐색
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            // 지도의 범위 안에 들면서 방문하지 않았지만 연속된 단지의 부분일 경우
            if(mx >= 0 && my >= 0 && mx < n && my < n && !visit[mx][my] && map[mx][my] == 1) {
                temp++;                             // 넓이 증가
                dfs(mx, my);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        n = Integer.parseInt(br.readLine());    // 지도의 크기 입력받음
        map = new int[n][n];                    // 배열 생성
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++) {            // 배열에 해당 값 넣어줌
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> size = new ArrayList<>();        // 각 단지의 크기를 저장할 배열
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {                    // 탐색 시작
                if(!visit[i][j] && map[i][j] == 1) {
                    temp = 1;
                    count++;
                    dfs(i, j);
                    size.add(temp);
                }
            }
        }

        Collections.sort(size);                             // 오름차순으로 정렬

        System.out.println(count);                          // 단지의 개수 출력
        for(int num : size) {                               // 정렬된 순서대로 각 단지의 크기 출력
            System.out.println(num);
        }
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}