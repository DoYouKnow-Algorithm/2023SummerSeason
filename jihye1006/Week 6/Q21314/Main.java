

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean test = false;

        String big = bigNum(sb, test, cnt, str); // 최댓값
        String small = smallNum(sb, test, cnt, str); // 최솟값

        System.out.println(big);
        System.out.println(small);
    }

    public static String bigNum(StringBuilder sb, boolean test, int cnt, String str){ //최댓값
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(!test && ch == 'K') sb.append(5); // m 없이 k가 나왔을 때
            if(ch=='M'){ // m개수 세기
                cnt++;
                test = true;
            }
            else if(test && ch == 'K'){ // m이 있는 상태에서 k가 나왔을 때
                sb.append(5).append("0".repeat(cnt));
                test = false;
                cnt = 0;
            }
        }
        if(cnt!=0){
            sb.append("1".repeat(cnt)); // cnt 개수만큼 1반복
        }
        return sb.toString();
    }

    public static String smallNum(StringBuilder sb, boolean test, int cnt, String str){ //최솟값
        sb.setLength(0); // 초기화
        test = false;
        cnt = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(!test && ch =='K') sb.append(5);// m 없이 k가 나왔을 때
            if(ch=='M'){// m개수 세기
                cnt++;
                test = true;
            }
            else if(test && ch =='K'){ // m이 있는 상태에서 k가 나왔을 때
                sb.append(1).append("0".repeat(cnt-1)).append(5);
                test = false;
                cnt = 0;
            }
        }
        if(cnt!=0) sb.append(1).append("0".repeat(cnt-1));
        return sb.toString();
    }


}
