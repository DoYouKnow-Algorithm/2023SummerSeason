package Week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1926 {
    static int N, M;
    static int arr[][];
    static boolean visit[][];
    static int[] dx, dy;
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로 크기
        M = Integer.parseInt(st.nextToken()); //가로 크기
        arr = new int[N][M]; //그림 정보
        visit = new boolean[N][M]; //방문 여부
        //오른쪽, 아래, 왼쪽, 위 좌표
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < N; i++) { //그림 정보 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int area = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //색칠 안된 곳이거나 방문했던 곳이면 패스
                if (arr[i][j] == 0 || visit[i][j]) {
                    continue;
                }
                count++; //그림 개수 +1
                q.offer(new Pair(i,j)); //해당 좌표 큐에 넣어줌
                visit[i][j]=true; //방문했으므로 TRUE로 바꿔줌
                area = 0; //area 초기화
                while(!q.isEmpty()){ //큐가 비어있지 않을 때까지
                    Pair p = q.poll(); //큐에서 하나 꺼내고
                    area++; //넓이 +1
                    for (int k = 0; k < 4; k++) {
                        int n_x = p.x + dx[k]; //X좌표 계산
                        int n_y = p.y + dy[k]; //Y좌표 계산
                        //계산 결과가 0보다 작거나 범위를 넘는다면 패스
                        if(n_x < 0 || n_x>=N || n_y<0 || n_y>=M){
                            continue;
                        }
                        //색칠되어있고 방문하지 않은 곳이라면 큐에 넣어주고 방문 처리해줌
                        if(arr[n_x][n_y]==1 && !visit[n_x][n_y]){
                            q.offer(new Pair(n_x, n_y));
                            visit[n_x][n_y]=true;
                        }
                    }
                }
                max = area>max?area:max; //최대 넓이 저장
            }
        }

        bw.write(String.valueOf(count+"\n"+max));
        bw.close();
        br.close();
    }
    //큐에 좌표를 넣어주기 위한 클래스
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

