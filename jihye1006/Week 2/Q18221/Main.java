

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] cls = new int[n][n];
        int px = 0, py = 0, sx = 0, sy = 0; // 교수님 x,y좌표, 성규 x,y좌표

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                cls[i][j] = Integer.parseInt(st.nextToken()); //교실의 정보 입력 받기
                if(cls[i][j] == 5){ // 교수님 좌표 저장
                    px = i;
                    py = j;
                }
                if(cls[i][j] == 2){ // 성규 좌표 저장
                    sx = i;
                    sy = j;
                }
            }
        }
        if(((px-sx)*(px-sx)+(py-sy)*(py-sy))<25){ // 거리가 5이하면
            System.out.println(0);
            return;
        }

        int count = 0;
        int bx = px<sx?px:sx; // 작은 x좌표
        int mx = px<sx?sx:px; // 큰 x좌표
        int by = py<sy?py:sy; // 작은 y좌표
        int my = py<sy?sy:py; // 큰 y좌표

        for(int i=bx; i<=mx; i++){ // 교수님과 성규 기준으로 직사각형 모양 안에 있는 수 조회
            for(int j=by; j<=my; j++){
                count += cls[i][j];
            }
        }
        System.out.println(count-7>=3?1:0); //count에서 교수님과 성규의 합 7을 빼준다
    }
}