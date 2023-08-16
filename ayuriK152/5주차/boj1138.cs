using System;
using System.Collections.Generic;
using System.Text;

namespace AlgorithmStudy
{
    class boj1138
    {
        public static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder();
            int n = int.Parse(Console.ReadLine());
            int[] arr = new int[n];                             // 입력 값 저장용 배열
            List<int> indexes = new List<int>();                // 인덱스 저장용 리스트
            string[] input = Console.ReadLine().Split(' ');
            for (int i = 0; i < n; i++)
            {
                arr[i] = int.Parse(input[i]);
                indexes.Add(i);                                 // 리스트 초기화
            }

            int[] result = new int[n];                          // 결과 출력용 배열
            for (int i = 0; i < n; i++)
            {
                result[indexes[arr[i]]] = i + 1;                // 리스트에 남은 인덱스 중에서 왼쪽에 있는 숫자를 인덱스로 하는 값을 인덱스로 배열에 저장
                indexes.RemoveAt(arr[i]);                       // 리스트에서 가져간 값 제거
            }

            foreach (int i in result)
                sb.Append(i + " ");
            Console.Write(sb);
        }
    }
}
