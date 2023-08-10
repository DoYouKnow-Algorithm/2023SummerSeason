import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] table = new int[1000][1000];

        //교수 위치
        int ax = 0;
        int ay = 0;

        //성규 위치
        int bx = 0;
        int by = 0;

        //책상 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if (table[i][j] == 5) { // 교수 위치 저장
                    ax = i;
                    ay = j;
                } else if (table[i][j] == 2) { // 성규 위치 저장
                    bx = i;
                    by = j;
                }
            }
        }

        //거리의 제곱
        int distance_square =
                (Math.abs(ax - bx) * Math.abs(ax - bx))
                        + (Math.abs(ay - by) * Math.abs(ay - by));

        if (distance_square < 25) { // 조건 1 위배
            System.out.print(0);
            return;
        }

        //직사각형 안에 학생이 있으면 count++
        int count = 0; //학생의 수
        for (int i = Math.min(ax, bx); i <= Math.max(ax, bx); i++) {
            for (int j = Math.min(ay, by); j <= Math.max(ay, by); j++) {
                if (table[i][j] == 1) {
                    count++;
                }
            }
        }

        if (count >= 3) { //조건 2
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
