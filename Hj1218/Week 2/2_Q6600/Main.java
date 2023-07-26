import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextDouble()){
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double x2 = in.nextDouble();
            double y2 = in.nextDouble();
            double x3 = in.nextDouble();
            double y3 = in.nextDouble();
            //세 변의 길이
            double d1 = getDistance(x1,y1,x2,y2);
            double d2 = getDistance(x2,y2,x3,y3);
            double d3 = getDistance(x1,y1,x3,y3);

            double s = (d1+d2+d3)/2; //삼각형 둘레/2
            double R = (d1*d2*d3)/(4*Math.sqrt(s*(s-d1)*(s-d2)*(s-d3))); //반지름 = 세 변의 곱 / 4 * 삼각형의 넓이
            double A = R*2*Math.PI; //원의 원주
            A = Math.round(A*100)/100.0; //반올림
            System.out.println(A);
        }
    }
    static double getDistance(double a, double b, double aa, double bb){ //(a,b)와 (aa,bb)간의 거리 구하기
        double d;
        double x,y;
        x = Math.pow((bb-b),2);
        y = Math.pow((aa-a),2);
        d = Math.sqrt(x+y);
        return d;
    }
}
