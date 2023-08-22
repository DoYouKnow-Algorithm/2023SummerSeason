using System;

namespace AlgorithmStudy
{
    class boj17392
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int n = int.Parse(input[0]), m = int.Parse(input[1]);
            long count = m;         // 우울한날 카운트용
            if (n > 0)
                input = Console.ReadLine().Split(' ');
            for (int i = 0; i < n; i++)
            {
                count -= int.Parse(input[i]) + 1;
            }

            if (count > n) count++;     // n보다 더 커지면 가장 앞날도 채워야하는데 0부터 시작해야하므로 카운트 한 번 더해줌

            long[] space = new long[n + 1];     // 사이사이 빈공간용
            space[n] = -1;          // 표현은 배열의 마지막이지만 n보다 우울한 날이 많아지는 경우의 가장 앞날임. -1로 시작해서 바로 1더해줌 -> 0시작
            int index = 0;
            long result = 0;        // 결과 저장용 변수
            for (int i = 0; i < count; i++)
            {
                space[index] += 1;      // 빈공간에 우울한날 적립
                result += space[index] * space[index];      // 적립한 값 제곱해서 결과값에 더하기
                if (index == n && space[index] == 0)        // 가장 앞날을 처음 채운경우 얘를 바로 다음에 한번 더 채워야 최솟값이므로 continue
                    continue;
                index = index < n ? index + 1 : 0;          // 인덱스 뺑뺑이용
            }
            Console.WriteLine(result);
        }
    }
}
