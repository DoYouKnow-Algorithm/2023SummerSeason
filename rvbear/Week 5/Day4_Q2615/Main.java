import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[19][19];                   // 바둑판 정보 저장
    static int count;                                       // 연속된 바둑돌의 개수
    static int[] dx = {1, 1, 0, -1}, dy = {0, 1, 1, 1};     // 움직이는 x 좌표, 움직이는 y 좌표
    public static Boolean check(int x, int y, int pre) {    // 시작지점부터 탐색하여 연속되는 바둑돌의 개수가 몇개인지 탐색
        for(int i = 0; i < 4; i++) {
            count = 1;                                      // count 시작
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || mx >= 19 || my < 0 || my >= 19) {  // 이동한 x, y 좌표가 바둑판의 범위를 벗어날 경우 continue
                continue;
            }
            // 이동한 좌표가 연속되는 바둑돌이라면 연속되지 않을 때까지 해당 방향으로 탐색
            while(map[mx][my] == pre) {
                count++;
                mx += dx[i]; my += dy[i];
                // 연속된 바둑돌의 개수가 5 초과이거나 이동한 좌표가 바둑판 범위에 벗어날 경우 반복문 빠져나옴
                if(count > 5 || mx < 0 || mx >= 19 || my < 0 || my >= 19) {
                    break;
                }
            }
            // count가 5일 때 반대 방향도 탐색을 진행하여 만일 반대방향도 이어지는 바둑돌이 존재한다면 continue
            if(count == 5) {
                if(x-dx[i] >= 0 && x-dx[i] < 19 && y-dy[i] >= 0 && y-dy[i] < 19 && map[x-dx[i]][y-dy[i]] == pre) {
                    continue;
                }
                return true;                                // 완벽한 오목이라면 true를 return
            }
        }
        return false;                                       // 아니라면 false를 return
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 19; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int j = 0; j < 19; j++) {
            for(int i = 0; i < 19; i++) {
                if((map[i][j] == 1 || map[i][j] == 2)) {    // 바둑돌이 놓여젔을 경우
                    int pre = map[i][j];                    // 바둑돌의 정보를 저장
                    if(check(i, j, map[i][j])) {            // check 함수를 통해 true가 반환되었다면 해당 정보들을 출력 후 return
                        bw.write(String.valueOf(map[i][j]) + "\n");
                        bw.write(String.valueOf(i+1) + " " + String.valueOf(j+1));
                        bw.close();
                        return;
                    }
                }
            }
        }

        bw.write(String.valueOf(0) + "\n");           // 아직 승부가 나지 않았으므로 0 출력
        br.close(); bw.close();
    }
}