package Week6;

import java.io.*;

public class _21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        String max = "";
        String min = "";
        String maxM = ""; //최대값을 위해 M저장
        String minX = ""; //최소값을 위해 M저장

        for(int i=0;i<s.length();i++) {
            //M을 저장해둠
            if(s.charAt(i) == 'M') {
                minX+="M";
                maxM+="M";
            }else if(s.charAt(i) == 'K') {  //K가 나왔을때
                if(minX.length() > 0) {
                    min+="1";   //최소값을 찾기 위해서는 1 뒤에 (minX 길이 -1)만큼 0을 붙여줌
                    for(int j=0;j<minX.length()-1;j++) {
                        min+="0";
                    }
                    minX="";  //M 개수 초기화
                }
                min+="5";   //1000.. 뒤에 5를 붙여줌
                max+="5";   //최대값을 찾기 위해서는 5뒤에 maxM의 길이만큼 0을 붙여줌
                for(int j=0;j<maxM.length();j++) {
                    max+="0";
                }
                maxM = "";  //M개수 초기화
            }
        }

        //M이 남아있을때
        if(maxM!="") {  //최대값을 위해 1을 maxM의 길이만큼 붙여줌
            for (int i = 0; i < maxM.length(); i++) {
                max += "1";
            }

            if (minX != "") {   //최소값을 위해 1뒤에 minX-1 만큼 0을 붙여줌
                min += "1";
                for (int i = 0; i < minX.length() - 1; i++) {
                    min += "0";
                }
            }

        }
        bw.write(String.valueOf(max + "\n"+min));
        bw.close();

    }
}
