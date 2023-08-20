import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] location = new int[N + 1]; // 위치
        int left_num; // 나보다 큰 왼쪽에 있는 사람 수

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { // 키
            left_num = Integer.parseInt(st.nextToken());

            // key point : left_num == 0 이라면 줄 설 준비가 된 것
            for (int j = 1; j <= N; j++) { // 위치
                if (left_num == 0) { // 1. 자기보다 작은 사람이 없음
                    if (location[j] == 0) { // 2-1. 해당 위치가 비어 있음
                        location[j] = i; // 위치 저장
                        break; // 다음 사람 줄 세우기
                    } else { // 2-2. 해당 위치가 차있음
                        continue; // 다음 위치로 이동
                    }
                } else { // left_num != 0
                    if (location[j] == 0) // 자리가 비어있음
                        left_num--;
                }
            }
        }

        // 줄 세운 순서대로 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(location[i] + " ");
        }
    }
}
