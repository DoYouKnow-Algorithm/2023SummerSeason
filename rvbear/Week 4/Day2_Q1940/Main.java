import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        int n = Integer.parseInt(br.readLine());                    // 숫자의 개수
        int m = Integer.parseInt(br.readLine());                    // 만들어야하는 숫자
        int[] num = new int[n];                                     // 숫자를 저장할 배열
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {                                // 배열에 값을 저장
            num[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(num);                                           // 배열을 오름차순으로 정렬
        int start = 0, end = n-1, count = 0;                        // 시작 포인터, 마지막 포인터, 만들어지는 개수 카운트
        while(start != end) {                                       // 시작 포인터와 마지막 포인터가 다를 경우 종료
            if(num[start] + num[end] <= m) {                        // 두 포인터가 가르키는 곳의 합이 m보다 작거나 같을 경우 중
                if(num[start] + num[end] == m) {                    // 두 포인터가 가르키는 곳의 합이 m보다 같을 경우 count 증가
                    count++;
                }
                start++;                                            // start 증가
            } else {                                                // 두 포인터가 가르키는 곳의 합이 m보다 클 경우
                end--;                                              // end 감소
            }
        }

        System.out.println(count);                                  // 결과값 출력
        br.close();                                                 // 입력 버퍼 스트림 닫아줌
    }
}