using System;

namespace AlgorithmStudy
{
    class boj1940
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int m = int.Parse(Console.ReadLine());
            int[] arr = new int[n];
            string[] input = Console.ReadLine().Split(' ');
            for (int i = 0; i < n; i++)
                arr[i] = int.Parse(input[i]);
            Array.Sort(arr);    // 투포인터 적용을 위한 오름차순 정렬
            int pivotL = 0, pivotR = n - 1, count = 0;
            while (pivotL < pivotR)     // 투포인터 탐색
            {
                if (arr[pivotL] + arr[pivotR] < m)  // 합이 작으면 왼쪽 피벗 증가
                    pivotL++;
                else if (arr[pivotL] + arr[pivotR] > m)     // 합이 크면 오른쪽 피벗 증가
                    pivotR--;
                else if (arr[pivotL] + arr[pivotR] == m)    // 고유번호이므로 중복경우X, 양쪽 피벗 줄이기 + 카운트
                {
                    pivotL++;
                    pivotR--;
                    count++;
                }
            }
            Console.WriteLine(count);
        }
    }
}
