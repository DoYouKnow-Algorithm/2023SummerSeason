package Week6;

import java.io.*;
import java.util.StringTokenizer;

public class _17392 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //인호의 약속 개수
        int M = Integer.parseInt(st.nextToken());   //방학 일수

        int[] arr = new int[N];
        int sumH =0;    //기대행복 값들의 합
        st = new StringTokenizer(br.readLine());
        //약속의 기대행복 값들의 합
        for (int i = 0; i < N; i++) {
            sumH += Integer.parseInt(st.nextToken());

        }
        int sum = 0;    //우울함의 합
        int minusDay = M-(sumH+N);  //우울함을 느끼는 날
        if(minusDay<=N+1 && minusDay>0){    //우울함을 느끼는 날이 있고 약속 개수+1보다 작거나 같을 때
            sum = minusDay;     //우울함을 느끼는 날이 정답(1의 제곱은 1)
        }else if(minusDay>N+1){     //우울함을 느끼는 날이 약속 개수+1보다 클 때
            int temp = 1;
            while(true){
                //약속 개수+1만큼 쪼개서 더해야 함
                for (int i = 1; i <= N + 1; i++) {
                    sum += Math.pow(temp, 2);
                    minusDay--;
                    if(minusDay==0) break;  //방학 끝나면 종료
                }
                if(minusDay==0) break;
                temp++;
            }
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
