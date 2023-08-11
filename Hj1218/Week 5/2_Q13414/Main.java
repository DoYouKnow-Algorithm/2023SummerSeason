import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt(); //수강 가능 인원
        int l = in.nextInt(); //대기목록의 길이
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i=0;i<l;i++){
            String s = in.next();
            if(set.contains(s)){ //이미 있는 경우
                set.remove(s); //제거
            }
            set.add(s); //추가
        }
        int count = 0;
        Iterator<String> iter = set.iterator();
        //Set은 인덱스를 통해 객체를 가져올 수 없기 때문에 Iterator(반복자) 사용
        for(int i=0;i<set.size();i++){
            if(count==k){ //수강 가능 인원이 다 찬 경우
                break;
            }
            System.out.println(iter.next()); //하나의 객체를 가져옴
            count++; //수강인원 증가
        }
    }
}