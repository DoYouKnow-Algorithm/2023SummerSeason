import java.util.Arrays;
import java.util.Scanner;

class Homework implements Comparable<Homework>{
    int d; //소요일
    int t; //마감일
    Homework(int d, int t){
        this.d = d;
        this.t = t;
    }
    @Override
    public int compareTo(Homework o){ //내림차순 정렬
        return o.t - this.t;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Homework[] hw = new Homework[n];
        for(int i=0;i<n;i++){
            int di = in.nextInt(); //소요일
            int ti = in.nextInt(); //마감일
            hw[i]=new Homework(di,ti);
        }
        Arrays.sort(hw);
        int day = hw[0].t; //가장 늦은 마감일
        for(int i=0;i<n;i++){
            if(day<hw[i].t){ //ex) 이전 과제 시작일 7 < 현재 과제 마감일 8
                day -= hw[i].d; //현재 과제 시작일 = 이전 과제 시작일 7 - 현재 과제 소요일 d
            }
            else{ //이전 과제 시작일이 현재 과제 마감일보다 뒤에 있는 경우
                day = hw[i].t-hw[i].d; //현재 과제 시작일 = 현재 과제 시작일 t - 현재 과제 소요일 d
            }
        }
        System.out.println(day);
    }
}