

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()); //첫번째 x값, 범위 내 가장 작은 x값
        int x2 = Integer.parseInt(st.nextToken()); //두번째 x값, 범위 내 가장 큰 x값
        int y1 = Integer.parseInt(st.nextToken()); //첫번째 y값, 범위 내 가장 작은 y값
        int y2 = Integer.parseInt(st.nextToken()); //두번째 y값, 범위 내 가장 큰 y값

        int ans1 = -1 * a * x1 - c;
        int ans2 = -1 * a * x2 - c;
        int MinY = ans1 < ans2 ? ans1 : ans2; // 통과할 수 있는 가장 작은 y값
        int MaxY = ans1 > ans2 ? ans1 : ans2; // 통과할 수 있는 가장 큰 y값

        // 위험지역에 해당하는 모서리
        ans1 = b * y1;
        ans2 = b * y2;
        int DanMinY = ans1 < ans2 ? ans1 : ans2; // 위험 지역 최소 y 값
        int DanMaxY = ans1 > ans2 ? ans1 : ans2; // 위험 지역 최대 y 값

        // 위험지역에 거치면 안 되기 때문에
        // 위험지역의 가장 큰 값(DanMaxY)보다 통과할 수 있는 가장 작은 y값(MinY)이 크거나 같으면
        // 위험지역의 가장 작은 값(DanMinY)보다 통과할 수 있는 가장 큰 y값(MaxY)이 작거나 같으면
        if(MinY >= DanMaxY || MaxY <= DanMinY){
            System.out.println("Lucky");
        } else{
            System.out.println("Poor");
        }

    }
}
