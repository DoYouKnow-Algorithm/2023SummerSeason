package Week6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _5619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //수의 개수
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);   //오름차순으로 정렬

        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.min(4, N);   //최대 4개까지만 비교하면 됨

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (i != j) {   //다른 수끼리 비교해야되니까
                    String s="";
                    //더해서 list에 추가
                    list.add(Integer.parseInt(s+arr[i]+arr[j]));
                }
            }
        }
        Collections.sort(list);     //list 오름차순으로 정렬
        bw.write(String.valueOf(list.get(2)));  //3번째로 큰 수 출력
        bw.close();
    }
}
