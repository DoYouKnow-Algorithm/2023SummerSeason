

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o2[1]-o1[1];
        }); // 제출기한을 기준으로 이차원배열 내림차순 정렬

        int end = arr[0][1]; // 가장 마지막 기한 저장
        for(int i=0; i<n; i++){
            // 가장 마지막으로 끝난 날이 현재 제출 기한(해당 조건문)보다 여유가 있다면 현재 제출 기한으로 새로 시작
            if(arr[i][1]<= end){
                end = arr[i][1]-arr[i][0];
            }
            else{ // 마지막으로 끝나는 날보다 앞에 위치하면 더 감소시킴
                end -= arr[i][0];
            }
        }
        System.out.println(end);
    }
}
