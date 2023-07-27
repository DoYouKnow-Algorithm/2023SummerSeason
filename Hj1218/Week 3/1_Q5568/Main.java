import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int n,k;
    static String num[],a[];
    static boolean visit[];
    static HashSet<String> set;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); //카드 n장
        k = in.nextInt(); //k장 선택
        num = new String[n]; //카드에 적힌 수를 저장할 배열
        a = new String[k]; //조합을 저장할 배열
        visit = new boolean[n]; //방문 여부
        set = new HashSet<>(); //중복 제거를 위한 Hashset
        for(int i=0;i<n;i++){
            num[i]=in.next(); //숫자 저장
        }
        sum(0);
        System.out.println(set.size()); //set에 저장된 정수 조합의 개수 출력
    }
    static void sum(int number){
        if(number==k){ //k장을 선택한 경우
            String s = "";
            for(int j=0;j<a.length;j++){
                s+=a[j]; //선택한 숫자를 배열에 저장된 순서대로 조합해
            }
            set.add(s); //Hashset에 저장
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){ //방문하지 않은 경우
                visit[i]=true; //방문 o
                a[number] = num[i]; //배열에 해당 숫자 저장
                sum(number+1);
                visit[i]=false; //방문 x
            }
        }
    }
}