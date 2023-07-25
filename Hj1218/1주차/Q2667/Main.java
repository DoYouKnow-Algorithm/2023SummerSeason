import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static  int num[][];
    static  boolean visit[][];
    static  int an[];
    static  int apartNum=0;
    static int x[];
    static int y[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //지도의 가로, 세로 크기
        num = new int[n+1][n+1]; //지도 배열
        visit = new boolean[n+1][n+1]; //방문 여부
        an = new int[26*26]; //단지내 집의 수 저장할 배열
        x = new int[]{-1, 0, 1, 0};
        y = new int[]{0, 1, 0, -1};

        for(int i=1;i<=n;i++){
            String s = in.next(); //단지 번호(자료)를 한줄씩 입력받아
            for(int j=1;j<=n;j++){
                num[i][j]=s.charAt(j-1)-'0'; //쪼개서 배열에 저장
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(num[i][j]==1 && !visit[i][j]){
                    apartNum++; //단지 수 증가
                    dfs(i,j);
                }
            }
        }
        System.out.println(apartNum); //총 단지수 출력
        Arrays.sort(an); //단지내 집의 수 오름차순 정렬
        for(int i=0;i<an.length;i++){
            if(an[i]!=0){
                System.out.println(an[i]); //각 단지내 집의 수 출력
            }
        }
    }
    static void dfs(int a, int b){
        visit[a][b] = true; //방문 여부
        an[apartNum]++; //단지내 집의 수 증가
        for(int i=0;i<4;i++){ //1로 연결된 집을 탐색해
            int ax = a + x[i];
            int by = b + y[i];
            if(ax<1||ax>n||by<1||by>n){ //지도를 벗어난 경우
                continue;
            }
            if(num[ax][by]==1 && !visit[ax][by]){ //1이면서 방문하지 않은 경우
                dfs(ax,by);
            }
        }
    }
}