import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           // 버퍼 스트림을 통해 입력
        int n = Integer.parseInt(br.readLine());    // 만들어야하는 숫자
        int count = 0;                              // 만들 수 있는 조합의 개수

        for(int i = 1; i <= n; i++) {               // 1부터 n까지 반복문 진행
            int sum = i;
            for(int j = i+1; j <= n; j++) {         // 다음 숫자부터 더해주며 n이 됐을 경우 count 증가 후 빠져나옴
                if(sum > n) {
                    break;
                } else if(sum == n) {
                    count++;
                    break;
                }
                sum += j;
            }
        }

        System.out.println(count+1);                // 결과값 출력(+1을 해주는 이유는 자기 자신도 포함하기 때문)
        br.close();                                 // 입력 버퍼 스트림 닫아줌
    }
}