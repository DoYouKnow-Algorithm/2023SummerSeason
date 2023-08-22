import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());              // 약속의 개수
        int m = Integer.parseInt(stk.nextToken());              // 방학의 일수
        int[] happy = new int[n];
        stk = new StringTokenizer(br.readLine());
        int sumHappy = 0;                                       // 행복감의 합

        for(int i = 0; i < n; i++) {
            happy[i] = Integer.parseInt(stk.nextToken());
            sumHappy += happy[i] + 1;
        }

        int daySad = m - sumHappy;                              // 우울함을 느끼는 날
        if(daySad <= 0) {                                       // 방학 일수가 행복감의 합보다 작을 경우 0을 출력
            System.out.println(0);
        } else {
            int sumSad = 0;                                     // 우울함의 합
            int temp = daySad/(n+1);                            // 구간 사이에 들어갈 우울함을 느끼는 날
            for(int i = 1; i <= temp; i++) {                    // 우울함의 정도를 계산하여 저장
                sumSad += (int)Math.pow(i, 2);
            }
            sumSad *= n+1;                                      // 구간만큼 곱해줌
            sumSad += Math.pow(temp+1, 2) * (daySad % (n+1));   // 남은 우울함을 느끼는 날을 각 구간에 적절하게 배치
            System.out.println(sumSad);                         // 나온 모든 우울함의 합을 출력
        }

        br.close();
    }
}