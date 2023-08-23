package Week6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //과제의 개수
        Homework[] hw = new Homework[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            hw[i] = new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(hw);    //마감일이 늦는 순서로 정렬
        int answer = hw[0].t;   //가장 늦은 마감일 저장
        for (int i = 0; i < N; i++) {
            if (answer < hw[i].t) {     //현재 과제의 마감일이 answer보다 크다면
                answer -= hw[i].d;  //과제를 끝내고 다음 과제 시작 -> 과제 소요시간을 뺌
            } else {
                answer = hw[i].t - hw[i].d;     //마감일까지 끝내도록 조정
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

class Homework implements Comparable<Homework> {
    int d;  //걸리는 일
    int t;  //마감 일

    public Homework(int d1, int t1) {
        d = d1;
        t = t1;
    }

    //마감이 늦는 순서로 정렬해줌
    public int compareTo(Homework homework) {
        return homework.t - t;
    }
}
