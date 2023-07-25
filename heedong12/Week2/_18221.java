package Week2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _18221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        Pair sung = new Pair(0, 0);
        Pair professor = new Pair(0, 0);
        ArrayList<Pair> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {   //성규 아닌 학생이면
                    students.add(new Pair(i, j));
                } else if (arr[i][j] == 2) {    //성규이면
                    sung = new Pair(i, j);
                } else if (arr[i][j] == 5) {    //교수님이면
                    professor = new Pair(i, j);
                }
            }
        }

        int answer = 0;
        //성규와 교수님 사이의 거리 구함
        int distance = (int) Math.sqrt(Math.pow(sung.x - professor.x, 2) + Math.pow(sung.y - professor.y, 2));
        if (distance >= 5) {    //거리가 5 이상이여야 함
            Pair min = new Pair(Math.min(sung.x, professor.x), Math.min(sung.y, professor.y));  //작은 좌표들 저장
            Pair max = new Pair(Math.max(sung.x, professor.x), Math.max(sung.y, professor.y));  //큰 좌표들 저장
            for(int i=min.x;i<=max.x;i++){  //직사각형을 범위로 지정하고
                for (int j = min.y; j <= max.y; j++) {
                    if(arr[i][j]==1) answer++;  //학생이 있으면 answer + 1
                }
            }
        }
        answer = answer>=3 ? 1 : 0;     //사이에 학생이 3명 이상 존재하면 1 아니면 0 저장
        bw.write(String.valueOf(answer));

        bw.close();
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
