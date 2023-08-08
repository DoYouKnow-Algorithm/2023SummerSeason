import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());              // 인형의 개수
        int k = Integer.parseInt(stk.nextToken());              // 최소 연속된 개수
        ArrayList<Integer> arrayList = new ArrayList<>();       // 인형들을 저장할 배열
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            if (Integer.parseInt(stk.nextToken()) == 1) {
                arrayList.add(i);                               // 라이언 인형일 경우 배열에 저장
            }
        }

        if(arrayList.size() < k) {                              // 배열의 크기가 최소 개수를 못 넘길 경우
            System.out.println(-1);                             // 만들 수 없는 집합이므로 -1 출력
        } else {
            int start = 0, end = k-1, min = 1_000_001;          // 시작값, 종료값, 최솟값
            while(end < arrayList.size()) {                     // end 값이 배열의 크기보다 작을 경우 반복
                // 길이 = 끝지점 - 처음지점 + 1
                int count = arrayList.get(end) - arrayList.get(start) + 1;
                min = Math.min(min, count);                     // 최소 길이를 구함
                start++; end++;                                 // 포인터 이동
            }
            System.out.println(min);                            // 최솟값 출력
        }

        br.close();                                             // 입력 버퍼 스트림 닫아줌
    }
}