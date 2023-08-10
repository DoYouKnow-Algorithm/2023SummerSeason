import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 여부
    static int num; // 집의 수
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> estate = new ArrayList<Integer>(); // 단지별 집의 수를 저장할 ArrayList

        N = Integer.parseInt(br.readLine());
        map = new int[25][25];
        visited = new boolean[25][25];

        //정사각형 지도 그리기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num = 0; // 집의 수 초기화
                if (map[i][j] == 1 && !visited[i][j]) { // 집이 있는 곳 + 방문 하지않음
                    num++; // 해당 집도 포함
                    bfs(i, j); // bfs
                    estate.add(num); // 단지
                }
            }
        }

        Collections.sort(estate); // 오름차순 정렬

        System.out.println(estate.size()); // 총 단지수

        for (int i = 0; i < estate.size(); i++) {
            System.out.println(estate.get(i)); // ArrayList 의 i 번째 요소 출력
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

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    num++;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}


