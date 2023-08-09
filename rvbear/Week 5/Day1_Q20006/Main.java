import java.io.*;
import java.util.*;

public class Main {
    public static class Player implements Comparable<Player>{       // Player class 생성, 정렬을 위한 인터페이스 상속 받음
        private int level;                              // 플레이어의 레벨
        private String name;                            // 플레이어의 이름
        private boolean visit;                          // 해당 플레이어가 방에 들어갔는지 여부 판단

        public Player(int _level, String _name) {       // 생성자
            level = _level; name = _name;
        }

        @Override
        public int compareTo(Player p) {                // 정렬을 위한 오버라이딩 함수 만들어줌, 이름 사전 순서대로 정렬
            return name.compareTo(p.name);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 버퍼 스트림을 통해 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     // 버퍼 스트림을 통해 출력
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(stk.nextToken());      // 플레이어의 수
        int m = Integer.parseInt(stk.nextToken());      // 방의 정원
        int level;                                      // 플레이어의 레벨 (이후 재사용되기 때문에 앞에서 한번만 선언)
        Player[] players = new Player[p];               // 플레이어를 저장할 배열

        for(int i = 0; i < p; i++) {
            stk = new StringTokenizer(br.readLine());
            level = Integer.parseInt(stk.nextToken());
            players[i] = new Player(level, stk.nextToken());        // 배열에 플레이어의 정보를 저장
        }

        for(int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();             // 방을 생성
            if(!players[i].visit) {                                 // 플레이어가 방에 들어가지 않았다면
                room.add(players[i]);                               // 방에 입장을 시킨 뒤
                players[i].visit = true;                            // 방에 들어갔음을 표시해줌
                for(int j = i+1; j < p; j++) {                      // 이후 다음 플레이어부터 탐색 시작
                    if (room.size() == m) {                         // 방의 정원이 다 찼을 경우 더이상의 탐색 없이 종료
                        break;
                    }
                    level = players[j].level;                       // 다음 플레이어의 레벨을 저장
                    // 탐색할 플레이어가 방에 입장한 적이 없으며 처음 방에 들어간 플레이어의 레벨의 -10 ~ +10 범위 안에 든다면
                    if(!players[j].visit && players[i].level-10 <= level && players[i].level+10 >= level) {
                        room.add(players[j]);                       // 해당 플레이어를 방에 입장시키고
                        players[j].visit = true;                    // 방에 들어갔음을 표시해줌
                    }
                }
                
                Collections.sort(room);                             // 위의 오버라이딩해준 메서드를 통해 플레이어들을 이름순으로 정렬
                if(room.size() == m) {                              // 탐색이 끝났을 때 방에 인원이 다 찼다면
                    bw.write("Started!\n");                     // Started!를 출력
                } else {                                            // 방에 인원이 다 차지 않았다면
                    bw.write("Waiting!\n");                     // Waiting!을 출력
                }
                for(Player p1 : room) {                             // 해당 방에 있는 모든 플레이어의 정보를 출력
                    bw.write(p1.level + " " + p1.name + "\n");
                }
            }
        }

        br.close(); bw.close();                                     // 입출력 버퍼 스트림 닫아줌
    }
}