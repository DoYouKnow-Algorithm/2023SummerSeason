import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(stk.nextToken());          // 수강 정원
        int l = Integer.parseInt(stk.nextToken());          // 수강신청 버튼을 누른 사람 수

        Set<String> site = new LinkedHashSet<>();           // 사이트에 들어오는 순서를 저장할 배열
        for(int i = 0; i < l; i++) {
            String student = br.readLine();
            if(site.contains(student)) {                    // 이미 누른 적이 있다면 그 정보를 빼고
                site.remove(student);
            }
            site.add(student);                              // 배열에 입력
        }

        int count = 0;                                      // 수강신청에 성공한 인원 숫자 저장
        for(String s : site) {
            bw.write(s + "\n");                         // 값을 출력하고
            count++;                                        // count를 증가
            if(count == k) {                                // count가 정원과 같다면 break 시켜줌
                break;
            }
        }

        br.close(); bw.close();
    }
}