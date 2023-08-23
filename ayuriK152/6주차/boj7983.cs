using System;
using System.Collections.Generic;

namespace AlgorithmStudy
{
    class boj7983
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<Pair> pairs = new List<Pair>();
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine().Split(' ');
                pairs.Add(new Pair(int.Parse(input[0]), int.Parse(input[1])));
            }
            pairs.Sort();       // t기준 내림차순 정렬

            int remain = pairs[0].t;    // 남은 일수 저장용, 초기값은 가장 큰 t값을 가져옴
            for (int i = 0; i < n; i++)
            {
                int diff = remain - pairs[i].t;     // 남은 일 수와의 차이
                remain -= diff > 0 ? diff : 0 ;     // 차이가 0보다 크면 반영, 아니면 그대로 둠
                remain -= pairs[i].d;               // 과제에 드는 시간만큼 빼줌
            }
            Console.WriteLine(remain);          // 최종적으로 연속으로 쉴 수 있는 남은날 출력
        }

        class Pair : IComparable<Pair>      // 값 저장용 클래스, t 기준 정렬 인터페이스 상속
        {
            public int d, t;

            public Pair(int _d, int _t)
            {
                d = _d;
                t = _t;
            }

            public int CompareTo(Pair other)
            {
                return -t.CompareTo(other.t);
            }
        }
    }
}
