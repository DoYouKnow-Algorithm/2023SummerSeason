package Week4;


import java.io.*;

public class _2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //정수 N
        int count = 1;  //자기 자신 하나 가지고 시작
        int sum = 0;    //연속된 정수의 합

        for (int i = 1; i <= N / 2; i++) {  //시작
            sum = i;
            for (int j = i + 1; j <= N; j++) {     //끝
                sum += j;
                if (sum == N) {
                    count++;
                    break;
                }//연속된 정수들의 합이 N이면 count+1
                if (sum > N) break;     //합이 N보다 작으면 안쪽 for문 종료
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
