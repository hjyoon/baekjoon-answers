import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.time.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pattern p = Pattern.compile("[aeiouAEIOU]");

        while(true) {
            String S = br.readLine();
            if(S.equals("#")) {
                break;
            }
            Matcher m = p.matcher(S);

            int cnt = 0;
            while(m.find()) {
                cnt++;
            }
            bw.write(cnt+"");
            bw.newLine();
        }
        bw.flush();
    }
}