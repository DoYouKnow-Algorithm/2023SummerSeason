package silver._2.Q18187;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        int n = Integer.parseInt(br.readLine());        // 선의 개수
        int[] dp = new int[n+2];                        // dp 배열
        dp[1] = 2; dp[2] = 4;                           // dp 초깃값 설정
        int plus = 3;                                   // 더해지는 숫자

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+plus;                       // 점화식
            if(i%3 != 0) {                              // 3의 배수가 아닐 경우 plus 값 증가
                plus++;
            }
        }

        System.out.println(dp[n]);                      // 결과값 출력
        br.close();                                     // 입력 버퍼 스트림 닫아줌
    }
}