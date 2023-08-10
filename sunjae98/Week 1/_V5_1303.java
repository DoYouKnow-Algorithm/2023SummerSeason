import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] battleground;
    static boolean[][] visited;
    static int count;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> group_W = new ArrayList<Integer>(); // 뭉쳐있는 병사들의 수를 저장할 ArrayList
        ArrayList<Integer> group_B = new ArrayList<Integer>(); // 뭉쳐있는 병사들의 수를 저장할 ArrayList

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        battleground = new char[100][100];
        visited = new boolean[100][100];

        double power_W = 0; // 아군 병사의 위력
        double power_B = 0; // 적군군 병사의 위력

        //전쟁터 정보
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                battleground[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                count = 0; // 집의 수 초기화
                if (battleground[i][j] == 'W' && !visited[i][j]) { // 아군 + 방문 하지않음
                    count++; // 해당 집도 포함
                    bfs(i, j); // bfs
                    group_W.add(count);
                } else if (battleground[i][j] == 'B' && !visited[i][j]) {  // 적군 + 방문 하지않음
                    // 적군 + 방문 하지않음
                    count++; // 해당 집도 포함
                    bfs(i, j); // bfs
                    group_B.add(count);
                }
            }
        }

        for (int i = 0; i < group_W.size(); i++) {
            power_W += Math.pow(group_W.get(i), 2); // 병사수^2 를 아군 병사의 위력에 더해줌
        }

        for (int i = 0; i < group_B.size(); i++) {
            power_B += Math.pow(group_B.get(i), 2); // 병사수^2 를 적군 병사의 위력에 더해줌
        }

        System.out.print((int)power_W + " " + (int)power_B); // 출력 형식을 맞춰줌

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

                // 전쟁터 영역, 같은 팀, 방문하지 않음
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && battleground[nx][ny] == battleground[x][y] && !visited[nx][ny]) {
                    count++;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}

