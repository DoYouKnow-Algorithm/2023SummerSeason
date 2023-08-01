import java.util.Scanner;

public class Main {
    static int s,n,count,sum;
    static int [] num;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //정수의 개수 n
        s = in.nextInt(); //정수 s
        num = new int[n]; //정수 배열
        for(int i=0;i<n;i++){
            num[i]=in.nextInt(); //수열 저장
        }
        check(0);
        System.out.println(count);
    }
    static void check(int number){
        if(number==n){ //모든 정수를 탐색한 경우
            return;
        }
        else{
            if(sum+num[number]==s){ //부분 수열의 합이 정수 s와 같은 경우
                count++; //카운트 증가
            }
        }
        sum+=num[number]; //해당 위치의 정수를 더한 경우
        check(number+1);
        sum-=num[number]; //해당 위치의 정수를 더하지 않은 경우
        check(number+1);
    }
}