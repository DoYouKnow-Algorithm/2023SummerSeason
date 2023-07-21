using System;

namespace AlgorithmStudy
{
    class boj6600
    {
        public static void Main(string[] args)
        {
            while (true)
            {
                string input = Console.ReadLine();
                if (input == null) break;
                string[] positions = input.Split(' ');
                // 입력받은 좌표들 저장용 변수
                double x1 = double.Parse(positions[0]), y1 = double.Parse(positions[1]),
                    x2 = double.Parse(positions[2]), y2 = double.Parse(positions[3]),
                    x3 = double.Parse(positions[4]), y3 = double.Parse(positions[5]);
                // 원점 저장용 변수
                double p, q;
                // 기울기 구하기, 첫번째 좌표와 두번째 좌표에 대해 하나, 두번째 좌표와 세번째 좌표에 대해 하나
                double a1 = -(x1 - x2) / (y1 - y2), a2 = -(x2 - x3) / (y2 - y3);
                // 일차방정식 y = ax - c에서 c를 구하는 과정, 이 역시 좌표 쌍마다 하나
                double c1 = a1 * ((x1 + x2) / 2) - (y1 + y2) / 2, c2 = a2 * ((x2 + x3) / 2) - (y2 + y3) / 2;
                // 각 일차방정식이 x축이나 y축에 평행한 경우의 예외를 거르는 곳, 세 점이 평행하는 경우가 없으므로 한 쌍의 예외가 발생하면 다른 쌍의 값을 대입해줌
                // 예를 들어 첫째 좌표쌍이 y축에 평행한 경우, x = a 꼴이 될 것, 원점의 x좌표는 a로 고정하되 후에 y좌표를 구하는데 a1과 c1을 사용하므로 a2와 c2로 바꿔줌
                if (y1 - y2 == 0) { p = (x1 + x2) / 2; a1 = a2; c1 = c2; }
                else if (y2 - y3 == 0) { p = (x2 + x3) / 2; a2 = a1; c2 = c1; }
                else p = (c1 - c2) / (a1 - a2);
                if (x1 - x2 == 0) q = (y1 + y2) / 2;
                else if (x2 - x3 == 0) q = (y2 + y3) / 2;
                else q = a1 * p - c1;
                // 구한 값을 토대로 반지름 r을 구하고, 원주 = 2 * r * Pi 공식을 사용해서 답을 구함
                double r = Math.Sqrt(Math.Pow(p - x1, 2) + Math.Pow(q - y1, 2));
                double result =  Math.PI * r * 2;
                Console.WriteLine(Math.Round(result, 2));
            }
        }
    }
}
