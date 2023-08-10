import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = "";

        //입력이 없거나 비어있을때까지 반복
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            st = new StringTokenizer(str);

            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());

            //삼각형 세 변의 길이
            double dis1 = distance(x1, y1, x2, y2);
            double dis2 = distance(x1, y1, x3, y3);
            double dis3 = distance(x2, y2, x3, y3);

            double s = (dis1 + dis2 + dis3) / 2; // 삼각형 둘레의 절반
            double A = Math.sqrt(s * (s - dis1) * (s - dis2) * (s - dis3)); // 삼각형의 넓이
            double R = (dis1 * dis2 * dis3) / (4 * A); // 반지름
            double C = 2 * R * Math.PI; // 원주
            C = Math.round(C * 100) / 100.0; // 출력형식에 맞게 반올림

            System.out.println(C);
        }
    }

    //두 점의 거리를 구하는 함수
    public static double distance(double a, double b, double c, double d) {
        double dis;
        double m = (c - a) * (c - a);
        double n = (d - b) * (d - b);

        return dis = Math.sqrt(m + n);
    }

}
