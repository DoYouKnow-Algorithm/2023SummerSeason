using System;

namespace AlgorithmStudy
{
    class boj18187
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int count = 1;
            // i번째 영역의 개수 = i-1번째 영역의 개수 + 이번 직선의 기울기와 다른 기울기의 직선 수
            // https://10cheon00.tistory.com/20 참고했음
            for (int i = 0; i < n; i++)
            {
                count += 1 + i - i / 3;
            }
            Console.WriteLine(count);
        }
    }
}
