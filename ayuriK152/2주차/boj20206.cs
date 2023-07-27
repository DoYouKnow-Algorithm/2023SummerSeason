using System;

namespace AlgorithmStudy
{
    class boj20206
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int a = int.Parse(input[0]), b = int.Parse(input[1]), c = int.Parse(input[2]);
            input = Console.ReadLine().Split(' ');
            int[] xPos = new int[2];
            int[] yPos = new int[2];
            xPos[0] = int.Parse(input[0]); xPos[1] = int.Parse(input[1]);
            yPos[0] = int.Parse(input[2]); yPos[1]= int.Parse(input[3]);

            // 선분을 긋고 영역의 모서리를 돌면서 해당 점이 선분 위에 있는지 아래있는지 카운트, 또 그냥 모서리를 지나가는 횟수 카운트
            int result = 0, zeroCount = 0;
            bool flag = false;
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    if (a * xPos[i] + b * yPos[j] + c < 0)
                        result--;
                    else if (a * xPos[i] + b * yPos[j] + c > 0)
                        result++;
                    else if (a * xPos[i] + b * yPos[j] + c == 0)
                        zeroCount++;
                }
            }

            // 모든 점이 한 방향으로 치우쳐져있거나, 모서리 하나를 지나면서 나머지 세 점이 한방향으로 치우쳐져있거나, 모서리 두개를 지나면서 두 점이 한방향으로 치우쳐져있으면 Lucky
            if ((result == -4 || result == 4) || (zeroCount == 1 && (result % 2 == 1 || result % 2 == -1)) || (zeroCount == 2 && (result == 2 || result == -2)))
                Console.WriteLine("Lucky");
            else
                Console.WriteLine("Poor");
        }
    }
}
