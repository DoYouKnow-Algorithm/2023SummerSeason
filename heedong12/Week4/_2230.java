package Week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //숫자 개수
        long M = Integer.parseInt(st.nextToken());   //M 이상의 차이
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);   //오름차순으로 정렬
        int start = 0, end = 0;
        long answer = Long.MAX_VALUE;

        while (end<N) {
            if (arr[end] - arr[start] == M) {//M 차이라면 종료
                answer = M;
                break;
            }
            if (arr[end] - arr[start] < M) {    //차이가 M보다 작으면
                end++;  //end+1
            } else if (arr[end] - arr[start] > M) { //차이가 M보다 크면
                answer = Math.min(arr[end] - arr[start],answer); //비교 후 작은 값을 answer에 저장 후
                start++;    //start+1
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
