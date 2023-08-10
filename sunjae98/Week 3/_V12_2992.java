import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num; // 숫자
    static String s; // 자리수
    static int n; // 자릿수 개수
    static int min = Integer.MAX_VALUE;// 최솟값
    static int[] arr, compare;
    static boolean[] visited; // 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        num = Integer.parseInt(s); // 문자열 -> 정수 변환
        n = s.split("").length;
        arr = new int[n];
        compare = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) { // 숫자를 한자리씩 쪼개서 배열에 저장
            arr[i] = Integer.parseInt(s.split("")[i]);
        }
        dfs(0); // dfs

        if (min == Integer.MAX_VALUE) { // 최솟값이 변하지 않음
            System.out.print(0); // 0출력
        } else {
            System.out.print(min);
        }
    }

    public static void dfs(int depth) {
        if (depth == n) { // 자리수가 같아지면
            String s = "";
            for (int i = 0; i < n; i++) { // s에 한글자씩 더해서 저장
                s += compare[i];
            }
            int n = Integer.parseInt(s); // 문자열 -> 정수
            if (num < n) { // 입력값보다 큰 수 중에서 가장 작은 수 찾기
                min = Math.min(min, n);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문하지 않았다면
                visited[i] = true; // 방문 해주고
                compare[depth] = arr[i]; // 해당 숫자를 비교대상에 넣어줌
                dfs(depth + 1); // 다음숫자 탐색
                visited[i] = false; // 방문 안함으로 바꿈
            }
        }
    }
}
