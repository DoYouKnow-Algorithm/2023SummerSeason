
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;

        if(n == 1) {// N이 1이면 이동 불가
            result = 1;
        }else if(n == 2) {
            // N이 2일 떈, 2번,3번 방향으로만 움직일 수 있음
            // 4방향 다 움직일 수 없어서 최댓값은 4
            result = Math.min((m+1)/2, 4);
        }
        else if(n>=3){
            if(m < 7) { //1,4번 번갈아가며 움직임 -> max = 4
                result = Math.min(m, 4);
            }else {
                // M=7 부터 4방향 다 이동 가능
                // 4방향 다 이동한 후에는 y값이 1씩 증가하는 1번,4번 이동을 반복
                // 즉, M-2개의 칸을 갈 수 있음
                result = m-2;
            }
        }

        System.out.println(result);
    }
}
