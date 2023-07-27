package silver._4.Q5568;

import java.io.*;
import java.util.*;

public class Main {
    static int n, k;                                 // 카드의 개수, 카드 선택 개수
    static String[] arr;                             // 카드 저장할 배열
    static HashSet<String> set = new HashSet<>();    // 중복제거를 위한 HashSet
    static boolean[] visit;                          // 방문여부 확인 배열
    static void check(int count, String add) {       // HashSet에 값을 넣는 함수
        if(count == k) {                             // 카드 선택 개수가 됐을 경우
            set.add(add);                            // HashSet에 값을 넣어줌
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;                   // 방문을 했을 경우 continue
            visit[i] = true;                         // 방문 했음을 표시
            check(count+1, add + arr[i]); // 재귀 함수
            visit[i] = false;                        // 방문 여부 취소
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        n = Integer.parseInt(br.readLine());        // 값을 넣어줌
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        visit = new boolean[n];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        check(0, "");                   // 함수 호출
        System.out.println(set.size());           // set 사이즈 출력
        br.close();                               // 입력 버퍼 스트림 닫아줌
    }
}