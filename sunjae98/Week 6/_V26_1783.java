import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        int result = 0; // 방문한 칸 수

        // 세로 길이를 기준으로 1차 필터링
        if (N == 1) { // 1. 세로 길이 == 1 -> 이동 불가
            result = 1;
        } else if (N == 2) { // 2. 세로 길이 == 2 -> 2,3 조건만 이용가능
            result = Math.min(4, (M + 1) / 2); // 가로 길이가 7이상 -> 이동 횟수가 4번 이상 -> 조건 위배
        } else {
            if (M < 7) { // 1. 가로 길이 7 미만 -> 모든 조건 1번씩 사용 안해도 됌
                result = Math.min(4, M);
            } else { // 2. 가로 길이가 7 이상 -> 1,2,3,4조건 사용 후에 1,4 조건 최대한 사용
                result = M - 2; // 2,3 조건은 2칸 이동이므로 2를 빼줌
            }
        }
        System.out.print(result);
    }
}
