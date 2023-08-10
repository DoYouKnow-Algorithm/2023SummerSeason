using System;

namespace AlgorithmStudy
{
    class boj2230
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int n = int.Parse(input[0]), m = int.Parse(input[1]);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = int.Parse(Console.ReadLine());
            Array.Sort(arr);

            int pivotL = 0, pivotR = 1, result = -1;
            while (pivotR < n)
            {
                int current = arr[pivotR] - arr[pivotL];    // 수열 차이 계산
                if (current < m)    // 차이가 m을 못넘어가면 pivotR 증가
                {
                    pivotR++;
                }
                else if (current >= m)      // 차이가 넘어가는 경우
                {
                    if (result == -1 || result > current)   // result가 초깃값이거나 차이가 원래 result값보다 작은경우만 갱신
                        result = current;
                    pivotL++;       // pivotL과 pivotR이 중복되지 않도록 증가
                    if (pivotR == pivotL)
                        pivotR++;
                }
            }
            Console.WriteLine(result);
        }
    }
}
