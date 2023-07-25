import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m,max;
    static int num[][];
    static boolean visit[][];
    static int count,size;
    static int x[];
    static int y[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //도화지 세로 크기
        m = in.nextInt(); //도화지 가로 크기
        boolean check = false; //그림이 존재하지 않는 경우
        num = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];
        x = new int[]{-1, 0, 1, 0}; //x, y좌표에 값을 더해
        y = new int[]{0, 1, 0, -1}; //1로 연결된 좌표를 구함 (상하좌우)
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                num[i][j]=in.nextInt(); //그림의 정보 저장
                if(num[i][j]==1){ //그림이 존재하는 경우
                    check=true;
                }
            }
        }
        if(!check){ //그림이 존재하지 않는 경우
            System.out.println(0+"\n"+0);
        }
        else{ //그림이 존재하는 경우
            count = 0; //그림의 개수
            size = 0; //그림의 넓이
            max = 0; //가장 넓은 그림의 넓이
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(num[i][j]==0||visit[i][j]){ //0이거나 방문 o인 경우
                        continue;
                    }
                    count++; //개수 증가
                    visit[i][j]=true; //방문 여부
                    size=0;
                    Queue<Integer> qi = new LinkedList<>(); //그림의 x좌표를 저장할 queue
                    Queue<Integer> qj = new LinkedList<>(); //그림의 y좌표를 저장할 queue
                    qi.offer(i); //queue에 x좌표 저장
                    qj.offer(j); //queue에 y좌표 저장
                    while(!qi.isEmpty()){
                        int tempi = qi.poll(); //queue 맨 앞에 있는 값 반환 후 삭제
                        int tempj = qj.poll(); //queue 맨 앞에 있는 값 반환 후 삭제
                        size++; //그림의 넓이 증가
                        for(int k=0;k<4;k++){ //1로 연결된 좌표를 구해
                            int xx = tempi + x[k];
                            int yy = tempj + y[k];
                            if(xx<1||xx>n||yy<1||yy>m){ //도화지를 벗어난 경우
                                continue;
                            }
                            if(num[xx][yy]==1&&!visit[xx][yy]){ //1이면서 방문하지 않은 경우
                                qi.offer(xx); //queue에 x좌표값 추가
                                qj.offer(yy); //queue에 y좌표값 추가
                                visit[xx][yy]=true; //방문 여부
                            }
                        }
                    }
                    max = Math.max(max,size); //가장 넓은 그림의 넓이
                }
            }
            System.out.println(count);
            System.out.println(max);
        }
    }
}