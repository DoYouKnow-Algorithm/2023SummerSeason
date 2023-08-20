package Week6;

import java.io.*;
import java.util.StringTokenizer;

public class _1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //N*M의 체스판 주어짐
        int N = Integer.parseInt(st.nextToken());   //세로 길이
        int M = Integer.parseInt(st.nextToken());   //가로 길이

        int count = 0;  //방문한 칸의 수
        if (N == 1) {
            count = 1;
        } else if (N == 2) {
            //M<=6일때와 M>7인 경우로 나눠지고, 4번이 최대 이동임
            count = M <= 6 ? (M + 1) / 2 : 4;
        } else {
            //M<7이면 최대가 4이고, M이 7일때부터는 M-2가 정답(M==7에서 가로 5칸 사용)
            count = M < 7 ? Math.min(M, 4) : M - 2;
        }
        bw.write(String.valueOf(count));
        bw.close();

    }
}
