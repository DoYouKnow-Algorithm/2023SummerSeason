import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        // 인형 일렬로 놓기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0; // 집합에 포함된 라이언 인형의 수
        int size = 0; // 집합의 사이즈
        int min = Integer.MAX_VALUE;
        int s = 0; // start 포인터
        int e = 0; // end 포인터
        boolean sflag = false; // start 포인터 상태
        boolean eflag = true; // end 포인터 상태

        // 라이언 인형이 시작되는 인덱스에서 포인터 시작
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                s = i;
                e = i;
                break;
            }
        }

        while (s < N && e < N) { // 두 포인터가 배열을 넘기 전까지 반복
            if (eflag && arr[e] == 1) { // e 포인터를 증가시키면서 라이언을 만나면
                cnt++;
                if (cnt == K) { // 라이언의 개수가 K개가 되면
                    eflag = false; // e 포인터를 멈추고
                    sflag = true; // s 포인터를 활성화
                    cnt--; // 라이언의 개수를 하나 줄임
                    size = e - s + 1; // 사이즈 = 포인터의 차 + 1
                    min = Math.min(size, min); // 최소값 갱신
                }
            } else if (sflag && arr[s] == 1) { // s 포인터를 증가시키면서 라이언을 만나면
                sflag = false; // s 포인터를 멈추고
                eflag = true; // e 포인터를 활성화
            }
            //포인터가 활성화된 상태라면 인덱스를 증가시킴
            if (sflag) {
                s++;
            } else
                e++;
        }
        if (min == Integer.MAX_VALUE) // 집합이 없다면 -1을 출력
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
