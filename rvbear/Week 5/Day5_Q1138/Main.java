import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());                            // 사람의 수
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] count = new int[n];                                           // 자기보다 큰 사람의 수를 저장할 배열
        ArrayList<Integer> arrayList = new ArrayList<>();                   // 결과를 저장할 배열

        for(int i = 0; i < n; i++) {
            count[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = n; i > 0; i--) {
            int index = count[i-1];                                         // count 배열에 저장된 값이 index가 됨
            arrayList.add(index, i);
        }

        for(int high : arrayList) {                                         // 결과값 출력
            System.out.print(high + " ");
        }
        br.close();
    }
}