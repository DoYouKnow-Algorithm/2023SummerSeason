using System;

namespace AlgorithmStudy
{
    class boj1182
    {
        static int[] arr;
        static int n, s, count = 0;
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            n = int.Parse(input[0]); s = int.Parse(input[1]);
            arr = new int[n];
            input = Console.ReadLine().Split(' ');
            for (int i = 0; i < n; i++)
                arr[i] = int.Parse(input[i]);

            Search(0, 0);
            if (s == 0) count -= 1;     // 원하는 답이 0인 경우, 모든 수를 선택하지 않는 경우가 있으므로 -1
            Console.WriteLine(count);
        }

        static void Search(int idx, int sum)
        {
            if (sum == s && idx == n)   // 수열을 모두 탐색했고, 원하는 답을 얻은 경우
                count++;
            else if (idx < n)       // 그렇지 못한 경우, 수열의 크기를 넘어가지 않는 조건 하에 탐색
            {
                Search(idx + 1, sum + arr[idx]);
                Search(idx + 1, sum);
            }
        }
    }
}
