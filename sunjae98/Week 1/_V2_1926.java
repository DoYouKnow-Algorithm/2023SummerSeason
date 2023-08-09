import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m; // 세로, 가로
    static int[][] paper; // 도화지
    static boolean[][] visited; // 방문 여부
    static int area; // 그림 넓이
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> areaList = new ArrayList<Integer>(); // 그림 넓이를 저장할 ArrayList

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean flag = false;
        paper = new int[500][500];
        visited = new boolean[500][500];

        //도화지에 그림 그리기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) {
                    flag = true;
                }
            }
        }

        if (flag == false) { // 그림이 하나도 없는 경우
            System.out.println("0");
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area = 0; // 넓이 초기화
                if (paper[i][j] == 1 && !visited[i][j]) { // 색칠 되어있음 + 방문 하지않음
                    area++; // 해당 그림 넓이도 포함
                    bfs(i, j); // bfs
                    areaList.add(area); // 넓이를 ArrayList에 저장
                }
            }
        }

        Collections.sort(areaList); // 오름차순 정렬

        System.out.println(areaList.size()); // 넓이를 저장한 횟수

        int lastIdx = areaList.size() - 1;
        int lastElement = areaList.get(lastIdx);
        System.out.println(lastElement); // 넓이 최대값

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

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && paper[nx][ny] == 1 && !visited[nx][ny]) {
                    area++;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
