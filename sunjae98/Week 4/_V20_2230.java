import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        // 수열을 배열에 담음
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 오름차순 정렬

        int s = 0; // start 포인터
        int e = 0; // end 포인터
        int sub = 0; // 두 수열의 차이
        int min = Integer.MAX_VALUE; // 최솟값

        while (s < N && e < N) { // 두 포인터가 배열을 넘어가기 전까지 반복
            sub = arr[e] - arr[s]; // 수열의 차를 초기화
            if (sub < M) { // 차이가 M 보다 적다면
                e++; // e 포인터 이동
            } else if (sub > M) { //  차이가 M 보다 크다면
                min = Math.min(sub, min); // 조건에 부합하므로 최솟값을 갱신
                s++; // s 포인터 이동
            } else { // 차이가 M 과 같다면
                min = M; // 최솟값이므로
                break; // 반복문을 빠져나감
            }
        }

        if (min == Integer.MAX_VALUE) { // 차이가 0 일때
            System.out.print(0); // 0을 출력
        } else {
            System.out.print(min);
        }
    }
}
