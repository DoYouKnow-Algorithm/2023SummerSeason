import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //강의실 크기 n x n
        int [][]num = new int[n][n];
        int pi=0,pj=0,si=0,sj=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                num[i][j]=in.nextInt();
                if(num[i][j]==5){ //교수님 위치
                    pi = i;
                    pj = j;
                }
                else if(num[i][j]==2){ //성규 위치
                    si = i;
                    sj = j;
                }
            }
        }
        if(Math.sqrt(Math.pow(pi-si,2)+Math.pow(pj-sj,2))<5){ //교수님과 성규의 거리가 5 미만인 경우
            System.out.println(0);
        }
        else { //거리가 5 이상인 경우
            int count = 0; //학생 수
            for(int i=Math.min(pi,si);i<=Math.max(pi,si);i++){
                for(int j=Math.min(pj,sj);j<=Math.max(pj,sj);j++){ //직사각형 범위 안에
                    if(num[i][j]==1){ //학생이 존재하면
                        count++;
                    }
                }
            }
            if(count>=3){ //3명 이상 존재하면
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
