
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start=0, end=0; //투포인터
        int sum=0, count=0; //합, 정답 개수
        while(start<n){
            while(++end<=n){ //end 증가
                sum += end; //부분합 증가
                if(sum>=n){
                    if(sum==n) count++;
                    break;
                }
            }
            while(++start<=n){ //start 증가
                sum -= start; //부분합 감소
                if(sum<=n){
                    if(sum==n) count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
