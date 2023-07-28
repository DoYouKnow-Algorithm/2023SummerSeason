package silver._2.Q1709;

import java.io.*;

public class Main {
    static long area;
    public static boolean check(long x, long y) {             // 원의 둘레가 지나가는지 여부
        return (x-1)*(x-1)+(y-1)*(y-1) < area && x*x + y*y > area;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        int n = Integer.parseInt(br.readLine());            // 한 변의 길이
        int radius = n/2;                                   // 반지름
        area = (long)radius*radius;                               // 원의 넓이
        int temp = 1;                                       // x의 시작
        int count = 0;                                      // 둘레가 지나는 사각형의 개수

        for(int y = radius; y >= 0; y--) {                  // 1사분면 탐색
            for(int x = temp; x <= radius; x++) {
                if(check(x, y)) {                           // check()를 만족한다면
                    count++;                                // 개수 증가
                    temp = x;                               // temp 바꾸기
                } else {
                    if(x != temp) {                         // 만족하지 않는다면
                        temp = x-1;                         // temp 값 변경
                        break;
                    }
                }
            }
        }

        System.out.println(count*4);                        // 값 출력하기
        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}