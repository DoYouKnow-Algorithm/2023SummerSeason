package Q1709.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long radius_square;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int radius = n/2; // 반지름
        radius_square = (long)radius * radius; // 큰 정사각형 크기
        int temp = 1;
        int count = 0; // 원주에 걸치는 정사각형 개수를 셈

        // 원의 4분의 1만 확인한 후 곱하기 4해주기 중심을 x, y축으로 나눈다면 1사분면만 확인
        for(int y = radius; y>=0; y--){ // y 최대값부터 0까지
            for(int x=temp; x<=radius; x++){ // 1부터 최대값까지
                if(HasRadius(x,y)){ // 만족하면
                    count++; // 개수 세기
                    temp = x;
                } else{ // 원주에 걸치지 않으면
                    if(x != temp){ // x와 temp가 같지 않으면(해당 범위가 원주에 걸치지 않는다는 의미)
                        temp = x-1; // x 이전 값부터 다시 탐색 (같은 x값에 두칸 다 원주에 걸칠 수도 있기 때문)
                        break;
                    }
                }
            }
        }
        System.out.println(4*count); // 곱하기 4해서 출력
    }
    //작은 정사각형을 기준으로 왼쪽 아래 꼭지점(1)과 오른쪽 위 꼭지점(2)을 기준으로 해당하는 작은 정사각형이 원주에 걸치려면
    //1이 반지름의 길이보다 작고 2가 반지름의 길이보다 길면 원주에 걸치는 꼴이 된다.
    public static boolean HasRadius(long x, long y){
        return (x-1)*(x-1)+(y-1)*(y-1) < radius_square && x * x + y*y > radius_square;

    }
}
