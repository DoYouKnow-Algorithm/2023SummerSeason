
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] test;
    static int [][] arr;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new LinkedList<>();
    static int n, m, v;

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());  // 정점
        m = Integer.parseInt(st.nextToken()); // 간선
        v = Integer.parseInt(st.nextToken()); // 탐색 시작할 정점의 번호

        arr = new int[n+1][n+1]; // 2차원 배열로 저장 받기 위함
        test = new boolean[n+1]; // 중복 여부 확인 위함

        for(int i=0; i<m; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(v);
        sb.append("\n");
        test = new boolean[n+1];

        bfs(v);
        System.out.println(sb);

    }
    public static void dfs(int v){ // 깊이 우선 탐색
        test[v] = true;
        sb.append(v+" ");
        for(int i=0; i<=n; i++){
            if(arr[v][i] == 1 && !test[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){ // 너비 우선 탐색
        q.add(v);
        test[v] = true;
        while(!q.isEmpty()){
            v = q.poll();
            sb.append(v+" ");

            for(int i=1; i<=n; i++){
                if(arr[v][i] == 1 && !test[i]){
                    q.add(i);
                    test[i] = true;
                }
            }
        }
    }
}
