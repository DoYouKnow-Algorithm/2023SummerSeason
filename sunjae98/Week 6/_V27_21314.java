import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String max(String a) { // 최댓값
        StringBuilder sb = new StringBuilder();
        int count = 0; // 연속된 M의 개수

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i); // 한 문자씩 탐색
            if (c == 'M') { // 탐색한 문자가 M 이라면 count++
                count++;
            } else { // 탐색한 문자가 K 라면
                sb.append(5);
                for (int j = 0; j < count; j++) { // 연속된 M 의 개수만큼
                    sb.append(0);
                }
                count = 0; //  연속됨이 끊어지므로 초기화
            }
        }

        if (count > 0) { // M은 연속됬지만 K와 조합을 못한 경우
            for (int i = 0; i < count; i++) { // 개수만큼
                sb.append(1); // ex) MMMM -> 1111
            }
        }
        return sb.toString();
    }

    public static String min(String b) { // 최솟값
        StringBuilder sb = new StringBuilder();
        int count = 0; // 연속된 M의 개수

        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i); // 한 문자씩 탐색
            if(i>0) { // 두글자 이상
                char prev = b.charAt(i-1); // 이전 탐색한 문자
                if(c =='M') { // 탐색한 문자가 M
                    if (prev == 'M') { // M이 연속 되면
                        sb.append(0);
                    }
                    else{
                        sb.append(1);
                    }
                }
                else{ // 탐색한 문자가 K
                    sb.append(5);
                }
            }

            else{ // 한 글자인 경우
                if(c == 'M'){
                    sb.append(1);
                }
                else{
                    sb.append(5);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine(); // 민겸 수 하나

        System.out.println(max(num));
        System.out.println(min(num));
    }
}
