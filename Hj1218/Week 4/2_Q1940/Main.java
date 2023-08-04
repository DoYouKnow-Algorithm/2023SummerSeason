import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //재료의 개수 n
        int m = in.nextInt(); //갑옷을 만드는데 필요한 수 m
        int []num = new int[n]; //재료들이 가진 고유 번호
        for(int i=0;i<n;i++){
            num[i]=in.nextInt();
        }
        Arrays.sort(num); //오름차순 정렬
        int start = 0; //시작 인덱스
        int end = n-1; //끝 인덱스
        int count = 0; //만들 수 있는 갑옷 개수
        while(start<end){
            int sum = num[start]+num[end];
            if(sum<m){ //번호의 합이 m보다 작은 경우
                start++;
            }
            else { //번호의 합이 m보다 크거나 같은 경우
                if(sum==m){ //번호의 합이 m인 경우
                    count++; //개수 증가
                }
                end--;
            }
        }
        System.out.println(count);
    }
}