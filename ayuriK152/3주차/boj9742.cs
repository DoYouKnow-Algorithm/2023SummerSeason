using System;
using System.Collections.Generic;

namespace AlgorithmStudy
{
    class boj9742
    {
        static string input, result;
        static int n, count;
        static bool[] check;

        public static void Main(string[] args)
        {
            while (true)
            {
                string temp = Console.ReadLine();
                if (temp == null)
                    break;
                count = 0;
                input = temp.Split(' ')[0];
                n = int.Parse(temp.Split(' ')[1]);
                check = new bool[input.Length];
                result = "No permutation";

                Search(0, "");
                Console.WriteLine($"{temp} = {result}");
            }
        }

        static bool Search(int cnt, string str)     // 백트래킹 메소드
        {
            if (cnt == input.Length)    // 길이 충족 조건
            {
                if (count == n - 1)     // 원하는 위치와 일치 조건, 참이라면 true 반환 종료
                {
                    result = str;
                    return true;
                }
                count++;
            }
            else
            {
                for (int i = 0; i < input.Length; i++)
                {
                    if (check[i])
                        continue;
                    check[i] = true;
                    if (Search(cnt + 1, str + input[i]))    // 메소드 반환값이 true면 true 반환 종료
                        return true;
                    check[i] = false;
                }
            }
            return false;
        }
    }
}
