

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); //수강 가능 인원
        int l = Integer.parseInt(st.nextToken()); //대기 목록의 길이

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i=0; i<l; i++){
            String num = br.readLine(); //대기 중인 학생의 학번 입력 받기
            if(set.contains(num)) set.remove(num); //이미 앞에 접속한 학생이면 앞 대기목록 삭제
            set.add(num); // 재접속 기록으로 추가
        }
        int count = 0;
        for(String x : set){
            count++;
            System.out.println(x);
            if(count==k) break; //수강 가능 인원 정원이 다 차면
        }

    }
}
