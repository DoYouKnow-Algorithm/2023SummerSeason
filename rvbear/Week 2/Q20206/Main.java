package silver._1.Q20206;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(stk.nextToken());          // a의 값
        int b = Integer.parseInt(stk.nextToken());          // b의 값
        int c = Integer.parseInt(stk.nextToken());          // c의 값

        stk = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(stk.nextToken());         // 첫번째 x 좌표
        int x2 = Integer.parseInt(stk.nextToken());         // 두번째 x 좌표
        int y1 = Integer.parseInt(stk.nextToken());         // 첫번째 y 좌표
        int y2 = Integer.parseInt(stk.nextToken());         // 두번째 y 좌표

        // by = -ax - c로 변환하여 좌변 우변을 각각 계산
        int r1 = -1 * a * x1 - c;
        int r2 = -1 * a * x2 - c;
        int passMax = r1 > r2 ? r1 : r2;                    // 우변을 계산하여 큰 값
        int passMin = r1 > r2 ? r2 : r1;                    // 우변을 계산하여 작은 값

        r1 = b * y1;
        r2 = b * y2;
        int dangerMax = r1 > r2 ? r1 : r2;                  // 좌변을 계산하여 큰 값
        int dangerMin = r1 > r2 ? r2 : r1;                  // 좌변을 계산하여 작은 값

        if(dangerMax <= passMin || dangerMin >= passMax) {  // 좌변의 큰 값이 우변의 작은 값보다 작다면 혹은 그 반대라면 Lucky
            System.out.println("Lucky");
        } else {                                            // 그 외의 경우 Poor
            System.out.println("Poor");
        }

        br.close();                                         // 입력 버퍼 스트림 닫아줌
    }
}