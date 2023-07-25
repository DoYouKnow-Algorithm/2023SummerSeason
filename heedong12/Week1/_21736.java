package Week1;

import java.io.*;
import java.util.StringTokenizer;

public class _21736 {
    static int N, M;
    static char[][] arr;
    static boolean[][] visit;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int count=0;

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x; // x좌표 계산
            int ny = dy[i] + y; // y좌표 계산
            //x좌표와 y좌표가 범위를 넘지 않고, 방문하지 않았으며
            //X가 아닐때
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && arr[nx][ny] != 'X'){
                if(arr[nx][ny]=='P') count++;   //P이면 count +1
                dfs(nx,ny); //dfs 재귀호출
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로 크기
        M = Integer.parseInt(st.nextToken()); // 세로 크기
        arr = new char[N][M];
        visit = new boolean[N][M];

        int a=0,b=0;
        for (int i = 0; i < N; i++) {   //캠퍼스 정보 저장
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j]=='I') {    //도연이의 현재 위치 구함
                    a=i;b=j;
                }
            }
        }
        dfs(a, b);  //도연이의 위치에서 dfs 호출
        if(count==0){   //아무도 못 만났을때
            bw.write("TT");
        }else{
            bw.write(String.valueOf(count));
        }
        bw.close();

    }
}
