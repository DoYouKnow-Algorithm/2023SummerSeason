import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int num;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[600][600];
        visited = new boolean[600][600];

        // 도연이 위치를 저장할 변수
        int x = 0;
        int y = 0;

        //캠퍼스 정보
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y); //도운이가 위치한 좌표에서 bfs 시작

        if (num == 0) {
            System.out.print("TT");
        } else {
            System.out.print(num);
        }
    }

    public static void bfs(int x, int y) { // 너비 우선 탐색
        Queue<int[]> queue = new LinkedList<>(); // x,y 좌표를 저장할 큐
        queue.add(new int[]{x, y});
        visited[x][y] = true; // 큐에 넣은 노드 방문 처리

        while (!queue.isEmpty()) { // 큐가 비어 있지 않을때 까지 반복
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for (int i = 0; i < pos.length; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                // 캠퍼스 내부 영역, 벽이 아님, 방문하지 않음
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && campus[nx][ny] != 'X' && !visited[nx][ny]) {
                    if (campus[nx][ny] == 'P') { // 사람이 있을때 num 증가
                        num++; // 횟수 증가
                    }
                    visited[nx][ny] = true; // 방문처리
                    queue.add(new int[]{nx, ny}); // 큐에 추가
                }
            }
        }
    }
}
