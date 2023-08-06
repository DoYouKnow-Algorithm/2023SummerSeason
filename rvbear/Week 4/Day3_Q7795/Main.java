import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력
        StringTokenizer stk;
        int t = Integer.parseInt(br.readLine());            // testcase 수 입력

        for(int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());      // A의 수
            int m = Integer.parseInt(stk.nextToken());      // B의 수
            int[] a = new int[n];
            int[] b = new int[m];

            stk = new StringTokenizer(br.readLine());       // A의 값 입력
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(stk.nextToken());
            }
            stk = new StringTokenizer(br.readLine());       // B의 값 입력
            for(int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(stk.nextToken());
            }

            Arrays.sort(b);                                 // B 정렬
            int count = 0;                                  // 쌍의 개수

            for(int j = 0; j < n; j++) {                    // 이진 탐색 시작
                int start = 0, end = m-1, index = 0;
                while(start <= end) {
                    int mid = (start+end) / 2;
                    if(b[mid] < a[j]) {                     // b 배열의 중간값이 원하는 값보다 작다면
                        start = mid + 1;                    // 탐색 시작 지점을 중간값 + 1로 설정
                    } else {                                // 아니라면
                        end = mid - 1;                      // 탐색 종료 지점을 중간값 - 1로 설정
                    }
                }
                count += start;                             // start 값이 탐색이 끝났을 당시 쌍의 개수를 나타냄
            }
            bw.write(String.valueOf(count) + "\n");
        }

        br.close();                                         // 입력 버퍼 스트림 닫아줌
        bw.close();                                         // 출력 버퍼 스트림 닫아줌
    }
}