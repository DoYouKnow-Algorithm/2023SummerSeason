using System;

namespace AlgorithmStudy
{
    class boj2992
    {
        static string input;
        static int[] nums;
        static bool[] check;
        static string result, previous = "0";
        public static void Main(string[] args)
        {
            input = Console.ReadLine();
            nums = new int[input.Length];
            check = new bool[input.Length];

            for (int i = 0; i < input.Length; i++)
                nums[i] = int.Parse(input[i].ToString());

            Array.Sort(nums);
            Search(0, "");
            Console.WriteLine(result);
        }

        static bool Search(int len, string str)
        {
            if (len == input.Length && str == input)
                return true;
            for (int i = input.Length - 1; i >= 0; i--)
            {
                if (check[i])
                    continue;
                check[i] = true;
                if (Search(len + 1, str + nums[i]))
                {
                    result = previous;
                    break;
                }
                else if (len  == input.Length - 1)
                    previous = str + nums[i];
                check[i] = false;
            }
            return false;
        }
    }
}
