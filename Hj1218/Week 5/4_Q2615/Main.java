import java.util.Scanner;

public class Main {
    static int [][]num = new int[20][20]; //바둑판
    static int count1=1,count2=1,count3=1,count4=1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=1;i<20;i++){
            for(int j=1;j<20;j++){
                num[i][j]=in.nextInt(); //바둑판 입력받기
            }
        }
        for(int i=1;i<20;i++){
            for(int j=1;j<20;j++){
                if(num[i][j]!=0){ //바둑알이 놓인 경우
                    check(i,j,num[i][j]);
                }
            }
        }
        System.out.println(0);
    }
    static boolean checkPosition(int x, int y){
        if(x<1||x>19||y<1||y>19){ //범위를 벗어나는 경우
            return false;
        }
        return true;
    }
    static void check(int x, int y, int color){
        for(int i=1;i<5;i++){ //오른쪽
            if(!checkPosition(x,y+i)){ //범위를 벗어나는 경우
                break;
            }
            else{
                if(num[x][y+i]!=color){ //다른색의 바둑알이 놓인 경우
                    break;
                }
                count1++;
            }
        }
        if(count1==5){ //연속적으로 5알이 놓인 경우
            if(checkPosition(x,y-1)){ //기준좌표에서 왼쪽이 범위를 벗어나지 않는 경우
                if(num[x][y-1]!=color){ //기준좌표에 놓인 바둑알과 다른색인 경우
                    if(checkPosition(x,y+5)){ //마지막으로 탐색한 좌표의 오른쪽이 범위를 벗어나지 않는 경우
                        if(num[x][y+5]!=color){ //기준좌표에 놓인 바둑알과 다른색인 경우
                            System.out.println(color);
                            System.out.println(x+" "+y);
                            System.exit(0);
                        }
                    }
                    else{ //오른쪽이 존재하지 않는 경우
                        System.out.println(color);
                        System.out.println(x+" "+y);
                        System.exit(0);
                    }
                }
            }
            else{ //범위를 벗어나는 경우
                if(checkPosition(x,y+5)){
                    if(num[x][y+5]!=color){
                        System.out.println(color);
                        System.out.println(x+" "+y);
                        System.exit(0);
                    }
                }
                else{
                    System.out.println(color);
                    System.out.println(x+" "+y);
                    System.exit(0);
                }
            }
        }
        for(int i=1;i<5;i++){ //오른쪽위
            if(!checkPosition(x-i,y+i)){ //범위를 벗어나는 경우
                break;
            }
            else{
                if(num[x-i][y+i]!=color){ //다른색의 바둑알이 놓인 경우
                    break;
                }
                count2++;
            }
        }
        if(count2==5){
            if(checkPosition(x+1,y-1)){ //기준좌표에서 왼쪽이 범위를 만족하는 경우
                if(num[x+1][y-1]!=color){ //다른색의 바둑알이 놓인 경우
                    if(checkPosition(x-5,y+5)){ //마지막으로 탐색한 좌표의 오른쪽이 범위를 만족하는 경우
                        if(num[x-5][y+5]!=color){ //다른색의 바둑알이 놓인 경우
                            System.out.println(color);
                            System.out.println(x+" "+y);
                            System.exit(0);
                        }
                    }
                    else{ //오른쪽이 존재하지 않는 경우
                        System.out.println(color);
                        System.out.println(x+" "+y);
                        System.exit(0);
                    }
                }
            }
            else{ //범위를 벗어나는 경우
                if(checkPosition(x-5,y+5)){
                    if(num[x-5][y+5]!=color){
                        System.out.println(color);
                        System.out.println(x+" "+y);
                        System.exit(0);
                    }
                }
                else{
                    System.out.println(color);
                    System.out.println(x+" "+y);
                    System.exit(0);
                }
            }
        }
        for(int i=1;i<5;i++){ //아래
            if(!checkPosition(x+i,y)){ //범위를 벗어나는 경우
                break;
            }
            else{
                if(num[x+i][y]!=color){ //다른색의 바둑알이 놓인 경우
                    break;
                }
                count3++;
            }
        }
        if(count3==5){
            if(checkPosition(x-1,y)){ //기준좌표의 왼쪽이 범위를 만족하는 경우
                if(num[x-1][y]!=color){ //다른색의 바둑알이 놓인 경우
                    if(checkPosition(x+5,y)){ //마지막으로 탐색한 좌표의 오른쪽이 존재하는 경우
                        if(num[x+5][y]!=color){ //다른색의 바둑알이 놓인 경우
                            System.out.println(color);
                            System.out.println(x+" "+y);
                            System.exit(0);
                        }
                    }
                    else{ //존재하지 않는 경우
                        System.out.println(color);
                        System.out.println(x+" "+y);
                        System.exit(0);
                    }
                }
            }
            else{ //범위를 벗어나는 경우
                if(checkPosition(x+5,y)){
                    if(num[x+5][y]!=color){
                        System.out.println(color);
                        System.out.println(x+" "+y);
                        System.exit(0);
                    }
                }
                else{
                    System.out.println(color);
                    System.out.println(x+" "+y);
                    System.exit(0);
                }
            }
        }
        for(int i=1;i<5;i++){ //오른쪽아래
            if(!checkPosition(x+i,y+i)){ //범위를 벗어난 경우
                break;
            }
            else{
                if(num[x+i][y+i]!=color){ //다른색의 바둑알이 놓인 경우
                    break;
                }
                count4++;
            }
        }
        if(count4==5){
            if(checkPosition(x-1,y-1)){ //기준좌표의 왼쪽이 범위를 만족하는 경우
                if(num[x-1][y-1]!=color){ //다른색의 바둑알이 놓인 경우
                    if(checkPosition(x+5,y+5)){ //마지막으로 탐색한 좌표의 오른쪽이 범위를 만족하는 경우
                        if(num[x+5][y+5]!=color){ //다른색의 바둑알이 놓인 경우
                            System.out.println(color);
                            System.out.println(x+" "+y);
                            System.exit(0);
                        }
                    }
                    else{ //존재하지 않는 경우
                        System.out.println(color);
                        System.out.println(x+" "+y);
                        System.exit(0);
                    }
                }
            }
            else{ //범위를 벗어난 경우
                if(checkPosition(x+5,y+5)){
                    if(num[x+5][y+5]!=color){
                        System.out.println(color);
                        System.out.println(x+" "+y);
                        System.exit(0);
                    }
                }
                else{
                    System.out.println(color);
                    System.out.println(x+" "+y);
                    System.exit(0);
                }
            }
        }
        count1=1;
        count2=1;
        count3=1;
        count4=1;
    }
}