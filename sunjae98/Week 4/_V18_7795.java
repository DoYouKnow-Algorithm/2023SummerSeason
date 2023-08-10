import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // A의 개수
            int M = Integer.parseInt(st.nextToken()); // B의 개수
            int[] A = new int[N]; // A의 크기를 저장할 배열
            int[] B = new int[M]; // B의 크기를 저장할 배열

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A); // 오름차순 정렬

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B); // 오름차순 정렬

            int result = 0;
            for (int k = 0; k < N; k++) {
                int index = 0; // 탐색이 끝났을 때 결과
                int start = 0;
                int end = M - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (A[k] > B[mid]) {    // A깂이 B보다 클 때의 (B의 인덱스+1 ) => A보다 작은 B값의 개수
                        index = mid + 1;
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                result += index;
            }
            System.out.println(result);
        }
    }
}
