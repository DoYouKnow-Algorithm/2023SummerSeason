
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static class Player implements Comparable<Player>{
        int level;
        String name;
        boolean check;

        Player(int level, String name){
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return name.compareTo(o.name);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 플레이어의 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        Player[] players = new Player[p];

        for(int i=0; i<p; i++){ // 플레이어 레벨과 닉네임 입력 받기
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players[i] = new Player(level, name);
        }

        for(int i=0; i<p; i++){
            ArrayList<Player> room = new ArrayList<>();
            if(!players[i].check){ //아직 방에 포함된 것이 아니라면
                for(int j=i; j<p; j++){
                    if(room.size() ==m ) break; // 정원이 다 찼으면
                    int level = players[j].level;
                    String name = players[j].name;
                    if(!players[j].check && players[i].level-10 <= level && players[i].level +10>=level){ //해당 방에 입장할 수 있으면
                        players[j].check = true; // 포함됐다고 표시
                        room.add(new Player(level, name)); // 방에 추가
                    }
                }
                Collections.sort(room); //정렬
                if(room.size()==m){ // 정원이 다 찼으면
                    sb.append("Started!").append("\n");
                }
                else{ // 정원이 다 차지 않았으면
                    sb.append("Waiting!").append("\n");
                }
                for(Player player : room){ // 해당 방에 있는 플레이어 정보 출력
                    sb.append(player.level).append(" ").append(player.name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
