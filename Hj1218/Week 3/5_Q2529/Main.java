import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int k;
    static char c[];
    static boolean visit[];
    static ArrayList<String> list;
    static int num[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        k = in.nextInt(); //부등호 문자의 개수
        c = new char[k]; //부등호 문자 배열
        visit = new boolean[10]; //0~9까지 방문 여부
        num = new int[k+1]; //부등호 앞뒤로 들어갈 숫자 배열 (부등호개수+1)
        list = new ArrayList<>(); //조건을 만족하는 숫자 리스트
        for(int i=0;i<k;i++){
            c[i]=in.next().charAt(0); //부등호 저장
        }
        search(0);
        Collections.sort(list); //오름차순 정렬
        System.out.println(list.get(list.size()-1)); //최댓값
        System.out.println(list.get(0)); //최솟값
    }
    static boolean check(int a, int b, char c){ //a : 들어가 있는 숫자, b : 체크할 숫자, c : 부등호
        //들어가 있는 숫자 a와 현재 체크할 숫자 b가 부등호관계(c)를 만족하는지 체크
        if(c=='<'){
            if(a>b){
                return false;
            }
        }
        else if(c=='>'){
            if(a<b){
                return false;
            }
        }
        return true;
    }
    static void search(int number){
        if(number==k+1){ //저장된 숫자가 k+1개인 경우
            String s = "";
            for(int j=0;j<num.length;j++){
                s+=num[j]; //저장된 숫자를 조합해
            }
            list.add(s); //리스트에 추가
            return;
        }
        for(int i=0;i<=9;i++){
            if(!visit[i]){ //방문하지 않은 경우
                if(number==0||check(num[number-1],i,c[number-1])){ //비었거나 check(부등호 관계)를 만족하는 경우
                    visit[i]=true; //방문 o
                    num[number]=i; //숫자 배열에 만족하는 수 i 저장
                    search(number+1);
                    visit[i]=false; //방문 x
                }
            }
        }
    }
}