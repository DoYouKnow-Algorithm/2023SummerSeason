

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-->0){ // 입력이 더 이상 없을 때까지
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<Integer>();

            for(int i=0; i<n; i++){ // 덱에 배열 원소 넣어줌
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(command, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String command, ArrayDeque<Integer>deque){
        boolean Right = true;

        for(char cmd : command.toCharArray()){
            if(cmd == 'R'){
                Right = !Right; // 방향을 바꿔줌
                continue;
            }

            if(Right){ //D이면서 Right가 true일 때 (방향을 바꾸지 않았으면)
                if(deque.pollFirst()==null){ //삭제할 원소가(맨앞) 없을 경우
                    sb.append("error\n");
                    return;
                }
            }
            else{ // 방향을 바꾼 경우에는
                if(deque.pollLast() == null){ // 삭제할 원소가 (맨뒤) 없을 경우
                    sb.append("error\n");
                    return;
                }
            }
        }
        printString(deque,Right);
    }

    public static void printString(ArrayDeque<Integer> deque, boolean Right){
        sb.append('[');
        if(deque.size() > 0){ // 출력할 원소가 한 개 이상이면
            if(Right){ // 순서가 바뀌지 않았으면
                sb.append(deque.pollFirst()); // 첫번째 원소 (맨앞) 넘겨줌

                while(!deque.isEmpty()){ // 순차적으로 (, + 원소) 넘김
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else{ // 순서가 바뀌었으면
                sb.append(deque.pollLast()); // 맨 뒤부터 첫번재 원소 넘겨줌
                while(!deque.isEmpty()){ // 순차적으로 (, + 원소) 넘김
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }
}
