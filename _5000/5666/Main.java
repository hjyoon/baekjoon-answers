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

        String s = br.readLine();

        while(true) {
            String s = br.readLine();
            if(s == null) {
                break;
            }
            String[] ss = s.split(" ");
            int H = Integer.parseInt(ss[0]);
            int P = Integer.parseInt(ss[1]);

            bw.write(String.format("%.2f\n", (double)H/P));
        }

        bw.flush();
    }
}