

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][] test;
    static int[] dx = {-1, 1, 0, 0}; // 좌우
    static int[] dy = {0, 0, -1, 1}; // 위 아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //가로
        m = Integer.parseInt(st.nextToken()); //세로
        map = new char[n][m]; //지도
        test = new boolean[n][m]; //확인 여부

        int x = 0, y = 0;

        for (int i = 0; i < n; i++) { // 입력 받기
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        int count = 0; // 사람 수
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(x, y));
        test[x][y] = true;

        while (!qu.isEmpty()) {
            Pair pair = qu.peek();
            int tx = pair.x;
            int ty = pair.y;
            qu.poll();

            if (map[tx][ty] == 'P') { //만날 수 있으면
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i]; // 새로 이동할 x좌표
                int ny = ty + dy[i]; // 새로 이동할 y좌표

                // 벽이거나 해당 좌표가 끝 값을 넘었거나 방문하지 않은 곳일 때
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'X' || test[nx][ny]) {
                    continue;
                }

                test[nx][ny] = true;
                qu.add(new Pair(nx, ny));
            }
        }

        if (count == 0) { // 사람이 없는 경우
            System.out.println("TT");
        } else { // 사람 수 출력
            System.out.println(count);
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
