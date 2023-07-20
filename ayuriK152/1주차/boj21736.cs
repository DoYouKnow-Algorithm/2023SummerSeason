using System;
using System.Collections;

namespace AlgorithmStudy
{
    class boj21736
    {
        static char[,] arr;
        static int n, m;
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            n = int.Parse(input[0]);
            m = int.Parse(input[1]);
            arr = new char[m, n];
            string arrInput;
            Pair startPoint = new Pair(0, 0);
            for (int i = 0; i < n; i++)
            {
                arrInput = Console.ReadLine();
                for (int j = 0; j < m; j++)
                {
                    arr[j, i] = arrInput[j];
                    if (arr[j, i].Equals('I'))
                        startPoint = new Pair(j, i);    // 입력이 I면 BFS 시작지점으로 저장
                }
            }

            int result = BFS(startPoint);
            if (result == 0)
                Console.WriteLine("TT");
            else
                Console.WriteLine(result);
        }

        // 입력 기반의 BFS
        static int BFS(Pair start)
        {
            Queue q = new Queue();
            q.Enqueue(start);
            
            int count = 0;
            while (q.Count > 0)
            {
                Pair current = q.Dequeue() as Pair;

                // X 제외하고 모든 타일 이동 가능, P인경우는 count++
                if (current.x > 0)
                {
                    if (arr[current.x - 1, current.y].Equals('O'))
                    {
                        arr[current.x - 1, current.y] = 'I';
                        q.Enqueue(new Pair(current.x - 1, current.y));
                    }
                    else if (arr[current.x - 1, current.y].Equals('P'))
                    {
                        arr[current.x - 1, current.y] = 'I';
                        q.Enqueue(new Pair(current.x - 1, current.y));
                        count++;
                    }
                }

                if (current.y > 0)
                {
                    if (arr[current.x, current.y - 1].Equals('O'))
                    {
                        arr[current.x, current.y - 1] = 'I';
                        q.Enqueue(new Pair(current.x, current.y - 1));
                    }
                    else if (arr[current.x, current.y - 1].Equals('P'))
                    {
                        arr[current.x, current.y - 1] = 'I';
                        q.Enqueue(new Pair(current.x, current.y - 1));
                        count++;
                    }
                }

                if (current.x < m - 1)
                {
                    if (arr[current.x + 1, current.y].Equals('O'))
                    {
                        arr[current.x + 1, current.y] = 'I';
                        q.Enqueue(new Pair(current.x + 1, current.y));
                    }
                    else if (arr[current.x + 1, current.y].Equals('P'))
                    {
                        arr[current.x + 1, current.y] = 'I';
                        q.Enqueue(new Pair(current.x + 1, current.y));
                        count++;
                    }
                }

                if (current.y < n - 1)
                {
                    if (arr[current.x, current.y + 1].Equals('O'))
                    {
                        arr[current.x, current.y + 1] = 'I';
                        q.Enqueue(new Pair(current.x, current.y + 1));
                    }
                    else if (arr[current.x, current.y + 1].Equals('P'))
                    {
                        arr[current.x, current.y + 1] = 'I';
                        q.Enqueue(new Pair(current.x, current.y + 1));
                        count++;
                    }
                }
            }
            return count;
        }

        class Pair
        {
            public int x, y;

            public Pair(int _x, int _y)
            {
                x = _x;
                y = _y;
            }
        }
    }
}
