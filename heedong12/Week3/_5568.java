package Week3;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class _5568 {
    static int n, k;
    static boolean[] visit;
    static HashSet<Integer> set = new HashSet<>();
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());    //n장의 카드 중
        k = Integer.parseInt(br.readLine());    //k개 선택
        card = new int[n];    //카드 저장할 배열
        visit = new boolean[n];     //방문 여부
        //카드에 적힌 수 저장
        for (int i = 0; i < n; i++) card[i] = Integer.parseInt(br.readLine());

        makeNumber(0,0);
        bw.write(String.valueOf(set.size()));   //저장되어 있는 정수의 개수 출력
        bw.close();


    }
    //count는 선택된 카드의 개수
    static void makeNumber(int count, int num){
        //카드가 k개 선택되면 set에 저장
        if(count == k ){
            set.add(num);
            return;
        }
        //카드 선택
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue; //방문한 곳이면 패스

            visit[i]=true;  //방문으로 표시하고

            int temp=0;
            if(card[i]>9){  //숫자가 두자리수라면
                temp=num*100+card[i];
            }else{  //숫자가 한자리수라면
                temp = num*10+card[i];
            }

            makeNumber(count+1,temp);
            visit[i]=false; //방문하지 곳으로 표시
        }
    }
}
