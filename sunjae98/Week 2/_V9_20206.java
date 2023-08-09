import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken()); // x 최소
        double x2 = Double.parseDouble(st.nextToken()); // x 최대
        double y1 = Double.parseDouble(st.nextToken()); // y 최소
        double y2 = Double.parseDouble(st.nextToken()); // y 최대

        // y = (Ax + C) / -B
        // X = (By + C) / -A
        // 4개의 연산
        double calY1 = ((A * x1) + C) / (-1 * B);
        double calY2 = ((A * x2) + C) / (-1 * B);
        double calX1 = ((B * y1) + C) / (-1 * A);
        double calX2 = ((B * y2) + C) / (-1 * A);

        //위험 지역에 속하는지 확인
        String result = "Lucky";

        // y 범위 확인
        if ((y1 < calY1 && calY1 < y2) || (y1 < calY2 && calY2 < y2)) {
            result = "Poor";
        }

        // x 범위 확인
        if ((x1 < calX1 && calX1 < x2) || (x1 < calX2 && calX2 < x2)) {
            result = "Poor";
        }
        System.out.print(result);
    }
}
