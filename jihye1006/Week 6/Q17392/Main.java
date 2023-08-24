

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 약속 수
        int m = Integer.parseInt(st.nextToken()); // 방학 일수

        st = new StringTokenizer(br.readLine());
        int [] date = new int[n];

        int sum = 0;
        for(int i=0; i<n; i++){
            date[i] = Integer.parseInt(st.nextToken()); // 기대행복값
            sum += date[i] +1;
        }
        int sadDay = m - sum; // 우울함을 느끼는 날
        int sad = 0;
        if(sadDay<=0){
            System.out.println(0);
        }
        else{
            int a = sadDay/(n+1); // 공통 간격
            int b = sadDay%(n+1); // 우울한 날은 하루씩 b만큼 배치
            for(int i=1; i<=a;i++){
                sad+=Math.pow(i,2);
            }
            sad = sad*(n+1); // 구간만큼 곱해줌
            sad += Math.pow(a+1, 2)*b;
            System.out.println(sad);
        }
    }
}
