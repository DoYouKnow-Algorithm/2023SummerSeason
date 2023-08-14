package Week5;

import java.io.*;
import java.util.*;

public class _5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    //테스트 케이스 개수

        while (T > 0) {
            String s = br.readLine();   //수행할 함수
            char[] fun = new char[s.length()];  //함수 저장
            fun = s.toCharArray();  //한 글자씩 잘라서 저장

            int n = Integer.parseInt(br.readLine());    //배열에 들어있는 수의 개수
            Deque<Integer> que = new ArrayDeque<>();   //정수 저장할 배열
            s = br.readLine();  //정수 입력받음
            String[] temp = s.substring(1, s.length() - 1).split(",");

            for (int i = 0; i < n; i++) {
                que.add(Integer.parseInt(temp[i]));     //que에 정수들 저장
            }

            int index = 0;
            Boolean isError = false;    //isError가 true이면 error 출력
            Boolean flag = false;   //flag가 true이면 역방향으로

            while (index < fun.length) {
                if (fun[index] == 'R') {    //R 함수이면
                    flag = !flag;     //flag가 true이면 false, false이면 true 저장
                } else {  //D 함수이면
                    if (que.size() == 0) {  //que에 들어있는게 없으면 에러
                        isError = true;
                        break;
                    }
                    if (flag == true) {     //역방향으로 검색해야하므로
                        que.removeLast();   //마지막 정수 삭제
                    } else {
                        que.removeFirst();  //정방향 검색이므로 첫번째 정수 삭제
                    }
                }
                index++;
            }

            StringBuilder sb = new StringBuilder();
            if (!isError) {     //에러가 아님
                sb.append("[");
                if (!flag && que.size()!=0) {  //flag=false -> 정방향으로 출력
                    for (int i = que.size() - 1; i >= 1; i--) {
                        //for(int i=0;i<que.size()-1;i++){      => 이걸로 하면 두개 짤림.. 왜?
                        sb.append(que.remove() + ",");
                    }
                    sb.append(que.remove());
                } else if(flag && que.size()!=0) {    //flag-true -> 역방향으로 출력
                    for (int i = que.size() - 1; i >= 1; i--) {
                        sb.append(que.removeLast() + ",");
                    }
                    sb.append(que.removeLast());
                }
                sb.append("]");
                bw.write(String.valueOf(sb) + "\n");
            } else {    //에러임
                bw.write("error\n");
            }
            bw.flush();
            T--;
        }
        bw.close();
    }
}
