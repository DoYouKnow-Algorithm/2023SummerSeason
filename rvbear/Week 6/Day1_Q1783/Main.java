import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());          // 세로 길이
        int m = Integer.parseInt(stk.nextToken());          // 가로 길이
        
        // 세로칸을 기준으로 각각의 조건을 나눔
        if(n == 1) {                                        // 1칸일 경우 이동 불가
            System.out.println(1);
        } else if(n == 2) {                                 // 2칸일 경우 2, 3번으로만 이동 가능, 4가지 방법을 다 사용하지 못함
            System.out.println(Math.min((m+1)/2, 4));
        } else {
            if(m < 7) {                                     // 세로가 3칸 이상이면서 가로가 7칸 이하일 경우, 4가지 방법을 다 사용하지 못함
                System.out.println(Math.min(4, m));
            } else {                                        // 4가지 방법을 다 사용하는 경우
                System.out.println(m-2);
            }                                               
        }                                                   

        br.close();
    }
}