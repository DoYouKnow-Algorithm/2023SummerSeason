package Week5;

import java.awt.font.OpenType;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = N; i > 0; i--) {
            //arr 배열의 값 = 인덱스의 값(같은 값이라면 뒤로 하나씩 밀려남)
            list.add(arr[i - 1], i);
        }

        for(int a:list){
            bw.write(String.valueOf(a)+" ");
        }
        bw.write("\n");
        bw.close();
    }
}
