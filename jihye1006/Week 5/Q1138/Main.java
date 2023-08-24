

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());

        int[] line = new int[n+1]; // 줄에 선 순서 저장하는 배열
        for(int i =1; i<=n; i++){
            int count = Integer.parseInt(st.nextToken()); // 본인봏다 큰 사람이 몇명인지 입력 받기
            for(int j=1; j<=n; j++){
                if(count == 0){ // 본인보다 키 큰 사람이 없다면
                    if(line[j]==0){ // 자리에 아무도 없음
                        line[j] = i;
                        break;
                    }
                    else continue; // 본인보다 큰 사람은 없지만 작은 사람 존재하기 때문에 다음 칸으로 이동
                }
                else if(line[j]==0){ // count가 0이 아니므로 다음 칸으로 이동
                    count --;
                }
            }
        }
        for(int i=1; i<=n; i++){
            System.out.print(line[i]+" ");
        }
    }
}
