import java.util.Scanner;

public class Main {
    static int n,m,nn,mm;
    static int count=0;
    static  char num[][];
    static  boolean visit[][];
    static int x[];
    static int y[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //캠퍼스 크기 n
        m = in.nextInt(); //캠퍼스 크기 m
        num = new char[n+1][m+1]; //캠퍼스의 정보를 저장할 배열
        visit = new boolean[n+1][m+1]; //방문 여부를 저장할 배열
        x = new int[]{-1, 0, 1, 0};
        y = new int[]{0, 1, 0, -1};

        for(int i=1;i<=n;i++){
            String s = in.next();
            for(int j=1;j<=m;j++){
                num[i][j]=s.charAt(j-1);
                if(num[i][j] == 'I'){ //도연이의 위치
                    nn = i;
                    mm = j;
                }
            }
        }
        dfs(nn,mm);
        if(count==0){ //만난 사람이 없는 경우
            System.out.println("TT");
        }else{
            System.out.println(count);
        }
    }
    static void dfs(int a, int b){
        visit[a][b] = true; //방문 여부
        for(int i=0;i<4;i++){ //1로 연결된 위치를 탐색해
            int ax = a + x[i];
            int by = b + y[i];
            if(ax<1||ax>n||by<1||by>m){ //캠퍼스를 벗어난 경우
                continue;
            }
            if(num[ax][by]!='X' && !visit[ax][by]){ //벽(X)이 아니면서 방문하지 않은 경우
                if(num[ax][by]=='P'){ //사람을 만난 경우
                    count++;
                }
                dfs(ax,by);
            }
        }
    }
}