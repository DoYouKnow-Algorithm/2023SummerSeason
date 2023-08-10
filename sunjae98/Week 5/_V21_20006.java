import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static class Player implements Comparable<Player> {
        //멤버 변수
        int level; // 레벨
        String name; // 닉네임
        boolean enter; // 입장여부

        //생성자
        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override // 닉네임 오름차순 정렬을 위한 오버라이딩 함수
        public int compareTo(Player p) {
            return name.compareTo(p.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방 정원
        Player[] players = new Player[p]; // 레벨과 닉네임을 저장할 객체 배열 생성


        // 플레이어 정보 저장
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            players[i] = new Player(l, n);
        }


        for (int i = 0; i < p; i++) { // 최초 입장 플레이어
            ArrayList<Player> room = new ArrayList<>();
            if (!players[i].enter) { // 입장하지 않은 플레이어만 탐색
                for (int j = i; j < p; j++) { // 최초 입장 플레이어 부터 탐색
                    if (room.size() == m) { // 정원 초과시 반복문을 빠져나감
                        break;
                    }
                    int level = players[j].level; // 입장한 플레이어의 레벨
                    String name = players[j].name; // 입장한 플레이어의 닉네임
                    boolean enter = players[j].enter; // 입장한 플레이어의 입장여부

                    if (!enter // 방 조건에 해당하면
                            && players[i].level - 10 <= level
                            && level <= players[i].level + 10) {
                        players[j].enter = true; // 플레이어 입장 표시
                        room.add(players[j]); // 플레이어 입장
                    }
                }

                Collections.sort(room); // 플레이어를 닉네임 오름차순으로 정렬
                if (room.size() == m) { // 정원초과
                    sb.append("Started!").append("\n");
                } else { // 플레이어 모집중
                    sb.append("Waiting!").append("\n");
                }
                for (int k = 0; k < room.size(); k++) {
                    Player player = room.get(k); // 현재 인덱스에 해당하는 플레이어
                    sb.append(player.level).append(" ").append(player.name).append("\n"); // 해당 플레이어를 StringBuilder 에 추가
                }
            }
        }
        System.out.println(sb);

    }
}
