package Week1;

import java.io.*;
import java.util.StringTokenizer;

public class _1303 {
    static char arr[][];
    static boolean visit[][];
    static int N, M;
    static int[] dx = {1, 0, -1, 0};    // 오른쪽, 아래, 왼쪽, 위 좌표
    static int[] dy = {0, 1, 0, -1};    // 오른쪽, 아래, 왼쪽, 위 좌표
    static int temp, sumW=0, sumB=0;

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];     // x좌표 계산
            int ny = y + dy[i];     // y좌표 계산
            //x좌표와 y좌표가 범위를 벗어나지 않고, 방문하지 않은 곳이며
            //W와 B를 구분하기 위해서
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[nx][ny] && arr[x][y] == arr[nx][ny]) {
                temp++;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로 크기
        M = Integer.parseInt(st.nextToken()); // 세로 크기
        arr = new char[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j); // 병사들의 옷 색 저장
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {     //방문하지 않은 곳이면
                    temp = 1;   //temp 변수 초기화
                    dfs(i, j);
                    if (arr[i][j] == 'W') { //W라면 sumW에 temp 제곱해서 더해줌
                        sumW += temp * temp;
                    } else if (arr[i][j] == 'B') { //B라면 sumB에 temp 제곱해서 더해줌
                        sumB += temp * temp;
                    }
                }
            }
        }

        bw.write(sumW + " " + sumB);
        bw.close();
        br.close();
    }
}
