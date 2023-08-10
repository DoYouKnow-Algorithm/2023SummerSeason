package Week5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _20006 {
    public static class Player implements Comparable<Player> {
        int l;
        String n;
        boolean isEnter;

        //생성자
        Player(int level, String name) {
            this.l = level;
            this.n = name;
        }

        //이름을 사전순으로 비교
        @Override
        public int compareTo(Player p1) {
            return n.compareTo(p1.n);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());   // 플레이어 수
        int m = Integer.parseInt(st.nextToken());   // 방의 정원
        Player[] players = new Player[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            players[i] = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        for (int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();
            if (!players[i].isEnter) {  //참가하지 않은 플레이어라면
                for (int j = i; j < p; j++) {
                    if (room.size() == m) { //방의 정원이 가득찼으면 종료
                        break;
                    }
                    int level = players[j].l;
                    String name = players[j].n;
                    //참가하지 않았고 플레이어의 레벨이 -10~+10이면 방을 새롭게 만들어서 입장
                    if (!players[j].isEnter && players[i].l - 10 <= level && players[i].l + 10 >= level) {
                        players[j].isEnter = true;
                        room.add(new Player(level, name));
                    }
                }
                //방을 사전순으로 정렬
                Collections.sort(room);
                if (room.size() == m) {     //방이 가득찼으면 Started!
                    sb.append("Started!\n");
                } else {    //방이 가득차지 않았으면 Waiting!
                    sb.append("Waiting!\n");
                }
                //방의 플레이어 정보 출력
                for (Player player : room) {
                    sb.append(player.l + " " + player.n + "\n");
                }
            }

        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}