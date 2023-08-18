import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next(); //민겸수
        System.out.println(checkMax(s)); //가장 큰 값
        System.out.println(checkMin(s)); //가장 작은 값
    }
    static String checkMin(String s){ //가장 작은 값
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='M'){
                if(i>0&&s.charAt(i-1)=='M'){ //M이 연속되는 경우
                    sb.append(0);
                }
                else{ //M이 연속되지 않는 경우
                    sb.append(1);
                }
            }
            else{
                sb.append(5);
            }
        }
        return sb.toString();
    }
    static String checkMax(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) == 'M') { //K가 존재할 때까지 카운트 증가
                count++;
            }
            else{
                sb.append(5);
                for(int j=0;j<count;j++){
                    sb.append(0); //카운트 증가한만큼 0출력
                }
                count=0; //카운트 초기화
            }
        }
        if(count!=0){ //K가 존재할 때까지 기다린 M 갯수가 존재하면
            for(int i=0;i<count;i++){
                sb.append(1);
            }
        }
        return sb.toString();
    }
}