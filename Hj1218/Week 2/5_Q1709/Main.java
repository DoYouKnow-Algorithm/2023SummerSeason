import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //정사각형 한 변의 길이
        int r = n/2; //반지름
        int count = 0; //원의 둘레가 그려지 타일의 개수
        int a = 1; //탐색 시작할 x좌표
        //1사분면만 탐색
        for(int i=r;i>=0;i--){ //y축 끝부터
            for(int j=a;j<=r;j++){ //x좌표가 늘어나는 방향으로 탐색
                //타일에서 원점부터 왼쪽 아래 좌표까지의 길이가 반지름보다 작고 원점부터 오른쪽 위 좌표까지의 길이가 반지름 보다 크면
                //사이에 원의 둘레가 그려짐
                if(length(j-1,i-1)< (long) r*r && length(j,i)> (long) r*r){
                    count++; //타일 개수 증가
                    a = j; //탐색할 x좌표 변경
                }
                else{ //원의 둘레가 그려져있지 않은 경우
                    if(j>a){
                        a = j-1;
                        break; //원의 둘레가 그려진 타일의 x좌표는 모두 다름(같은 x좌표를 가진 타일 존재 x)
                    }
                }
            }
        }
        System.out.println(count*4);
    }
    //원점부터 좌표까지의 길이 (피타고라스 정리 a^2 + b^2 = c^2 이용)
    static long length(int x, int y){
        return (long) (Math.pow(x,2)+Math.pow(y,2));
    }
}
