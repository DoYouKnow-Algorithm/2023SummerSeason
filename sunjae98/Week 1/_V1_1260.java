import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int vertex, edge, start; // 정점의 개수, 간선의 개수, 시작 노드
    static boolean visited[];// 정점의 방문 여부
    static boolean[][] graph; // 그래프를 이차원 배열로 표현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new boolean[vertex + 1][vertex + 1]; // 그래프 초기화

        //그래프 그리기
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = true; // 양방향
        }

        visited = new boolean[vertex + 1]; // 방문 여부 초기화
        dfs(start);

        System.out.println(); // 출력 형식을 맞춤

        visited = new boolean[vertex + 1]; // 방문 여부 초기화
        bfs(start);
    }

    public static void dfs(int v) { // 깊이 우선 탐색
        visited[v] = true; // 현재 노드 방문 처리
        System.out.print(v + " "); // 방문 노드 출력

        // 인접 노드 탐색
        for (int i = 1; i <= vertex; i++) {
            if (graph[v][i] == true && visited[i] == false) { // 그래프로 표현되어 있음, 방문하지 않음
                dfs(i); // 해당 노드 탐색
            }
        }
    }

    public static void bfs(int v) { // 너비 우선 탐색
        Queue<Integer> queue = new LinkedList<Integer>(); // 큐
        queue.offer(v); // 시작 노드를 큐에 추가
        visited[v] = true; // 큐에 넣은 노드 방문 처리

        System.out.print(v + " "); // 방문 노드 출력

        // 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while (!queue.isEmpty()) { // 큐가 비어 있지 않을때 까지 반복
            int temp = queue.poll(); // 큐에서 꺼냄

            for (int i = 1; i <= vertex; i++) {
                if (graph[temp][i] == true && visited[i] == false) { // 그래프로 표현되어 있음, 방문하지 않음
                    queue.offer(i); // 해당 노드 큐에 추가
                    visited[i] = true; // 큐에 넣은 노드 방문 처리
                    System.out.print(i + " "); // 방문 노드 출력
                }
            }
        }
    }
}
