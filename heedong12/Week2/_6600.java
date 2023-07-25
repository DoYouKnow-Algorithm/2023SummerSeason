package Week2;

import java.io.*;
import java.util.StringTokenizer;

public class _6600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer("");

        double arr[] = new double[6];   //세 점 저장
        String input = "";
        //입력 값이 null이거나 비어있으면 종료
        while ((input=br.readLine())!=null && !input.isEmpty()) {
            st = new StringTokenizer(input);

            for (int i = 0; i < 6; i++) {   //배열에 세 점 저장
                arr[i] = Double.parseDouble(st.nextToken());
            }
            //점 사이의 거리 구하기
            double d1 = distance(arr[2], arr[0], arr[3], arr[1]);
            double d2 = distance(arr[4], arr[2], arr[5], arr[3]);
            double d3 = distance(arr[4], arr[0], arr[5], arr[1]);

            double s = (d1 + d2 + d3) / 2;  //삼각형의 반 둘레
            double A = Math.sqrt(s * (s - d1) * (s - d2) * (s - d3));   //삼각형의 넓이
            double R = (d1 * d2 * d3) / (4 * A);    //원의 반지름
            double C = 2 * Math.PI * R;     //원의 둘레
            C = Math.round(C * 100) / 100.0;    //소수점 둘째 짜리까지 반올림

            bw.write(String.valueOf(C + "\n"));
        }

        bw.close();

    }
    //거리 계산을 위한 메소드
    static double distance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
