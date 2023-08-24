
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수의 개수
        int [] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num); //정렬
        int [] ans = new int[6];
        int k = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(k==6) break; // 작은 수를 만들기 위해 6개까지 조합
                ans[k++] = Integer.parseInt(num[i]+""+num[j]);
                ans[k++] = Integer.parseInt(num[j]+""+num[i]);
            }
        }
        Arrays.sort(ans); // 정렬
        System.out.println(ans[2]); // 3번째로 작은 수 출력
    }
}
