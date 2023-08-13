import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 처리를 위한 StringBuilder
        StringBuilder resultSb = new StringBuilder(); // 최종 출력 처리를 위한 StringBuilder

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) { // T 가 0 이상일 경우에만 반복문 실행, T 값 1 감소
            sb.setLength(0); // sb clear

            char[] p = br.readLine().toCharArray(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수

            // 대괄호 & 콤마 처리
            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");

            Deque<Integer> deque = new LinkedList<>(); // 양방향 입출력을 위한 덱 선언
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(arr[i]));
            }

            boolean directionFlag = true; // flag -> true : 맨 왼쪽이 처음, flag -> false : 맨 오른쪽이 처음
            boolean emptyFlag = false; // 덱의 상태를 확인

            for (int i = 0; i < p.length; i++) {
                if (p[i] == 'R') { // R 함수 수행
                    directionFlag = !directionFlag; // 방향을 바꿈
                } else { // D 함수 수행
                    if (deque.isEmpty()) { // 덱이 상태가 비어있음
                        emptyFlag = true;
                        break; // 반복문을 빠져나감
                    }
                    if (directionFlag) { // 맨 왼쪽이 처음이면
                        deque.pollFirst(); // 덱의 왼쪽을 삭제
                    } else { // 맨 오른쪽이 처음이면
                        deque.pollLast(); // 덱의 오른쪽을 삭제
                    }
                }
            }

            // 최종 배열 상태 출력
            if (emptyFlag) {
                resultSb.append("error" + "\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (directionFlag) {
                        sb.append(deque.removeFirst());
                    } else {
                        sb.append(deque.removeLast());
                    }
                    if (deque.size() >= 1) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                resultSb.append(sb + "\n");
            }
        }
        System.out.print(resultSb);
    }
}
