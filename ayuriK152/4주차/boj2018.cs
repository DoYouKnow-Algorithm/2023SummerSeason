using System;

namespace AlgorithmStudy
{
    class boj2018
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int count = 1;
            for (int i = 1; i <= n / 2; i++)
            {
                for (int j = i + 1; j <= n / 2 + 1; j++)
                {
                    int temp = (j + i) % 2 == 0 ? (j + i) * (j - (j + i) / 2) + (j + i) / 2 : (j + i) * (j - (j + i) / 2);  // 한번 계산하고 계속 써먹기
                    if (temp == n)     // n과 같은 경우 count를 늘리고 두번째 포인터 반복문 종료
                    {
                        count++;
                        break;
                    }
                    else if (temp > n)      // n을 초과하는 경우 그냥 종료
                    {
                        break;
                    }
                }
            }

            Console.WriteLine(count);
        }
    }
}
