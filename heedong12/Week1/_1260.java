package Week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {
    static  int[][] arr;
    static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();
    static int N,M,V;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); //정점의 개수
        M=Integer.parseInt(st.nextToken()); //간선의 개수
        V=Integer.parseInt(st.nextToken()); //탐색시작 정점 번호

        arr = new int[N+1][N+1];
        visit = new boolean[N+1];

        for(int i=0;i<M;i++){ //간선의 연결 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //간선은 양방향임
            arr[a][b]=1;
            arr[b][a]=1;
        }
        dfs(V); //DFS 수행
        sb.append("\n");
        visit = new boolean[N+1]; //초기화 시켜서 BFS에서 재사용
        bfs(V); //BFS 수행

        bw.write(String.valueOf(sb));
        bw.close(); br.close();
    }
    static void dfs(int V){ //DFS 메소드 구현
        visit[V]=true; //방문한 곳은 TRUE로 바꿔줌
        sb.append(V + " ");

        for (int i=0;i<=N;i++){
            //깊이 우선 탐색이므로 이어져있는 간선 모두 탐색
            if(arr[V][i]==1 && !visit[i]) dfs(i); //DFS 재귀호출
        }
    }

    static void bfs(int V){ //BFS 메소드 구현
        q.offer(V); //큐에 넣고
        visit[V]=true; //방문한 곳은 TRUE로 바꿔줌

        while(!q.isEmpty()){ //큐가 빌때까지 반복
            V=q.poll(); //큐에서 꺼내주고
            sb.append(V + " ");

            for (int i=1;i<=N;i++){
                //너비 우선 탐색이므로 인접 노드 먼저 탐색
                if (arr[V][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] =true;
                }
            }
        }
    }
}
