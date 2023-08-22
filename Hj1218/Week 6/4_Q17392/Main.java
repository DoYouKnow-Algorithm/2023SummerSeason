import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //약속 개수
        int m = in.nextInt(); //방학 일수
        int []h = new int[n]; //기대행복
        int sum = 0; //우울하지 않은 날
        for(int i=0;i<n;i++){
            h[i]=in.nextInt();
            sum += h[i]+1; //ex) h[i]가 2인 경우 2, 1, 0 3일동안 우울하지 않음
        }
        int downDay = m-sum; //우울한 날
        int down = 0; //우울함
        if(downDay<=0){ //우울한 날이 없는 경우
            System.out.println(0);
        }
        else{ //우울한 날을 n+1개의 구간에 최대한 일정한 간격으로 배치해야함
            int a = downDay/(n+1); //공통간격
            int b = downDay%(n+1); //b개의 구간에 우울한 날 하루씩 더 배치
            for(int i=1;i<=a;i++){
                down+=Math.pow(i,2);
            }
            down=down*(n+1);
            down+=Math.pow(a+1,2)*b;
            System.out.println(down);
        }
    }
}