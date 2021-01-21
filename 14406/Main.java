import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        //String s = br.readLine();

        if(s.equals("걸.걸.걸")) {
            bw.write("더 사랑할걸, 더 참을걸, 더 즐길걸.");
        }
        else if(s.equals("사.우.나")) {
            bw.write("사랑과 우정을 나누자");
        }
        else if(s.equals("지.화.자")) {
            bw.write("지금부터 화합하자");
        }
        else if(s.equals("재.건.축")) {
            bw.write("재미있고 건강하게, 축복하며 살자");
        }
        else if(s.equals("오.징.어")) {
            bw.write("오래도록 징그럽게 어울리자");
        }
        else if(s.equals("해.당.화")) {
            bw.write("해가 갈수록 당당하고 화려하게");
        }
        else if(s.equals("우.아.미")) {
            bw.write("우아하고 아름다운 미래를 위하여");
        }
        else if(s.equals("재.개.발")) {
            bw.write("재미있고 개성있게 발전적으로 살자");
        }
        else if(s.equals("사.이.다")) {
            bw.write("사랑하자 이 세상 다 바쳐");
        }
        else if(s.equals("주.전.자")) {
            bw.write("주인의식을 갖고 전문성을 갖추고 자신있게 살자");
        }
        else if(s.equals("나.가.자")) {
            bw.write("나라, 가정, 자신의 발전을 위하여");
        }
        else if(s.equals("이.기.자")) {
            bw.write("이런 기회를 자주 만들자");
        }
        else if(s.equals("청.바.지")) {
            bw.write("청춘은 바로 지금부터");
        }
        //bw.newLine();
        
        bw.flush();
    }
}