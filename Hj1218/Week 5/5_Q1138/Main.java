import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //사람의 수
        int [] num = new int[n]; //줄을 선 순서
        for(int i=0;i<n;i++){
            int left = in.nextInt(); //왼쪽에 존재하는 사람 수
            for(int j=0;j<n;j++){
                if(left==0){ //왼쪽에 아무도 없는 경우
                    if(num[j]==0){ //순서 배열에 아무도 없는 경우 (존재하는 경우는 다음 배열에 저장)
                        num[j]=i+1; //해당 사람의 키 배열에 저장
                        break;
                    }
                }
                else if(num[j]==0){ //자신보다 큰 사람이 존재하는 경우 자리 비워주고 left 줄여줌
                    left--;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(num[i]+" ");
        }
    }
}