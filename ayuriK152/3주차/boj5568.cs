using System;
using System.Collections.Generic;

namespace AlgorithmStudy
{
    class boj5568
    {
        static HashSet<string> list = new HashSet<string>();    // Hash는 중복값을 허용하지 않는 원리를 이용, 따로 검사하는 수고를 덜 수 있음.
        static int n;
        static int k;
        static string[] nums;
        static bool[] check;    // 문자열 중복선택 방지용 bool배열
        public static void Main(string[] args)
        {
            n = int.Parse(Console.ReadLine());
            k = int.Parse(Console.ReadLine());
            nums = new string[n];
            check = new bool[n];
            for (int i = 0; i < n; i++)
                nums[i] = Console.ReadLine();
            Assemble(0, "");
            Console.WriteLine(list.Count);
        }

        static void Assemble(int len, string str)   // 재귀식으로 백트래킹 구현
        {
            if (len == k)
                list.Add(str);
            else
            {
                for (int i = 0; i < n; i++)
                {
                    if (check[i])
                        continue;
                    check[i] = true;
                    Assemble(len + 1, str + nums[i]);
                    check[i] = false;
                }
            }
        }
    }
}
