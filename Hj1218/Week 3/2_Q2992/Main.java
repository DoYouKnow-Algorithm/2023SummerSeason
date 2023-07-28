import java.util.Scanner;

public class Main {
    static String x;
    static int min;
    static char arr[], list[];
    static boolean visit[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        x = in.next(); //주어진 정수 x
        arr = x.toCharArray(); //x를 char 배열에 저장
        visit = new boolean[arr.length]; //방문 여부
        list = new char[arr.length];
        check(0);
        if(min>Integer.parseInt(x)){ //구성이 같으면서 가장 작은 수가 x보다 큰 경우
            System.out.println(min);
        }
        else { //존재하지 않는 경우
            System.out.println(0);
        }
    }
    static void check(int count){
        if(count == list.length){ //x와 자리수가 같으면
            String sum="";
            for(int j=0;j<list.length;j++){
                sum+=list[j]; //배열에 저장된 숫자 순서대로 조합
            }
            if(Integer.parseInt(sum)>Integer.parseInt(x)){ //조합된 수가 x보다 큰 경우
                if(min==0){
                    min = Integer.parseInt(sum);
                }
                min = Math.min(min,Integer.parseInt(sum)); //작은 값 구하기
            }
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visit[i]){ //방문하지 않은 경우
                visit[i]=true; //방문 o
                list[count]=arr[i]; //배열에 해당 숫자 저장
                check(count+1);
                visit[i]=false; //방문 x
            }
        }
    }
}