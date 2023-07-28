


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n, k, card[];
    static boolean visited[];
    static Set<Integer> setNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 카드 수
        k = Integer.parseInt(br.readLine()); // 카드에 적혀있는 수
        visited = new boolean[11];
        card = new int[n];
        setNum = new HashSet<Integer>();
        for(int i=0; i<n; i++){
            card[i] = Integer.parseInt(br.readLine());
        }
        process(0,0);
        System.out.println(setNum.size());
    }
    public static void process(int count, int num){
        if(count == k){ // k개만큼 선택되면
            setNum.add(num);
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i]){ // 이미 사용된 카드면
                continue;
            }
            visited[i] = true;

            int temp;
            if(card[i]>9){
                temp = num*100 + card[i];
            }else{
                temp = num*10 + card[i];
            }
            process(count+1, temp);
            visited[i] = false;
        }
    }
}
