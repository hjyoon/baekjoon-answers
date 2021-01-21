import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String p = br.readLine();
        p = p.replace("*","[a-z]*");
        Pattern pp = Pattern.compile(p);

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            Matcher m = pp.matcher(s);
            if(m.matches()) {
                bw.write("DA\n");
            }
            else {
                bw.write("NE\n");
            }
        }

        bw.flush();
    }
}