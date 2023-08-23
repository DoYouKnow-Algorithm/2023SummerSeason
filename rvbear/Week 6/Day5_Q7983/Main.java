import java.io.*;
import java.util.*;

class Homework implements Comparable<Homework> {        // 과제 클래스
    int d, t;                                           // 걸리는 일, 마감일

    public Homework(int _d, int _t) {
        d = _d; t = _t;
    }

    @Override
    public int compareTo(Homework hw) {                 // 마감일이 큰 순서대로 정렬
        return hw.t - t;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Homework[] arr = new Homework[n];               // 과제들을 저장하는 배열
        for(int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr[i] = new Homework(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }

        Arrays.sort(arr);                               // 마감일이 큰 순서대로 정렬

        int days = arr[0].t;                            // 가장 마지막 마감일을 현재일로 저장
        for(int i = 0; i < n; i++) {
            if(arr[i].t < days) {                       // 입력 예시처럼 10일에 끝내고 12일까지 쉴 수 있는 경우를 제거해주기 위해
                days = arr[i].t;                        // 시작할 때 마감일이 현재 날짜보다 작다면 마감일로 맞춰줌
            }
            days -= arr[i].d;                           // 현재 날짜에서 과제를 하는데 걸리는 날을 빼줌
        }

        System.out.println(days);                       // 마지막 마감일부터 처음 과제를 시작해야하는 날까지 빼준다면 최대한 쉴 수 있는 날짜
        br.close();
    }
}