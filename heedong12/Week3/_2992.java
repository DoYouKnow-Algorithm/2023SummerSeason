package Week3;

import java.io.*;
import java.util.Arrays;

public class _2992 {
    static String s;    //몇 자리 수인지
    static int X;   //주어진 수
    static int[] origin, answer;   //주어진 수, X보다 큰 수 중 가장 작은 수
    static boolean[] visit;     //방문 여부
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();  //문자열로 입력받음 -> 몇 자리 수 인지 구할 수 있음
        X = Integer.parseInt(s);    //문자열을 정수로 변환
        origin = new int[s.length()];
        answer = new int[s.length()];
        visit = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {      //정수 하나하나 잘라서 저장
            origin[i] = s.charAt(i)-'0';
        }

        makeNum(0);
        bw.write(String.valueOf(min == Integer.MAX_VALUE ? 0 : min));
        bw.close();

    }
    //count는 글자 수
    static public void makeNum(int count) {
        if (count == s.length()) {  //입력받은 글자 수와 구한 글자 수가 같다면
            String temp = "";
            for (int i : answer) temp += i;     //temp라는 문자열에 한글자씩 더해서 저장
            int n = Integer.parseInt(temp);     //문자열을 정수로 변환
            if (X < n) {    //주어진 값보다 구한 값이 크다면
                min = Math.min(min, n);     //min에 저장된 값(정수의 최대값)과 구한 값을 비교해서 작은 값 저장
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (visit[i]) continue;     //방문한 곳이면 패스

            visit[i] = true;    //방문 표시하고
            answer[count] = origin[i];  //주어진 숫자 중 하나를 answer에 저장
            makeNum(count + 1); //재귀함수 호출
            visit[i] = false;   //방문 표시 없앰
        }
    }
}
