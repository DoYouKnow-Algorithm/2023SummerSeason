import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 큰 정사각형 한변의 길이
        int r = N / 2; // 반지름
        int count = 0;
        int temp_j = 1;
        // 1사분면 탐색  -> (0,r) ~ (r, 0) -> count * 4
        for (int i = r; i >= 0; i--) {
            for (int j = temp_j; j <= r; j++) {
                // 원밖에 속할때
                // 왼쪽 아래가 원안에 속하면
                if ((distance_square(i, j) > (double) r * r)
                        && (distance_square(i - 1, j - 1) < (double) r * r)) {
                    count++; // 카운트
                    temp_j = j; // 탐색 범위 재설정
                } else {
                    if (temp_j != j) { //탐색 범위를 벗어나면
                        temp_j = j - 1; // 한칸 이전부터 탐색
                        break;
                    }
                }
            }
        }
        System.out.print(count * 4);
    }

    public static double distance_square(double a, double b) {  // 중심까지의 거리의 제곱
        return ((a * a) + (b * b));
    }
}
