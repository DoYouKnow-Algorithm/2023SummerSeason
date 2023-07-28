package silver._3.Q2992;

import java.io.*;

public class Main {
    static int min, temp;               // 처음 입력한 수보단 큰 수 중 가장 작은 수, 처음 입력한 수
    static String input;                // 처음 입력값
    static String[] arr;                // 입력값을 하나하나 저장할 배열
    static boolean[] visit;             // 방문 여부를 확인할 배열
    public static void perm(int count, String add) {            // 순열 만들고 확인하는 함수
        if(count == input.length()) {                           // 순열의 길이가 입력값과 같을 때
            if(temp < Integer.parseInt(add)) {                  // 처음 입력받은 수보다 큰 수들 중 가장 작은 수를 min에 저장
                if(temp == min) {
                    min = Integer.parseInt(add);
                }
                min = Math.min(Integer.parseInt(add), min);
            }
            return;
        }
        for(int i = 0; i < input.length(); i++) {               // 순열을 만드는 반복문
            if(visit[i]) continue;                              // 이미 방문했을 경우 continue
            visit[i] = true;                                    // 방문 여부 체크
            perm(count + 1, add + arr[i]);           // 재귀 함수 호출
            visit[i] = false;                                   // 방문 여부 풀어줌
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력
        input = br.readLine();
        temp = Integer.parseInt(input);
        min = temp;
        arr = input.split("");
        visit = new boolean[arr.length];

        perm(0, "");                                    // 함수 호출

        bw.write(String.valueOf(min == temp ? 0 : min));           // min 값에 아무것도 들어오지 않았다면 temp값이 가장 큰 것
        br.close();                                                // 입력 버퍼 스트림 닫아줌
        bw.close();                                                // 출력 버퍼 스트림 닫아줌
    }
}