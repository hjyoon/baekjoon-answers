import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String ss = br.readLine();
            if(ss.equals("0 0")) {
                break;
            }
            String[] s = ss.split(" ");
            double A = Double.parseDouble(s[0]);
            double B = Double.parseDouble(s[1]);
            double gamma = B/A;
            double v = Math.sqrt(1-gamma*gamma);

            bw.write(String.format("%.3f\n", v));
        }

        bw.flush();
    }
}