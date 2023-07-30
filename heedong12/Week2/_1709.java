package Week2;

import java.io.*;

public class _1709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //한 변의 길이를 2로 나눔 -> 1사분면만 검사하기 위해
        double N = Double.parseDouble(br.readLine()) / 2;
        int count = 0;
        //원 안의 점을 탐색하므로 x=0, y=N-1부터
        double x = 0;
        double y = N - 1;
        //원의 중심에서 원의 둘레까지 거리
        double R = N * N;

        //원 안의 점들 탐색
        while (x <= N && y >= 0) {
            double temp = distance(x + 1, y);
            if (temp <= R)  //원의 둘레 안에 있으면
                x++;
            if (temp >= R)  //원의 둘레 밖에 있으면
                y--;
            count++;
        }

        bw.write(String.valueOf(count*4));
        bw.close();
    }
    //점들의 거리 구하는 메소드
    static double distance(double x, double y) {
        return Math.pow(x, 2) + Math.pow(y, 2);
    }
}
