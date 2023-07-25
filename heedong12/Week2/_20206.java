package Week2;

import java.io.*;
import java.util.StringTokenizer;

public class _20206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        //Ax+By+C=0 -> By=-Ax-C
        //각 x값 대입
        int t1 = -1 * A * x1 - C;
        int t2 = -1 * A * x2 - C;
        //통과할 수 있는 범위 구함
        int passMinY = t1 < t2 ? t1 : t2;
        int passMaxY = t1 > t2 ? t1 : t2;
        //위의 방법과 똑같이 y값 대입
        t1 = B * y1;
        t2 = B * y2;
        //위험범위 구함
        int dangerMinY = t1 < t2 ? t1 : t2;
        int dangerMaxY = t1 > t2 ? t1 : t2;
        //최솟값 >= 위험범위 최대 y값이거나
        //최댓값 <= 위험범위 최소 y값이면 통과
        String answer = passMinY >= dangerMaxY || passMaxY <= dangerMinY ? "Lucky" : "Poor";

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
