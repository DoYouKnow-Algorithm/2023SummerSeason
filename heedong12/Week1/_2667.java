package Week1;

import java.io.*;
import java.util.*;

public class _2667{
    static int N, count;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};    //오른쪽, 아래, 왼쪽, 위 좌표
    static int[] dy = {0, 1, 0, -1};    //오른쪽, 아래, 왼쪽, 위 좌표

    public static void dfs(int x, int y){
        map[x][y] = 0;  //방문한 곳은 0으로 바꿈
        count += 1;     //단지 크기 +1

        for(int i=0; i<4; i++){
            int nx = x + dx[i];     //x좌표 계산
            int ny = y + dy[i];     //y좌표 계산
            //x, y 좌표가 0 이상이고 지도의 크기보다 작으면 dfs 재귀호출
            if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]==1) dfs(nx, ny);
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //지도의 크기
        map = new int[N][N]; //집 정보

        for(int i=0; i<N; i++){ //집 정보 저장
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int result = 0;     //단지의 개수
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                count = 0;  //count 초기화
                if(map[i][j] == 1){
                    dfs(i,j);   //dfs 함수 실행
                    arr.add(count); //단지 크기 저장
                    result++;   //단지 개수 +1
                }
            }
        }

        Collections.sort(arr);      //오름차순 정렬
        bw.write(String.valueOf(result+"\n"));   //총 단지의 수 출력
        for(int i : arr){   //단지 내 집의 수를 출력
            bw.write(String.valueOf(i+"\n"));
        }
        bw.close(); br.close();
    }
}