using System;
using System.Collections.Generic;

namespace AlgorithmStudy
{
    class boj5619
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = int.Parse(Console.ReadLine());
            Array.Sort(arr);        // 입력값 오름차순 정렬
            List<int> selected = new List<int>(new int[] { arr[0], arr[1], arr[2] });   // 초기값 작은순으로 앞에서 3개

            if (n > 3) selected.Add(arr[3]);    // n이 4이상이면 4번째 수도 추가

            int[] result = n > 3 ? new int[12] : new int[6];    // 선택한 값의 조합 수에따른 결과 배열
            int index = 0;
            for (int i = 0; i < selected.Count; i++)
            {
                for (int j = 0; j < selected.Count; j++)
                {
                    if (i == j)
                        continue;
                    result[index++] = int.Parse($"{selected[i]}{selected[j]}");     // 숫자들을 조합해서 배열에 저장
                }
            }
            Array.Sort(result);         // 오름차순 정렬 후 3번째 값 출력
            Console.Write(result[2]);
        }
    }
}
