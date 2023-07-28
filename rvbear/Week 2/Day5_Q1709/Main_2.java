package silver._2.Q1709;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        long n = Long.parseLong(br.readLine());             // 반지름
        n /= 2;

        long x = 0, y = n-1, count = 0;                     // x, y의 시작좌표, 원의 둘레가 지나가는 칸의 개수
        while(x <= n && y >= 0) {                           // 1사분면만 탐색
            long dif = (x+1)*(x+1) + y*y;                   // (x+1, y)의 길이
            if(dif <= n*n) {                                // 원주 안에 있을 경우
                x++;                                        // x 증가
            }
            if(dif >= n*n) {                                // 원주 밖에 있을 경우
                y--;                                        // y 감소
            }
            count++;                                        // 칸의 개수 증가
        }

        System.out.println(count*4);                        // 1사분면 탐색 결과 * 4
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}