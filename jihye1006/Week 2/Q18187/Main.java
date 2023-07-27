

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n+2];
        arr[1] = 2;
        arr[2] = 4;
        int sum = 3;

        for(int i=3; i<=n; i++){
            arr[i] = arr[i-1]+sum;
            if(i%3 != 0){
                sum++;
            }
        }
        System.out.println(arr[n]);
    }
}
