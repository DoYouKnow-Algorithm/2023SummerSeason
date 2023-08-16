package Week5;

import java.io.*;
import java.util.StringTokenizer;

public class _2615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[19][19];
        int[][] d = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};   //x,y 좌표의 변화량
        StringTokenizer st;
        //바둑판 상태 입력 받음
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //모든 좌표 확인
        for (int j= 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                //1 -> 검은 바둑알, 2 -> 흰 바둑알
                if (arr[i][j] == 1 || arr[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int x = i;  //x좌표
                        int y = j;  //y좌표
                        int count = 1;    //연속하는 바둑알 개수

                        while (true) {
                            x += d[k][0];
                            y += d[k][1];
                            //좌표 범위 안에 있어야하고
                            if (0 <= x && x < 19 && 0 <= y && y < 19) {
                                //연속하는 바둑알이면 count+1
                                if (arr[i][j] == arr[x][y]) count++;
                                else break;     //아니면 종료
                                //범위를 벗어나도 종료
                            } else break;
                        }
                        x = i;
                        y = j;

                        //반대방향으로 탐색
                        while (true) {
                            x -= d[k][0];
                            y -= d[k][1];
                            //좌표 범위 안에 있어야하고
                            if (0 <= x && x < 19 && 0 <= y && y < 19) {
                                //연속하는 바둑알이면 count+1
                                if (arr[i][j] == arr[x][y]) count++;
                                else break;     //아니면 종료
                                //범위를 벗어나도 종료
                            } else break;
                        }

                        //연속하는 바둑알이 5개
                        if (count == 5) {
                            //검은색이면 1, 흰색이면 2 출력
                            bw.write(String.valueOf(arr[i][j] + "\n"));
                            //이긴 위치 출력
                            bw.write(String.valueOf((i+1)+" "+(j+1)));
                            bw.close();
                            return;
                        }
                    }
                }
            }
        }
        //이긴 사람이 없음
        bw.write(String.valueOf(0));
        bw.close();
    }
}
