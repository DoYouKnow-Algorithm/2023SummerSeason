import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());              // 수의 개수
        long m = Long.parseLong(stk.nextToken());               // 수의 차이
        long[] arr = new long[n];                               // 수를 저장할 배열

        for(int i = 0; i < n; i++) {                            // 배열에 값을 저장
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);                                       // 배열 정렬

        int start = 0, end = 0;                                 // 시작점, 마지막점
        long min = 2_000_000_000;                               // 가장 작은 차이
        while(end < n) {
            if(arr[end]-arr[start] < m) {                       // 선택된 수의 차이가 m보다 작을 경우 end 증가 후 continue
                end++;
                continue;
            }
            min = Math.min(min, arr[end]-arr[start]);           // 최솟값을 비교하여 더 작은 값을 선택
            if(min == m) {                                      // min값이 수의 차이와 같을 경우 더 비교할 필요없이 break
                break;
            }
            start++;                                            // start 증가
        }

        System.out.println(min);                                // 최솟값 출력
        br.close();                                             // 입력 버퍼 스트림 닫아줌
    }
}