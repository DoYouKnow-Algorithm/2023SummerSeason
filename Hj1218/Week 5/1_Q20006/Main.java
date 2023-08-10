import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static class Player implements Comparable<Player>{
        int level; //레벨
        String name; //이름
        boolean check; //방 입장 여부
        public Player(int level, String name){ //생성자
            this.level = level;
            this.name = name;
        }
        public int compareTo(Player p){ //이름순 정렬을 위한 override
            return name.compareTo(p.name);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt(); //플레이어의 수
        int m = in.nextInt(); //방의 정원
        Player []players = new Player[p]; //플레이어 정보 저장 객체 배열

        for(int i=0;i<p;i++){
            int level = in.nextInt(); //플레이어 레벨
            String name = in.next(); //플레이어 이름
            players[i] = new Player(level,name); //플레이어 정보 저장
        }
        for(int i=0;i<p;i++){
            ArrayList<Player> room = new ArrayList<>(); //입장할 방
            if(!players[i].check){ //입장 여부가 x인 플레이어
                for(int j=i;j<p;j++){ //해당 플레이어부터 뒤에 있는 플레이어를 탐색하여
                    if(room.size()==m){ //정원이 찬 경우 종료
                        break;
                    }
                    //입장 여부 x, 레벨이 처음 입장한 플레이어 레벨 +-10을 만족하는 경우
                    if(!players[j].check&&players[i].level-10<=players[j].level&&players[i].level+10>= players[j].level){
                        players[j].check=true; //방 입장 o
                        room.add(players[j]); //방 입장
                    }
                }
                Collections.sort(room); //이름순 정렬
                if(room.size()==m){ //정원이 다 찬 경우
                    System.out.println("Started!");
                }
                else{ //다 차지 않은 경우
                    System.out.println("Waiting!");
                }
                for(int k=0;k<room.size();k++){ //해당 방 플레이어 정보 출력
                    System.out.println(room.get(k).level+" "+room.get(k).name);
                }
            }
        }
    }
}