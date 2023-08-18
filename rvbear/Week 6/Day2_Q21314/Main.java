import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        int m_count = 0;                                    // M의 개수 탐색
        String min = "", max = "";                          // 최솟값과 최댓값 저장
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == 'M') {                                  // M이 나왔을 경우
                m_count++;                                  // M의 개수를 증가
                if(i == line.length()-1) {                  // 만일 마지막에 나온 민겸 수가 M일 경우
                    min += "1";                             // 최솟값은 MMM 일 경우 100으로, 최댓값은 111로 출력되도록 함
                    for(int j = 1; j < m_count; j++) {
                        min += "0";
                        max += "1";
                    }
                    max += "1";
                }
            } else {                                        // K가 나왔을 경우
                max += "5";                                 // M의 숫자와 상관없이 무조건 최댓값은 5로 시작
                if(m_count != 0) {                          // 이후 M의 개수가 0보다 크다면
                    min += "1";                             // 최솟값은 1부터 시작하고
                    for(int j = 1; j < m_count; j++) {      // M의 개수만큼 자리수를 채워줌
                        max += "0";
                        min += "0";
                    }
                    max += "0";                           
                }
                min += "5";                                 // M의 개수만큼 숫자를 채웠다면, 혹은 M의 개수가 0이라면 최솟값에 5를 추가
                m_count = 0;                                // M의 개수 초기화
            }
        }

        bw.write(max + "\n" + min);
        br.close(); bw.close();
    }
}