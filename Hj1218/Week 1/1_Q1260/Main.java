import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m,v;
    static boolean num[][]; //정점간 연결
    static boolean visit[]; //방문 여부
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //정점
        m = in.nextInt(); //간선
        v = in.nextInt(); //탐색 시작 정점 번호
        num= new boolean[n+1][n+1];

        for(int i=0;i<m;i++){ //간선의 개수만큼
            int a = in.nextInt(); //두 정점의 번호를 입력받아
            int b = in.nextInt();
            num[a][b]=num[b][a]=true; //연결
        }
        visit=new boolean[n+1];
        dfs(v);
        System.out.println();
        visit=new boolean[n+1];
        bfs(v);
    }
    public static void bfs(int i){ //너비 우선 탐색
        Queue<Integer> q = new LinkedList<>();
        q.offer(i); //queue에 값 추가
        visit[i]=true; //방문 여부
        while(!q.isEmpty()){
            int temp = q.poll(); //queue 맨 앞에 있는 값 반환 후 삭제
            System.out.print(temp + " ");
            for(int j=1; j<n+1; j++) {
                if(num[temp][j] && !visit[j]) { //연결된 정점, 방문 x인 경우
                    q.offer(j); //queue에 값 추가
                    visit[j] = true; //방문 o
                }
            }
        }
    }
    public static void dfs(int j){ //깊이 우선 탐색
        visit[j]=true; //방문 여부
        System.out.print(j+" ");
        for(int k=1;k<n+1;k++){
            if(num[j][k]&&!visit[k]){ //연결된 정점, 방문 x인 경우
                dfs(k); //k와 연결된 정점 탐색
            }
        }
    }
}