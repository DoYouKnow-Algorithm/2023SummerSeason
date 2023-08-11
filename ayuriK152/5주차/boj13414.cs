using System;
using System.Collections.Generic;
using System.Text;

namespace AlgorithmStudy
{
    class boj13414
    {
        public static void Main(string[] args)
        {
            StringBuilder sb = new StringBuilder();
            string[] input = Console.ReadLine().Split(' ');
            int k = int.Parse(input[0]), l = int.Parse(input[1]);
            Dictionary<string, int> dic = new Dictionary<string, int>();    // 해당 학번이 몇번 수강신청했는지 저장할 딕셔너리
            List<string> list = new List<string>();     // 실제 신청한 순서대로 저장할 리스트

            for (int i = 0; i < l; i++)
            {
                string temp = Console.ReadLine();
                list.Add(temp);
                if (dic.ContainsKey(temp))      // 이미 해시가 존재하는 값이면 횟수 증가
                    dic[temp]++;
                else
                    dic.Add(temp, 1);
            }

            int count = 0;
            for (int i = 0; i < l; i++)
            {
                if (count >= k)     // k번째 학번까지만 받고 종료
                    break;
                if (dic[list[i]] == 1)      // 중복된 경우가 더이상 없으면 출력
                {
                    sb.AppendLine(list[i]);
                    count++;
                }
                else        // 중복된 경우가 있다면 횟수 감소 및 다음번째 학생 검사
                    dic[list[i]]--;
            }
            Console.Write(sb);
        }
    }
}
