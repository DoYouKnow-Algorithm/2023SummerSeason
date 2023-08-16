import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] checkerboard = new int[19][19]; // 바둑판 상태를 저장할 배열
        int[] horizontal = {0, 1, -1, 1}; // 오른쪽, 아래, 대각 위, 대각 아래
        int[] vertical = {1, 0, 1, 1}; // 오른쪽, 아래, 대각 위, 대각 아래

        // 바둑판 상태
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                checkerboard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count; // 연속된 바둑알의 개수
        int I; // 탐색할 가로줄
        int J; // 탐색할 세로줄
        int I_rev; // 탐색할 가로 반대줄
        int J_rev; // 탐색할 세로 반대줄
        boolean game = false; // 승부 결정

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (checkerboard[i][j] == 1 || checkerboard[i][j] == 2) { // 탐색한 바둑알이 검은돌 or 흰돌 일때
                    int temp = checkerboard[i][j]; // 바둑알을 temp 에 저장
                    for (int k = 0; k < 4; k++) { // 4가지 방향 탐색
                        count = 1;
                        I = i + horizontal[k]; // 탐색할 가로줄
                        J = j + vertical[k]; // 탐색할 세로줄

                        if (0 <= I && I < 19 && 0 <= J && J < 19) { // 바둑판 내부
                            while (checkerboard[I][J] == temp) { // 바둑알이 연속되지 않을때까지 반복
                                count++; // 연속된 개수 증가
                                I += horizontal[k]; // 탐색할 가로줄
                                J += vertical[k]; // 탐색할 세로줄

                                if (count > 5) { // 1. 여섯 알 이상이 연속적으로 놓인 경우
                                    break; // 반복문 빠져나감
                                }
                                if (I < 0 || I >= 19 || J < 0 || J >= 19) { // 2. 바둑판을 벗어나는 경우
                                    break; // 반복문 빠져나감
                                }
                            }

                            if (count == 5) { // 진행 방향 기준으로 오목 완성
                                // 연속된 방향의 반대가 같은 돌이면 안됌
                                I_rev = i - horizontal[k]; // 탐색할 가로 반대줄
                                J_rev = j - vertical[k]; // 탐색할 세로 반대줄

                                if (I_rev == -1 || J_rev == -1) { // 1. 막다른 길
                                    game = true;
                                    System.out.println(temp); // 연속된 5개 돌의 종류
                                    System.out.print((i + 1) + " " + (j + 1)); // 시작점
                                    return; // 게임 종료
                                }
                                if (0 <= I_rev && I_rev < 19 && 0 <= J_rev && J_rev < 19) { // 2. 바둑판 내부
                                    if (checkerboard[I_rev][J_rev] != temp) {// 연속되지 않음
                                        game = true;
                                        System.out.println(temp); // 연속된 5개 돌의 종류
                                        System.out.print((i + 1) + " " + (j + 1)); // 시작점
                                        return; // 게임 종료
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!game) { // 승부가 결정나지 않음
            System.out.println(0);
        }
    }
}
