import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static String p;
    static Deque<Integer> deque;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        sb = new StringBuilder();
        int t = in.nextInt(); //테스트 케이스 개수
        for(int i=0;i<t;i++){
            p = in.next(); //수행할 함수
            int n = in.nextInt(); //배열에 들어있는 수의 개수
            String s = in.next(); //정수 배열
            String ss = s.substring(1,s.length()-1); //정수배열 인덱스 1 ~ 마지막-1까지의 값
            String []num; //정수 배열 s에서 [ , ] 를 제외한 정수 배열
            num = ss.split(",");
            deque = new ArrayDeque<>();
            for(int j=0;j<n;j++){
                deque.add(Integer.valueOf(num[j])); //deque에 정수배열 num 추가
            }
            ac(p,deque);
        }
        System.out.println(sb);
    }
    static void ac(String pp, Deque<Integer> dq){
        boolean check = true; //방향
        for(int i=0;i<pp.length();i++){
            if(pp.charAt(i)=='R'){ //R인 경우
                check = !check; //반대 방향
            }
            else{ //D인 경우
                if(check){ //정방향인 경우
                    if(dq.isEmpty()){ //비어있는 경우 에러
                        sb.append("error").append("\n");
                        return;
                    }
                    dq.pollFirst();
                }
                else{ //역방향인 경우
                    if(dq.isEmpty()){ //비어있는 경우 에러
                        sb.append("error").append("\n");
                        return;
                    }
                    dq.pollLast();
                }
            }
        }
        sb.append('[');
        if(!dq.isEmpty()){
            if(check){ //정방향인 경우
                sb.append(dq.pollFirst());
                while(!dq.isEmpty()){
                    sb.append(",").append(dq.pollFirst());
                }
            }
            else{ //역방향인 경우
                sb.append(dq.pollLast());
                while(!dq.isEmpty()){
                    sb.append(",").append(dq.pollLast());
                }
            }
        }
        sb.append(']').append("\n");
    }
}