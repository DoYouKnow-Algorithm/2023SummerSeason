

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, count = 0, w = 0, b = 0;
    static char[][] map;
    static boolean[][] test;
    static int[] dx = {-1, 1, 0, 0}; // 좌우
    static int[] dy = {0, 0, -1, 1}; // 위 아래
    static Queue<int[]>qu = new LinkedList<>();
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //가로
        m = Integer.parseInt(st.nextToken()); //세로
        map = new char[n][m]; // 병사 지도
        test = new boolean[n][m]; // 확인 여부를 위한 배열

        for(int i=0; i<m; i++){ // 입력 받기
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[j][i] = str.charAt(j);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!test[i][j]){ // 확인하지 않았으면
                    count = 1;
                    test[i][j] = true;
                    qu.add(new int[] {i,j});
                    bfs();
                    if(map[i][j] =='W'){ // 나의 병사 위력의 합
                        w += count*count;
                    } else{ // 적국 병사 위력의 합
                        b += count*count;
                    }
                }
            }
        }
        System.out.println(w+" "+b);

    }

    public static void bfs(){ // 너비 우선 탐색
        while(!qu.isEmpty()){
            int[] num = qu.poll();
            int i = num[0];
            int j = num[1];
            for(int k=0; k<4; k++){ //상하좌우 탐색
                int nx = i + dx[k]; // 새로운 x좌표
                int ny = j + dy[k]; // 새로운 y좌표
                //각 끝을 넘는 좌표가 아니고 0 이상이고 이미 확인한 좌표가 아니고 같은 값이면
                if(nx>=0 && nx<n && ny>=0 && ny<m && !test[nx][ny] && map[nx][ny]==map[i][j]){
                    count++;
                    test[nx][ny] = true;
                    qu.add(new int[] {nx, ny});
                }
            }
        }
    }
}