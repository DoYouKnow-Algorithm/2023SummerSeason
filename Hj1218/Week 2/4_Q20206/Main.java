import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //ax + by + c = 0
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int x1 = in.nextInt();
        int x2 = in.nextInt();
        int y1 = in.nextInt();
        int y2 = in.nextInt();
        //by = -ax -c
        int xMin = Math.min(-1*a*x1-c,-1*a*x2-c); //우변의 최소
        int xMax = Math.max(-1*a*x1-c,-1*a*x2-c); //우변의 최대
        int yMin = Math.min(b*y1,b*y2); //좌변의 최소
        int yMax = Math.max(b*y1,b*y2); //좌변의 최대

        //우변의 최소 >= 좌변의 최대 or 우변의 최대 <= 좌변의 최소
        //위험지역 통과
        if(xMin>=yMax||xMax<=yMin){
            System.out.println("Lucky");
        }
        else{
            System.out.println("Poor");
        }
    }
}
