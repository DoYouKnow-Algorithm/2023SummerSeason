import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //그림을 그려 규칙성 파악
        //1 일때 1개 면을 절반으로 나눔 : 1 + 1 = 2개
        //2 일때 2개 면을 절반으로 나눔 : 2 + 2 = 4개
        //3 일때 3개 면을 절반으로 나눔 : 4 + 3 = 7개
        //4 일때 3개 면을 절반으로 나눔 : 7 + 3 = 10개 d
        //5 일때 4개 면을 절반으로 나눔 : 10 + 4 = 14개
        //6 일때 5개 면을 절반으로 나눔 : 14 + 5 = 19개
        //규칙을 바탕으로 점화식을 작성
        //123 345 567 789 순으로 늘어남

        int N = Integer.parseInt(br.readLine());
        int k = 0;
        int sum = 1; // 최초의 평면 1개
        int[] arr = new int[N+1];

        //k = N / 3;
        //000 111 222 333

        for (int i = 1; i <= N; i++) {
            arr[i] = i - k;
            sum += arr[i];
            k = i / 3;
        }

        System.out.print(sum);
    }
}
