package silver._3.Q9742;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String result;
    static int[] fac = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력
        StringTokenizer stk;
        fac[0] = 1;
        for(int i = 1; i <= 10; i++) {          // 팩토리얼 계산 (각 자리 수에서 나올 수 있는 순열의 개수 최댓값)
            fac[i] = fac[i-1] * i;
        }

        String input = "";
        while((input = br.readLine()) != null) {
            stk = new StringTokenizer(input);
            if(!stk.hasMoreTokens()) {          // EOF 입력 시 종료되는 코드 추가 (없으면 NullPointer 오류가 자꾸 남..)
                return;
            }
            String question = stk.nextToken();
            n = Integer.parseInt(stk.nextToken());
            result = "";

            bw.write(input + " = ");
            if(n > fac[question.length()]) {           // 찾아야 하는 위치가 해당 자리 수의 최댓값을 넘겼을 경우 찾을 수 없음
                bw.write("No permutation\n");
            } else {                                   // 해당 자리 수의 최댓값 안에 있을 경우
                ArrayList<Character> make = new ArrayList<>();
                for (int i = 0; i < question.length(); i++) {          // 배열에 순열을 만드는 값을 저장
                    make.add(question.charAt(i));
                }
                n--;                                                   // index가 0부터 시작이기 때문에 숫자를 하나 빼줌
                for (int i = question.length() - 1; i >= 0; ) {        // 6자리 순열일 경우 5!을 나눈 값을 저장
                    result += make.remove(n / fac[i]);
                    n %= fac[i--];                                     // 그리고 그 나머지를 나눠서 해당 자리부터 탐색이 가능하도록 함
                }
                bw.write(result + "\n");                           // 결과값 출력
            }
        }

        br.close();             // 입력 버퍼 스트림 닫아줌
        bw.close();             // 출력 버퍼 스트림 닫아줌
    }
}