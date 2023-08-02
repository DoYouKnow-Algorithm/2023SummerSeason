package Week3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _2529 {
    static int k;
    static String[] s;
    static boolean[] visit = new boolean[10];
    static ArrayList answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());    //부등호 문자의 개수
        s = new String[k];   //부등호 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) s[i] = st.nextToken();  //부등호 입력받아서 저장
        for (int i = 0; i <= 9; i++) visit[i] = false;  //모두 방문하지 않음으로 초기화

        dfs("", 0);
        Collections.sort(answer);   //오름차순으로 정렬

        bw.write(String.valueOf(answer.get(answer.size() - 1) + "\n")); //최댓값 출력
        bw.write(String.valueOf(answer.get(0)));    //최솟값 출력
        bw.close();
    }
    //a와 b를 op로 비교
    static boolean check(int a, int b, char op) {
        if (op == '<') return a < b;
        else return a > b;
    }

    static void dfs(String num, int cnt) {
        if (cnt == k + 1) {     //모든 부등호 사용하면
            answer.add(num);    //answer에 추가
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!visit[i]) {    //방문하지 않았고
                //num의 마지막 숫자와 i를 op로 비교해서 만족하면 num에 이어붙임
                if (cnt == 0 || check(num.charAt(num.length() - 1) - '0', i, s[cnt - 1].charAt(0))) {
                    visit[i] = true;
                    dfs(num + i, cnt + 1);
                    visit[i] = false;
                }
            }
        }
    }
}

