package Week3;

import java.io.*;
import java.util.StringTokenizer;

public class _9742 {
    static boolean[] visit;
    static char[] answer;
    static char[] arr;
    static int total=0;
    static int n;
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "";
        StringTokenizer st;

        while((s=br.readLine())!=null && !s.isEmpty()){
            st=new StringTokenizer(s);
            String temp = st.nextToken();   //주어진 문자열
            n = Integer.parseInt(st.nextToken());   //구해야 할 위치
            arr = new char[temp.length()];
            answer = new char[temp.length()];
            visit = new boolean[temp.length()];

            int max=1;  //순열 개수 저장

            for (int i = 0; i < temp.length(); i++) {
                arr[i] = temp.charAt(i);    //한글자씩 잘라서 저장
                max*=i+1;   //순열 개수
            }

            //n이 총 순열보다 크면 No permutation 출력
            if(n>max){
                bw.write(String.valueOf(s+" = No permutation\n"));
            }
            else{
                total=0;    //total 변수 초기화
                result = new StringBuilder();   //result 변수 초기화
                location(0, temp.length());
                bw.write(String.valueOf(s+" = "+result.toString()+"\n"));
            }
        }
        bw.close();
    }
    static void location(int cnt, int len){
        if(cnt==len){
            total++;
            if(total==n) result.append(answer);
            return;
        }
        for (int i=0;i<len;i++){
            if(!visit[i]){
                visit[i]=true;
                answer[cnt] = arr[i];
                location(cnt+1,len);
                visit[i]=false;
            }
        }
    }
}
