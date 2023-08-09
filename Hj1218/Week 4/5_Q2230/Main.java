import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //정수 n개
        long m = in.nextLong(); //두 수의 차이 m
        long a[] = new long[n]; //수열 배열
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        Arrays.sort(a); //오름차순 정렬
        long min = Long.MAX_VALUE;
        int start=0; //시작 인덱스
        int end=1; //끝 인덱스
        while(end<n){
            if(a[end]-a[start]==m){ //차이가 m인 경우
                min = m; //차이는 m
                break; //종료
            }
            else if(a[end]-a[start]>m){ //차이가 m보다 큰 경우
                min = Math.min(min,a[end]-a[start]); //차이 비교 후 저장
                start++;
            }
            else{
                end++;
            }
        }
        System.out.println(min);
    }
}