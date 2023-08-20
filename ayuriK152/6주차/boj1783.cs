using System;

namespace AlgorithmStudy
{
    class boj1783
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int n = int.Parse(input[0]), m = int.Parse(input[1]);
            int result = 1;     // 나이트가 처음 존재하는 위치 기본 포함

            if (n == 2)         // 위아래로 한칸씩만 움직일 수 있을 때
                result += (m - 1) / 2 > 3 ? 3 : (m - 1) / 2;        // 가로로 2칸씩 움직였을 때 지나간 칸 수, 4번 이상 움직이면 무조건 3

            else if (n >= 3)    // 위아래 움직임 제약이 없을 때
            {
                if (m >= 7)     // 가로 칸이 7칸 이상이면 1번씩 다 움직일 수 있음, 이후는 최대한 많이 방문하기 위해 1씩 움직임.
                    result += m - 3;    // m칸 - (처음 있던 칸 1개) + (조건 만족을 위한 4번 이동) => m - 3;
                else
                    result += m >= 4 ? 3 : m - 1;   // 가로칸이 모자라서 조건 만족이 안되는 경우, 최대 3번 움직임
            }

            Console.WriteLine(result);
        }
    }
}
