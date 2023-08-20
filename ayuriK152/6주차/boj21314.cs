using System;
using System.Text;

namespace AlgorithmStudy
{
    class boj21314
    {
        public static void Main(string[] args)
        {
            StringBuilder max = new StringBuilder();
            StringBuilder min = new StringBuilder();
            string[] input = Console.ReadLine().Split('K');     // 입력을 받고 K를 기준으로 나눔, 끝자리가 K면 마지막에 공백 문자열이 생김

            for (int i = 0; i < input.Length; i++)      // 최댓값 문자열 구하기
            {
                if (i == input.Length - 1)
                {
                    if (input[i] != "")     // 나눈 문자열의 마지막이 K가 아닌 경우
                    {
                        for (int j = 0; j < input[i].Length; j++)       // M 갯수만큼 1로 도배
                            max.Append(1);
                    }
                    else        // 마지막이 K인 경우
                        max.Append(5);      // 그냥 5로
                }
                else
                {
                    max.Append(5);      // 최댓값이 되려면 M뒤에 K가 오는경우는 다 5 * 10 ^ n 꼴로 해야함, 일단 5 추가
                    for (int j = 0; j < input[i].Length; j++)       // 자릿수만큼 0 추가
                        max.Append(0);

                    if (i == input.Length - 2 && input[input.Length - 1] == "")     // 현재 M 문자열인데 마지막 직전이고, 마지막이 K인 경우 종료
                        break;
                }
            }

            for (int i = 0; i < input.Length; i++)      // 최솟값 문자열 구하기
            {
                if (input[i] != "")     // 공백이 아닌경우 -> M인경우 -> 10 ^ n 꼴
                {
                    min.Append(1);      // 첫자리 1 추가
                    for (int j = 0; j < input[i].Length - 1; j++)
                        min.Append(0);      // 0으로 메꾸기
                }
                if (i < input.Length - 1)
                    min.Append(5);      // K를 기준으로 나눈거니까, 마지막 문자열 전까지 뒤에 5를 붙여줌
            }

            Console.Write($"{max}\n{min}");
        }
    }
}
