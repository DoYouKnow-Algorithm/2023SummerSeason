using System;

namespace AlgorithmStudy
{
    class boj1709
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            long r = n / 2;
            int count = 0;
            long x = 0, y = r - 1;
            while (y >= 0)
            {
                long a = x * x + y * y, b = (x + 1) * (x + 1) + (y + 1) * (y + 1);  // 타일의 왼쪽 아래점 a, 오른쪽 위점 b의 원점으로부터 거리 계산(제곱근계산 제외)
                if (a < r * r && b > r * r)
                {
                    x++;
                    count++;
                }
                else if ((a < r * r && b < r * r) || a == r * r)
                    x++;
                else if ((a > r * r && b > r * r) || b == r * r)
                {
                    x--;
                    y--;
                }
            }
            Console.WriteLine(count * 4);
        }
    }
}
