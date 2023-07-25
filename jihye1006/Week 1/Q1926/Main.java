
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] test;
    static Queue<Pair> qu;
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        test = new boolean[n][m];
        qu = new LinkedList<>();

        dx = new int[]{1, 0, -1, 0}; // 오른쪽, 왼쪽
        dy = new int[]{0, 1, 0, -1}; // 위, 아래

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int area = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0 || test[i][j]){ // 0이거나 방문한 적이 있으면 생략
                    continue;
                }
                count++;
                qu.offer(new Pair(i, j)); // 큐에 좌표 넣어주기
                test[i][j] = true; // 방문 여부
                area = 0; // 넓이 초기화

                while(!qu.isEmpty()){
                    Pair p = qu.poll();
                    area++; // 넓이 +1
                    for(int k = 0; k<4; k++){
                        int nx = p.x + dx[k];
                        int ny = p.y + dy[k];
                        // 계산한 좌표가 0보다 작거나 끝값보다 크면 패스
                        if(nx<0 || nx>= n || ny<0 || ny>=m){
                            continue;
                        }
                        if(arr[nx][ny] == 1 && !test[nx][ny]){
                            qu.offer(new Pair(nx, ny));
                            test[nx][ny] = true;
                        }
                    }
                }
                if(area > max){
                    max = area;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){ //x좌표 반환
            return x;
        }
        public int getY(){ //y좌표 반환
            return y;
        }
        public void setX(int x){ //x좌표 수정 가능
            this.x = x;
        }
        public void setY(int y){ //y좌표 수정 가능
            this.y = y;
        }
    }
}
