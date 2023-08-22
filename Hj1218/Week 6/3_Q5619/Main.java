import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //수의 개수
        int []num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=in.nextInt();
        }
        Arrays.sort(num); //오름차순 정렬
        ArrayList<Integer> list = new ArrayList<>();
        if(n==3){
            System.out.println(num[1]+""+num[0]);
        }
        else{ //n이 4 이상인 경우
            for(int i=0;i<4;i++){
                for(int j=i+1;j<4;j++){
                    list.add(Integer.valueOf(num[i]+""+num[j])); //다른 두 수 조합 리스트에 추가
                    list.add(Integer.valueOf(num[j]+""+num[i])); //순서 바꿔 리스트에 추가
                }
            }
            Collections.sort(list); //리스트 정렬
            System.out.println(list.get(2)); //세 번째로 작은 수 출력
        }
    }
}