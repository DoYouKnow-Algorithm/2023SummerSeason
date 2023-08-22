import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        // 수의 개수
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {                    // 입력한 수를 배열에 저장
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);                               // 배열 정렬

        int[] result = new int[6];                      // 6개까지만 저장
        int index = 0;                                  // 인덱스 설정
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(index == 6) {                        // 6개가 넘어가면 반복문 돌릴 필요 없음
                    break;
                }
                // 가장 작은 수들로만 구성을 하며 a1a2와 a2a1은 각각 다른 수이기 때문에 순서도 바꿔가며 저장
                result[index++] = Integer.parseInt(arr[i] + "" + arr[j]);
                result[index++] = Integer.parseInt(arr[j] + "" + arr[i]);
            }
        }

        Arrays.sort(result);                            // 해당 배열을 정렬

        System.out.println(result[2]);                  // 세번째로 작은 수를 출력
        br.close();
    }
}