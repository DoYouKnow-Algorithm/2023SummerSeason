using System;

namespace AlgorithmStudy
{
    class boj2529
    {
        static int k;
        static string[] sign;
        static bool[] check = new bool[10];
        public static void Main(string[] args)
        {
            k = int.Parse(Console.ReadLine());
            sign = new string[k];
            string[] input = Console.ReadLine().Split(' ');
            for (int i = 0; i < k; i++)
                sign[i] = input[i];

            Console.WriteLine(SearchDown(0, -1));
            for (int i = 0; i < 10; i++)    // 체크용 bool배열 초기화
                check[i] = false;
            Console.WriteLine(SearchUp(0, -1));
        }

        static string SearchDown(int cnt, int num)      // 내림차순(큰수 구하기) 탐색 메소드
        {
            if (cnt == k)       // 최대 길이에 도달하면 num을 string으로 반환
                return num.ToString();
            for (int i = 9; i >= 0; i--)
            {
                if (check[i])
                    continue;
                if ((sign[cnt] == ">" && num > i) || (sign[cnt] == "<" && num < i) || num == -1)    // 등호 조건에 부합하거나 초깃값인 경우
                {
                    check[i] = true;
                    string temp;
                    if (num == -1) temp = SearchDown(cnt, i);   // 초깃값인 경우 cnt를 늘리지 않고 그대로 넘겨줌, 문자열이 등호보다 1만큼 더 길기 때문
                    else temp = SearchDown(cnt + 1, i);         // 초깃값이 아니면 cnt + 1
                    if (temp != "")     // 반환값이 공백이 아닌 경우
                    {
                        if (cnt + 1 == k) return $"{i}";    // 최대길이에 도달한 경우는 i값만을 반환
                        else return $"{i}{temp}";           // 최대길이가 아닌 경우는 반환값 앞에 i를 더해서 반환
                    }
                    check[i] = false;
                }
            }
            return "";
        }

        static string SearchUp(int cnt, int num)        // 내림차순 탐색 메소드와 원리 동일
        {
            if (cnt == k)
                return num.ToString();
            for (int i = 0; i < 10; i++)
            {
                if (check[i])
                    continue;
                if ((sign[cnt] == ">" && num > i) || (sign[cnt] == "<" && num < i) || num == -1)
                {
                    check[i] = true;
                    string temp;
                    if (num == -1) temp = SearchUp(cnt, i);
                    else temp = SearchUp(cnt + 1, i);
                    if (temp != "")
                    {
                        if (cnt + 1 == k) return $"{i}";
                        else return $"{i}{temp}";
                    }
                    check[i] = false;
                }
            }
            return "";
        }
    }
}
