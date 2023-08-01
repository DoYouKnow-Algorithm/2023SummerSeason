package Week3;

import java.io.*;
import java.util.StringTokenizer;

public class _1182 {
    static int N, S, count = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //정수 개수
        S = Integer.parseInt(st.nextToken());   //다 더한 값이 S
        arr = new int[N];   //수열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {   //수열 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);  //깊이 우선 탐색

        if(S==0) count--;   //빈 부분 집합도 카운트하기 때문에

        bw.write(String.valueOf(count));
        bw.close();
    }

    static void dfs(int cnt, int sum) {
        if (cnt == N) {
            if (sum == S) {
                count++;    //더한 값이 S이면 count+1
            }
            return;
        }

        dfs(cnt + 1, sum + arr[cnt]);   //지금 숫자 더함
        dfs(cnt + 1, sum);  //지금 숫자 넘어감
    }
}
