using System;

namespace AlgorithmStudy
{
    class boj18221
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int[,] arr = new int[n, n];
            Pair proffesor = null, seong = null;
            string[] input;
            for (int i = 0; i < n; i++)
            {
                input = Console.ReadLine().Split(' ');
                for (int j = 0; j < n; j++)
                {
                    arr[j, i] = int.Parse(input[j]);
                    // 교수와 성규의 위치를 입력받는 동시에 저장
                    if (arr[j, i] == 2)
                        seong = new Pair(j, i);
                    else if (arr[j, i] == 5)
                        proffesor = new Pair(j, i);
                }
            }

            // 연구실 제안 여부 result, 거리를 구하기 위한 a와 b
            int result = 0, a = proffesor.x - seong.x, b = proffesor.y - seong.y;
            if (Math.Sqrt(a * a + b * b) >= 5)
            {
                // 직사각형 범위 내 탐색, 3 이상이면 result 1로 변경
                int count = 0;
                for (int i = proffesor.y > seong.y ? seong.y : proffesor.y; i < (proffesor.y < seong.y ? seong.y : proffesor.y) + 1; i++)
                {
                    for (int j = proffesor.x > seong.x ? seong.x : proffesor.x; j < (proffesor.x < seong.x ? seong.x : proffesor.x) + 1; j++)
                    {
                        if (arr[j, i] == 1)
                            count++;
                    }
                }
                if (count >= 3)
                    result = 1;
            }

            Console.WriteLine(result);
        }

        // 좌표 저장용 클래스
        class Pair
        {
            public int x, y;

            public Pair(int _x, int _y)
            {
                x = _x;
                y = _y;
            }
        }
    }
}
