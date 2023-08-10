
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //재료의 개수
        int m = Integer.parseInt(br.readLine()); //갑옷 만들 때 필요한 수

        int[] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); //재료 고유 번호
        }

        int count =0; // 정답 개수
        for(int j=0; j<n; j++){
            int sum=0;
            int end = j+1;

            while(end<n){
                sum = arr[j];
                sum+= arr[end++]; // 부분합 증가
                if(sum==m){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
