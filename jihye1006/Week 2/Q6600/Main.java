

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }

            String[] input = str.split(" ");
            double x1, y1, x2, y2, x3, y3;

            //각 변수에 대입
            x1 = Double.parseDouble(input[0]);
            y1 = Double.parseDouble(input[1]);
            x2 = Double.parseDouble(input[2]);
            y2 = Double.parseDouble(input[3]);
            x3 = Double.parseDouble(input[4]);
            y3 = Double.parseDouble(input[5]);

            double d = hypot(x3 - x2, y3 - y2);

            // 두 벡터 (x2-x1, y2-y1)와 (x3-x1, y3-y1) 사이의 각도 계산
            double ax = x2 - x1;
            double ay = y2 - y1;
            double bx = x3 - x1;
            double by = y3 - y1;
            double theta = Math.acos((ax * bx + ay * by) / hypot(ax, ay) / hypot(bx, by));

            // 원의 지름을 구하기 위해 d를 theta의 사인으로 나누고, 원주 구하기
            double result = d / Math.sin(theta) * Math.PI;
            System.out.printf("%.2f\n", result); //소수점 둘째자리까지 반올림하여 출력
        }
    }

    private static double hypot(double x, double y) { // 두 점 사이의 거리를 계산하는 메서드
        return Math.sqrt(x * x + y * y);
    }
}

