import java.io.*;
import java.util.*;

public class Main {
    static int n, s, count = 0;                     // 정수의 개수, 만족해야하는 정수, 부분수열의 개수
    static int[] num;                               // 수열을 저장할 배열
    public static void dfs(int sum, int depth) {    // 탐색하는 함수
        if(depth == n) {                            // 끝까지 탐색했을 경우 return
            return;
        } else {
            if(sum + num[depth] == s) {             // 해당 값이 s에 만족할 경우 count 증가
                count++;
            }
        }
        dfs(sum, depth+1);                    // 이번 정수를 더하지 않기
        dfs(sum + num[depth], depth+1);  // 이번 정수 더하기
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());              // 정수의 개수 입력
        s = Integer.parseInt(stk.nextToken());              // 만족해야하는 수 입력

        num = new int[n];                                   // 배열 초기화
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {                        // 수열을 배열에 저장
            num[i] = Integer.parseInt(stk.nextToken());
        }

        dfs(0, 0);                               // 탐색 시작

        System.out.println(count);                          // 결과값 출력
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}