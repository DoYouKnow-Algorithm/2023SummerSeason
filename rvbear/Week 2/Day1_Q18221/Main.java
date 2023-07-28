package silver._5.Q18221;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        int n = Integer.parseInt(br.readLine());    // 교실의 크기
        int[][] room = new int[n][n];               // 교실의 정보를 저장할 배열
        int px = 0, py = 0, sx = 0, sy = 0;         // 교수님의 (x, y) 좌표, 성규의 (x, y) 좌표
        for(int i = 0; i < n; i++) {                // 교실의 정보 입력
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                room[i][j] = Integer.parseInt(stk.nextToken());
                if(room[i][j] == 5) {               // 교수님의 위치를 저장
                    px = i; py = j;
                }
                if(room[i][j] == 2) {               // 성규의 위치를 저장
                    sx = i; sy = j;
                }
            }
        }

        if(((px-sx)*(px-sx)+(py-sy)*(py-sy)) < 25) {        // 교수님과 성규의 거리가 5 이하라면 0 출력 후 종료
            System.out.println(0);
            return;
        }

        int count = 0;                              // 교수님과 성규 사이의 학생 수를 저장할 변수
        for(int i = Math.min(px, sx); i <= Math.max(px, sx); i++) {         // 교수님과 성규의 x좌표를 비교하여 작은 곳부터 큰 곳까지
            for(int j = Math.min(py, sy); j <= Math.max(py, sy); j++) {     // 교수님과 성규의 y좌표를 비교하여 작은 곳부터 큰 곳까지
                if(room[i][j] == 1) {               // 사이에 학생이 있다면 count 증가
                    count++;
                }
            }
        }

        System.out.println(count > 2 ? 1 : 0);      // 학생의 수가 2보다 클 경우 1을 아닐 경우 0을 출력
        br.close();                                 // 입력 버퍼 스트림 닫아줌
    }
}