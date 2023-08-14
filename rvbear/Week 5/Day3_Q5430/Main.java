import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());                // 테스트 케이스 개수

        for(int i = 0; i < t; i++) {
            Deque<Integer> deque = new LinkedList<>();          // deque 선언
            String method = br.readLine();                      // 함수 입력 받음
            int n = Integer.parseInt(br.readLine());            // 숫자의 개수 입력받음
            String line = br.readLine();                        // [~,~] 꼴로 입력 받음
            // 맨 앞과 맨 뒤의 괄호를 제외하고 ,를 기준으로 나눠줌
            String[] num = line.substring(1, line.length()-1).split(",");
            Boolean flag = false;                               // false = 맨 앞부터, true = 맨 뒤부터
            Boolean error = false;                              // false = error 발생 없음, true = error 발생
            for(int j = 0; j < num.length; j++) {
                if(!num[j].equals("")) {
                    deque.add(Integer.parseInt(num[j]));
                }
            }
            for(int j = 0; j < method.length(); j++) {
                if(method.charAt(j) == 'R') {                   // 시작 위치를 바꿔줌
                    if(!flag) {                                 // 시작 위치를 맨 앞에서 맨 뒤로
                        flag = true;
                    }
                    else {                                      // 시작 위치를 맨 뒤에서 맨 앞으로
                        flag = false;
                    }
                } else {
                    if(deque.isEmpty()) {                       // deque에 값이 없을 경우 error 출력 후 다음 케이스 진행
                        bw.write("error\n");
                        error = true;
                        break;
                    }
                    if(!flag) {                                 // 시작 위치가 맨 앞이므로 맨 앞에 있는 값 제거
                        deque.removeFirst();
                    }
                    else {                                      // 시작 위치가 맨 뒤이므로 맨 뒤에 있는 값 제거
                        deque.removeLast();
                    }
                }
            }
            if(error) {                                         // error가 발생했다면 다음 케이스 입력 받음
                continue;
            }
            bw.write("[");
            while(!deque.isEmpty()) {                           // deque에 값이 없을 때까지 출력
                if(!flag) {                                     // 시작점이 맨 앞이므로 맨 앞부터 출력
                    bw.write(String.valueOf(deque.removeFirst()));
                } else {                                        // 시작점이 맨 뒤이므로 맨 뒤부터 출력
                    bw.write(String.valueOf(deque.removeLast()));
                }
                if(deque.size() >= 1) {                         // 마지막 숫자 뒤에는 , 붙이지 않도록 함
                    bw.write(",");
                }
            }
            bw.write("]\n");
        }

        br.close(); bw.close();
    }
}