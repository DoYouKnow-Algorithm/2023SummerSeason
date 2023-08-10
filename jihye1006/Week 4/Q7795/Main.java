
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //a의 수
            int b = Integer.parseInt(st.nextToken()); //b의 수
            int[] Anum = new int[a];
            int[] Bnum = new int[b];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<a; j++){ //a의 크기
                Anum[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<b; k++){ //b의 크기
                Bnum[k] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(Anum); //오름차순 정렬
            Arrays.sort(Bnum);
            int count = 0; // a가 b보다 큰 쌍의 개수

            for(int j=0; j<Anum.length; j++){
                for(int k=0; k<Bnum.length; k++){
                    if(Anum[j]<=Bnum[k]){
                        break;
                    }
                    else count++;
                }
            }
            System.out.println(count);
        }
    }
}
