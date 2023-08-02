import java.io.*;
import java.util.*;

public class Main {
    static int k;                                               // 부등호의 개수
    static char[] sign;                                         // 부등호 저장 배열
    static boolean[] visit = new boolean[10];                   // 방문 여부 확인
    static ArrayList<String> arrayList = new ArrayList<>();     // 해당 부등호에 성립하는 숫자들을 문자열로 저장
    public static boolean check(int a, int b, char c) {         // 해당 숫자와 부등호가 성립하는지 확인하는 함수
        if(c == '<' && a < b) {
            return true;
        } else if(c == '>' && a > b) {
            return true;
        }
        return false;
    }
    public static void dfs(int depth, int last, String add) {   // dfs 탐색 시작
        if(depth == k+1) {                                      // 해당 조건에 맞을 경우 배열에 저장
            arrayList.add(add);
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(visit[i]) continue;                              // 방문했을 경우 넘어감
            if(depth == 0 || check(last, i, sign[depth])) {     // 첫 탐색이거나 check 함수가 성립할 경우
                visit[i] = true;                                // 방문여부 true로
                 dfs(depth+1, i, add+i);             // 재귀호출로 dfs 탐색 진행
                visit[i] = false;                               // 방문여부 false로
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        k = Integer.parseInt(br.readLine());
        sign = new char[k+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= k; i++) {                           // 부등호 저장
            sign[i] = stk.nextToken().charAt(0);
        }

        dfs(0, 0, "");                          // dfs 탐색 시작

        Collections.sort(arrayList);                            // 배열을 정렬
        System.out.println(arrayList.get(arrayList.size()-1));  // 최댓값 출력
        System.out.println(arrayList.get(0));                   // 최솟값 출력
        br.close();                                             // 입력 버퍼 스트림 닫아줌
    }
}