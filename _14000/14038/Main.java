import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int win = 0;

        for(int i=0; i<6; i++) {
            st = new StringTokenizer(br.readLine());
            String outcome = st.nextToken();
            if(outcome.equals("W")) {
                win++;
            }
        }

        if(win >= 5) {
            bw.write("1");
            bw.newLine();
        }
        else if(win >= 3) {
            bw.write("2");
            bw.newLine();
        }
        else if(win >= 1) {
            bw.write("3");
            bw.newLine();
        }
        else {
            bw.write("-1");
            bw.newLine();
        }
        
        bw.flush();
    }
}