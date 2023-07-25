

import java.io.*;
import java.util.*;

public class Main{
    static int n, count;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //크기
        map = new int[n][n]; // 지도 배열

        for(int i = 0; i< n; i++){
            String str = br.readLine();
            for(int j = 0; j< n; j++){
                map[i][j] = str.charAt(j) - '0'; // 입력된 문자가 숫자일 경우 해당 숫자로 변환
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int result = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j< n; j++){
                count = 0; // 집 개수 초기화
                if(map[i][j] == 1){ // 해당 집이 1인 경우
                    bfs(i,j);
                    arr.add(count);
                    result++; // 단지 개수
                }
            }
        }

        Collections.sort(arr); //오름차순
        System.out.println(result);
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void bfs(int x, int y){ //너비 우선 탐색
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x,y});
        map[x][y] = 0;

        while(!qu.isEmpty()){
            count ++; // 집 개수
            int test[] = qu.poll();
            for(int i=0; i<4; i++){
                int nx = test[0] + dx[i];
                int ny = test[1] + dy[i];

                if(nx>=0 && nx< n && ny>=0 && ny< n && map[nx][ny]==1){ // 단지 내 셀 집이 더 이상 없는 경우
                    map[nx][ny] = 0;
                    qu.offer(new int[]{nx, ny});
                }
            }
        }
    }
}