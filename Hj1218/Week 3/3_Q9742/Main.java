import java.util.Scanner;

public class Main {
    static int n,count;
    static boolean visit[];
    static char c[];
    static String s,answer;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()){
            s = in.next(); //입력받은 문자열
            n = in.nextInt(); //찾아야 하는 위치
            visit = new boolean[s.length()]; //방문 여부
            c = new char[s.length()]; //순열 저장 배열
            count = 0; //순열 수 초기화
            check(0);
            if(count<n){ //위치에 해당하는 순열이 존재하지 않는 경우
                System.out.println(s+" "+n+" = No permutation");
            }
            else{ //위치에 해당하는 순열이 존재하는 경우
                System.out.println(s+" "+n+" = "+answer);
            }
        }
    }
    static void check(int num){
        if(num== s.length()){ //문자열의 길이와 같아지면
            count++; //순열 수 증가
            String str="";
            if(count==n){ //찾아야 하는 위치인 경우
                for(int j=0;j<c.length;j++){
                    str+=c[j]; //배열에 저장한 문자 조합
                }
                answer = str; //해당 순열 저장
            }
            return;
        }
        for(int i=0;i<s.length();i++){
            if(!visit[i]){ //방문하지 않은 경우
                visit[i]=true; //방문 o
                c[num]=s.charAt(i); //해당 위치 문자 저장
                check(num+1);
                visit[i]=false; //방문 x
            }
        }
    }
}
