
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean test = true;
        int[][] map = new int[19][19];
        int[] dx = new int[]{1, 0, -1, 1}, dy = new int[]{1, 1, 1, 0}; // 방향을 나타내는 배열

        for (int i = 0; i < 19; i++) {// 바둑판 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                int prev = -1; // 이전에 확인한 바둑알 색깔을 저장
                if (map[i][j] == 1 || map[i][j] == 2) { // 검정(1) 또는 흰색(2) 바둑알인 경우
                    prev = map[i][j]; // 현재 바둑알 색깔 저장
                    for (int k = 0; k < 4; k++) { // 4가지 방향에 대해 검사
                        int cnt = 1; // 연속된 바둑알 개수를 세는 변수
                        int ii = dx[k], jj = dy[k]; // 방향에 따른 x, y 변화량
                        if (i + ii >= 19 || i + ii < 0 || j + jj >= 19 || j + jj < 0) continue; // 바둑판 범위를 벗어나면 다음 방향으로
                        while (map[i + ii][j + jj] == prev) { // 같은 색의 바둑알이 연속되는 동안
                            cnt++;
                            ii += dx[k];
                            jj += dy[k];
                            if (cnt > 5) break; // 연속된 바둑알 개수가 5개 이상이면 더 이상 검사하지 않음
                            if (i + ii >= 19 || i + ii < 0 || j + jj >= 19 || j + jj < 0) break; // 바둑판 범위를 벗어나면 종료
                        }
                        if (i - dx[k] >= 0 && j - dy[k] >= 0 && i - dx[k] < 19 && j - dy[k] < 19)
                            if (map[i - dx[k]][j - dy[k]] == prev)
                                continue; // 같은 색의 바둑알이 이미 5개를 이루고 있는 경우 다음 방향으로
                        if (cnt == 5) { // 5개의 바둑알을 이루는 경우
                            System.out.println(prev);
                            System.out.println((i + 1) + " " + (j + 1));
                            test = false;
                            return;
                        }
                    }
                }
            }
        }
        // 승리 조건을 만족하는 바둑알을 찾지 못한 경우
        if (test) {
            System.out.println(0); // 아무도 승리하지 않음을 출력
        }
    }
}
