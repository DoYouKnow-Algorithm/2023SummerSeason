import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong(); //체스판의 세로 길이
        long m = in.nextLong(); //체스판의 가로 길이
        long count = 0; //방문할 수 있는 칸
        if(n==1){ //움직일 수 있는 방법 x
            count = 1;
        } else if (n==2) { //1칸 위 2칸 오른쪽, 1칸 아래 2칸 오른쪽만 가능
            if(m>=7){
                count = 4; //모든 이동 방법을 사용할 수 없어 최대는 4
            }
            else{
                count = (m+1)/2;
            }
        } else if (n>=3) {
            if(m<7){ //모든 이동 방법을 사용하려면 m은 최소 7
                count = Math.min(m,4); //2칸 위 1칸 오른쪽, 2칸 아래 1칸 오른쪽 반복으로 4가 최대
            }
            else{ //7까지 4가지 방법을 사용하고 2칸 위 1칸 오른쪽, 2칸 아래 1칸 오른쪽 반복이 최대
                count = m-2; //7까지 4가지 방법을 사용해 5칸 차지
            }
        }
        System.out.println(count);
    }
}
