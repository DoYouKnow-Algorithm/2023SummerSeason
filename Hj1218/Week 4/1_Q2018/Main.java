import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //자연수 n
        int sum =1; //연속된 자연수의 합
        int start=1; //시작 자연수
        int end=1; //끝 자연수
        int count=0; //가지수
        while(start<=end){
            if(sum==n){ //연속된 자연수의 합이 n인 경우
                count++; //가지수 증가
            }
            if(sum<n){ //합이 n보다 작은 경우
                end++; //끝 자연수 증가 후
                sum+=end; //더함
            } else if (sum>=n) { //합이 n보다 크거나 같은 경우
                sum-=start; //시작 자연수를 뺀 후
                start++; //시작 자연수 증가
            }
        }
        System.out.println(count);
    }
}