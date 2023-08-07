import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n,m,count;
    static int []a;
    static int []b;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); //테스트 케이스 개수 t
        for(int i=0;i<t;i++){
            n = in.nextInt(); //a의 수
            m = in.nextInt(); //b의 수
            a = new int[n];
            b = new int[m];
            for(int j=0;j<n;j++){
                a[j]=in.nextInt(); //a의 크기
            }
            for(int k=0;k<m;k++){
                b[k]=in.nextInt(); //b의 크기
            }
            Arrays.sort(b); //b 오름차순 정렬
            count=0; //count 초기화
            check(0);
            System.out.println(count);
        }
    }
    static void check(int num){
        if(num==n){ //a를 모두 탐색하면
            return; //종료
        }
        int start = 0; //시작 인덱스
        int end = m-1; //끝 인덱스
        int index = 0; //기준 인덱스
        while(start<=end){
            if(a[num]>b[(start+end)/2]){
                start = (start+end)/2 + 1;
                index = start; //인덱스 저장
            }
            else{
                end = (start+end)/2 - 1;
            }
        }
        count+=index; //count에 저장한 인덱스 값을 더해줌 (index가 2인 경우 a보다 작은 b의 개수 = 2)
        check(num+1);
    }
}