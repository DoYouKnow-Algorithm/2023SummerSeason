package silver._2.Q6600;

import java.io.*;
import java.util.*;

public class Main {
    public static double cal(double x, double y) {          // 선분의 길이 구하는 함수
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력
        StringTokenizer stk;

        String Line = "";
        while((Line = br.readLine()) != null && !Line.isEmpty()) {          // eof가 입력될 경우 && enter가 두번 쳐질 경우 while문 종료
            stk = new StringTokenizer(Line);                                // 값을 받아서 각각 넣어줌
            double x1 = Double.parseDouble(stk.nextToken()), y1 = Double.parseDouble(stk.nextToken()),
                    x2 = Double.parseDouble(stk.nextToken()), y2 = Double.parseDouble(stk.nextToken()),
                    x3 = Double.parseDouble(stk.nextToken()), y3 = Double.parseDouble(stk.nextToken());
            double d = cal(x3-x2, y3-y2);                             // 한 선분의 길이를 구해줌
            // 답을 구하기 위해 사용한 공식 : 2r*PI = 한 선분의 길이 / sin(마주보는 각) * PI
            // theta를 구하기 위한 공식 : 벡터 a와 b의 내적 = 벡터 a의 크기 * 벡터 b의 크기 * cos(theta)
            //                        즉, cos(theta) = 벡터 a와 b의 내적 / (벡터 a의 크기 * 벡터 b의 크기)
            double theta = Math.acos(((x3-x1)*(x2-x1) + (y3-y1)*(y2-y1)) / (cal(x3-x1, y3-y1) * cal(x2-x1, y2-y1)));
            double circle = d/Math.sin(theta) * Math.PI;                    // 원주 구함
            bw.write(String.format("%.2f", circle) + "\n");             // 해당 값을 버퍼에 저장
        }

        br.close();         // 입력 버퍼 스트림 닫아줌
        bw.close();         // 출력 버퍼 스트림 닫아줌
    }
}