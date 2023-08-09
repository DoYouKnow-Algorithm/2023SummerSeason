package Week4;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class _15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //인형 개수
        int K = Integer.parseInt(st.nextToken());   //라이언 인형 K개
        int[] arr = new int[N];
        ArrayList<Integer> lion = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {   //인형 저장 -> 1이 라이언
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) lion.add(i);  //라이언 인덱스 저장
        }

        int start = 0, end = 0;
        int len = Integer.MAX_VALUE;

        if (lion.size() < K) {  //라이언 인형이 K개 이하라면 -1 출력
            len = -1;
        } else {
            while (end < lion.size() - 1) {
                end = start + K-1;  //start와 end 사이에 라이언 인형 K개
                len = Math.min(len, lion.get(end) - lion.get(start)+1); //최소 길이 저장
                start++;    //start 인덱스 하나 증가
            }
        }
        bw.write(String.valueOf(len));
        bw.close();
    }
}
