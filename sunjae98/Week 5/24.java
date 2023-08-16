import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] checkerboard = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                checkerboard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count1;
        int count2;
        int count3;
        boolean flag;
        int checker = 0;
        int horizontal_line = 0;
        int vertical_line = 0;

        // 바둑판 5x5 만큼 완전 탐색
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                flag = false;
                if (checkerboard[i][j] == 1) {
                    count1 = 1;
                    for (int k = 1; k <= 4; k++) { // 가로 탐색
                        if (checkerboard[i][j + k] == 1) {
                            count1++;
                        }
                        if (count1 == 5) {
                            flag = true;
                        } else if (count1 >= 6) {
                            flag = false;
                        }
                    }
                    count2 = 1;
                    for (int k = 1; k <= 4; k++) { // 세로 탐색
                        if (checkerboard[i + k][j] == 1) {
                            count2++;
                        }
                        if (count2 == 5) {
                            flag = true;
                        } else if (count2 >= 6) {
                            flag = false;
                        }
                    }
                    count3 = 1;
                    for (int k = 1; k <= 4; k++) { // 대각 탐색
                        if (checkerboard[i + k][j + k] == 1) {
                            count3++;
                        }
                        if (count3 == 5) {
                            flag = true;
                        } else if (count3 >= 6) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        checker = 1;
                        horizontal_line = i + 1;
                        vertical_line = j + 1;
                    }
                } else if (checkerboard[i][j] == 2) {
                    count1 = 1;
                    for (int k = 1; k <= 4; k++) { // 가로 탐색
                        if (checkerboard[i][j + k] == 2) {
                            count1++;
                        }
                        if (count1 == 5) {
                            flag = true;
                        } else if (count1 >= 6) {
                            flag = false;
                        }
                    }
                    count2 = 1;
                    for (int k = 1; k <= 4; k++) { // 세로 탐색
                        if (checkerboard[i + k][j] == 2) {
                            count2++;
                        }
                        if (count2 == 5) {
                            flag = true;
                        } else if (count2 >= 6) {
                            flag = false;
                        }
                    }
                    count3 = 1;
                    for (int k = 1; k <= 4; k++) { // 대각 탐색
                        if (checkerboard[i + k][j + k] == 2) {
                            count3++;
                        }
                        if (count3 == 5) {
                            flag = true;
                        } else if (count3 >= 6) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        checker = 2;
                        horizontal_line = i + 1;
                        vertical_line = j + 1;
                    }
                }
            }
        }

        if (checker == 0) {
            System.out.println(checker);
        } else {
            System.out.println(checker);
            System.out.print(horizontal_line + " " + vertical_line);
        }
    }
}
