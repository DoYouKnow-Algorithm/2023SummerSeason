
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){ // 수열 입력받기
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 오름차순 정렬
        int left = 0, right=0, ans = Integer.MAX_VALUE;
        while(left<=right && right<n){
            if(arr[right]-arr[left]>=m){ // 두 수의 차가 m보다 크거나 같다면
                ans = Math.min(ans, arr[right]-arr[left]); // 차의 최솟값 구하기
                left++;
            }
            else{
                right++;
            }
        }
        System.out.println(ans);
    }
}
