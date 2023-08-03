package Week4;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //재료의 개수
        int M = Integer.parseInt(br.readLine());    //갑옷을 만드는데 필요한 수
        int[] arr = new int[N];
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  //재료들이 가진 번호 저장
        }

        Arrays.sort(arr);   //오름차순으로 정렬
        int start = 0, end = N-1;   //시작에 0, 끝에 마지막 인덱스 저장
        while (start != end) {  //시작 인덱스와 끝 인덱스가 같아지면 종료
            if (arr[start] + arr[end] <= M) {   //arr의 값을 더한 값이 M보다 작거나 같을때
                if (arr[start] + arr[end] == M) count++;    //같으면 count+1
                start++;    //start+1
            } else {
                end--;  //더한 값이 M보다 크면 end-1
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
