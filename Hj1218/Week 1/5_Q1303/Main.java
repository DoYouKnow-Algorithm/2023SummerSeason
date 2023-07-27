import java.util.Scanner;

public class Main {
    static int n,m,count;
    static char color[][];
    static boolean visit[][];
    static int wSum=0, bSum=0;
    static int x[] = {-1, 0, 1, 0};
    static int y[] = {0, 1, 0, -1};

    static void dfs(int a, int b){
        visit[a][b] = true; //방문 여부
        count++; //병사의 수
        for(int i=0;i<4;i++){ //1로 연결된 위치를 탐색해
            int ax = a + x[i];
            int by = b + y[i];
            if(ax<1||ax>m||by<1||by>n){ //전쟁터를 벗어난 경우
                continue;
            }
            if(color[ax][by]==color[a][b]&&!visit[ax][by]){ //같은 색 옷을 입고 방문하지 않은 경우
                dfs(ax,by);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //전쟁터의 가로 크기
        m = in.nextInt(); //전쟁터의 세로 크기
        color = new char[m+1][n+1]; //병사들의 옷색을 저장할 배열
        visit = new boolean[m+1][n+1]; //방문 여부를 저장할 배열
        for(int i=1;i<=m;i++){
            String s = in.next();
            for(int j=1;j<=n;j++){
                color[i][j]=s.charAt(j-1);
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(!visit[i][j]){
                    count = 0; //병사 수 초기화
                    dfs(i,j);
                    if(color[i][j]=='W'){ //아군인 경우
                        wSum+=Math.pow(count,2);
                    }
                    else { //적군인 경우
                        bSum+=Math.pow(count,2);
                    }
                }
            }
        }
        System.out.print(wSum+" "+bSum);
    }
}