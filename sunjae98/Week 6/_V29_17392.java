import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 인호의 약속 개수
        int M = Integer.parseInt(st.nextToken()); // 방학의 일수
        int[] happiness = new int[N]; // 기대행복
        int depressed = 0; // 우울함

        // key : 우울함이 최소 -> 행복함은 크던 작던 상관없음
        // key : (기대행복 + 1) 일은 우울하지 않음
        int happy_day = 0; // 행복한 날
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            happiness[i] = Integer.parseInt(st.nextToken()); // 기대 행복
            happy_day += happiness[i];
        }
        int depressed_day = M - (happy_day + N); // 우울한 날

        if (depressed_day <= 0) { // 우울한 날이 없음
            System.out.print(0);
            return;
        }

        int section = N + 1; // 약속 사이의 구간 개수
        int distance = depressed_day / section; // 최소 간격
        for (int i = 1; i <= distance; i++) { // 구간별 우울함의 합
            depressed += Math.pow(i, 2);
        }
        depressed *= section; // 구간 개수 만큼 곱해줌  => ex)(1+4) * 3

        int k = depressed_day % section; // 공통 구간에 속하지 않은 나머지 우울한 날
        depressed += Math.pow(distance + 1, 2) * k; // 우울함에 더해줌 => ex){ (1+4) * 3 } + (9*2)

        System.out.println(depressed);
    }
}
