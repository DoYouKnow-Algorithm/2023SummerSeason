package Week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7795 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());    //테스트 케이스 개수

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //A의 수
            int M = Integer.parseInt(st.nextToken());   //B의 수
            int[] arrA = new int[N];
            int[] arrB = new int[M];
            int count = 0;  //쌍의 개수

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {   //A의 크기 저장
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {   //B의 크기 저장
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrB);

            for (int i = 0; i < N; i++) {   //arrA의 인덱스
                for (int j = 0; j < M; j++) {   //arrB의 인덱스
                    if(arrA[i]>arrB[j]) count++;    //A가 B를 먹을 수 있는 경우
                    //A가 B를 먹을 수 없음. arrB를 정렬해뒀기 때문에 더이상 작은 수 나오지 않으니까 종료
                    if(arrA[i]<=arrB[j]) break;
                }
            }

            bw.write(String.valueOf(count+"\n"));
            T--;
        }
        bw.close();
    }
}
