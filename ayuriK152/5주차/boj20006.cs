using System;
using System.Collections.Generic;

namespace AlgorithmStudy
{
    class boj20006
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int p = int.Parse(input[0]), m = int.Parse(input[1]);
            List<Room> rooms = new List<Room>();

            for (int i = 0; i < p; i++)
            {
                input = Console.ReadLine().Split(' ');
                int l = int.Parse(input[0]);
                Room currentRoom = null;

                foreach (Room r in rooms)       // 생성된 방 전체 탐색
                {
                    if (r.players.Count < m && Math.Abs(r.players[0].level - l) <= 10)      // 꽉 안찼고 레벨 범위에 부합하는 방이면 해당 방 선택
                    {
                        currentRoom = r;
                        break;
                    }
                }
                if (currentRoom == null)        // 선택된 방이 없으면 새로운 방 생성
                {
                    currentRoom = new Room(m);
                    rooms.Add(currentRoom);
                }

                currentRoom.players.Add(new Player(l, input[1]));       // 생성된 방에 플레이어 추가
            }

            foreach (Room r in rooms)
            {
                r.players.Sort();       // 최종 출력 전에 이름순 정렬
                if (r.players.Count == m)       // 방이 꽉찼으면 started, 아니면 waiting
                    Console.WriteLine("Started!");
                else
                    Console.WriteLine("Waiting!");
                foreach (Player player in r.players)
                    Console.WriteLine($"{player.level} {player.name}");
            }
        }

        public class Player : IComparable<Player>       // 플레이어 클래스, 이름 사전순 정렬을 위한 비교자 인터페이스
        {
            public int level;
            public string name;

            public Player(int _level, string _name)
            {
                level = _level;
                name = _name;
            }

            int IComparable<Player>.CompareTo(Player other)
            {
                return name.CompareTo(other.name);
            }
        }

        public class Room       // 멀티방 클래스
        {
            public List<Player> players;
            public int max;

            public Room(int _max)
            {
                max = _max;
                players = new List<Player>();
            }
        }
    }
}
