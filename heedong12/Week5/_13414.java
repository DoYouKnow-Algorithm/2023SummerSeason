package Week5;

import java.io.*;
import java.util.*;

public class _13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   //수강 가능 인원
        int L = Integer.parseInt(st.nextToken());   //대기목록의 길이
        //순서보장을 위해 LinkedHashSet 사용
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String temp = br.readLine();
            if(set.contains(temp)){     //이미 대기열에 들어가 있다면
                set.remove(temp);   //삭제함
            }
            set.add(temp);  //추가함
        }

        Iterator<String> iterator = set.iterator();
        //K번째까지만 출력
//        while(K>0){
//            System.out.println(iterator.next());
//            K--;
//        }
        int count=0;
        for(String s:set){
            if(count==K) break;
            System.out.println(s);
            count++;
        }
        br.close();
    }
}
