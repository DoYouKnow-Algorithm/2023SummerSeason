import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //인형 n개
        int k = Integer.parseInt(st.nextToken()); //필요한 라이언 인형 k개
        int num[] = new int[n]; //인형 배열
        ArrayList<Integer> list = new ArrayList<>();
        int min=1000000; //가장 작은 집합의 크기
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(st.nextToken());
            if(num[i]==1){
                list.add(i); //라이언 인형이 위치한 인덱스 저장
            }
        }
        if(list.size()<k){ //집합에 라이언 인형이 k개 미만인 경우
            System.out.println(-1);
        }
        else{
            int start=0; //시작 인덱스
            int end = k-1; //끝 인덱스 (집합 길이 : 시작 ~ 끝 = k)
            int count = 0; //집합 길이
            while(end<list.size()){
                //집합 길이 = 끝 - 시작 + 1
                count = list.get(end)-list.get(start)+1;
                min = Math.min(min,count);
                start++;
                end++;
            }
            System.out.println(min);
        }
    }
}