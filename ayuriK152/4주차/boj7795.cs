using System;
using System.IO;
using System.Text;

namespace AlgorithmStudy
{
    class boj7795
    {
        public static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder();
            int t = int.Parse(Console.ReadLine());
            while (t > 0)
            {
                string[] input = Console.ReadLine().Split(' ');
                int n = int.Parse(input[0]), m = int.Parse(input[1]);
                int[] a = new int[n];
                int[] b = new int[m];

                input = Console.ReadLine().Split(' ');
                for (int i = 0; i < n; i++)
                    a[i] = int.Parse(input[i]);

                input = Console.ReadLine().Split(' ');
                for (int i = 0; i < m; i++)
                    b[i] = int.Parse(input[i]);
                Array.Sort(a);
                Array.Sort(b);

                int pivotN = 0, pivotM = 0, count = 0;
                while (pivotN < n && pivotM < m)
                {
                    if (a[pivotN] > b[pivotM])      // 현재 A가 B보다 더 큰 경우 -> 조건에 부합하는 경우
                    {
                        if (pivotM < m - 1)     // B의 인덱스가 마지막이 아니면 늘려서 다시 비교
                        {
                            pivotM++;
                            continue;
                        }
                        else    // 마지막이면 더이상 이후에 A에 남은 수들은 비교하지 않아도 B의 모든 수들보다 큼, B의 수 갯수만큼 카운트
                            count += pivotM + 1;
                    }
                    else if (a[pivotN] <= b[pivotM])    // 현재 A보다 B가 더 큰 경우 -> 조건에 부합하지 않는 경우
                    {
                        count += pivotM;    // 현재 B 인덱스가 현재 A보다 작인 B의 갯수
                    }
                    pivotN++;
                }
                sb.AppendLine(count.ToString());
                t--;
            }
            Console.WriteLine(sb);
        }
    }
}
