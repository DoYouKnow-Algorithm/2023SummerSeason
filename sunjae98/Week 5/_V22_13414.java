import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 수강 가능 인원
        int L = Integer.parseInt(st.nextToken()); // 대기 목록 길이

        LinkedHashSet<String> set = new LinkedHashSet<>(); // 수강신청 대기열(중복x, 순서o)
        for (int i = 0; i < L; i++) {
            String student = br.readLine();
            if (set.contains(student)) { // 이미 버튼을 눌렀다면
                set.remove(student); // 기존 대기열에서 제거
            }
            set.add(student); // 대기열에 추가
        }

        Iterator iter = set.iterator(); // Iterator 를 사용하여 HashSet 배열 출력

        for (int i = 0; i < K; i++) {  // 수강 정원까지 출력
            if (!iter.hasNext()) { // 수강 정원보다 대기열이 적으면
                break; //반복문을 빠져나감
            }
            else{
                System.out.print(iter.next() + "\n");
            }
        }
    }
}
