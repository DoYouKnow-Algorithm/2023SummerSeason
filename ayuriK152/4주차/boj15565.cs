using System;
using System.Collections.Generic;

namespace AlgorithmStudy
{
    class boj15565
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int n = int.Parse(input[0]), k = int.Parse(input[1]);
            List<int> ryanIndex = new List<int>();
            input = Console.ReadLine().Split(' ');
            for (int i = 0; i < n; i++)
                if (input[i] == "1")    // 라이언 인형일 때 해당 인덱스만을 저장
                    ryanIndex.Add(i);

            int result = -1;
            if (ryanIndex.Count >= k)   // 라이언 인형이 k값보다 작으면 -1인 경우이므로 실행할 이유가 없음
                for (int i = 0; i + k - 1 < ryanIndex.Count; i++)   // k - 1 간격의 인덱스로 사이 거리를 비교하면서 최솟값 찾기
                    if (ryanIndex[i + k - 1] - ryanIndex[i] + 1 < result || result == -1)
                        result = ryanIndex[i + k - 1] - ryanIndex[i] + 1;

            Console.WriteLine(result);
        }
    }
}
