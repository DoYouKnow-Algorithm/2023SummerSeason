
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int number, n, min = Integer.MAX_VALUE;
    static int[] arr, num;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        number = Integer.parseInt(s);
        n = s.split("").length; // 숫자 자릿수
        arr = new int[n];
        num = new int[n];
        visited = new boolean[n]; // 방문 여부
        for(int i=0; i<n; i++){ // 숫자 하나씩 배열에 넣기
            arr[i] = Integer.parseInt(s.split("")[i]);
        }
        process(0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    public static void process(int count){
        if(count == n){ // 자릿수와 같다면
            String s = "";
            for(int i: num){ // 배열을 문자열로 바꾼 후 또 정수로 변환시켜준다
                s += i;
            }
            int n = Integer.parseInt(s);
            if(number < n){
                min = Math.min(min, n);
            }
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){ //방문하지 않았다면
                visited[i] = true;
                num[count] = arr[i]; // 해당 숫자 넣어줌
                process(count+1);
                visited[i] = false;
            }
        }
    }
}
