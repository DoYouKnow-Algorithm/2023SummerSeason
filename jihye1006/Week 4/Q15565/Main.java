

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 인형 개수
        int k = Integer.parseInt(st.nextToken()); // 포함되어야하는 라이언 인형 최소 개수

        st = new StringTokenizer(br.readLine());
        int[] dolls = new int[n]; // 인형의 정보
        int distance = Integer.MAX_VALUE; //집합의 크기
        int count=0, left=0, right=0;

        for(int i=0; i<n; i++){
            dolls[i] = Integer.parseInt(st.nextToken());
        }
        while(left<=right && right<=dolls.length){
            if(count<k){
                if(right == dolls.length) break;
                if(dolls[right]==1){ // 라이언이면
                    count++;
                }
                right++;
            }
            else{ // k개 이상의 라이언인형을 포함하면
                distance = Math.min(distance, right-left); // 집합 중 최소값 찾기
                if(dolls[left]==1) count--;
                left++;
            }
        }
        if(distance == Integer.MAX_VALUE){ // 집합이 없다면
            System.out.println("-1");
        }
        else{
            System.out.println(distance);
        }
    }
}
