import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []num= new int[101];
        num[1]=2;
        num[2]=4;
        int count = 3;
        for(int i=3;i<=n;i++){
            num[i]=num[i-1]+count;
            if(i%3!=0){
                count+=1;
            }
        }
        System.out.print(num[n]);
    }
}