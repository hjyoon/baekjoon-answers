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

        double d = Double.parseDouble(br.readLine());
        while(true) {
            String ss = br.readLine();
            if(ss.equals("999")) {
                break;
            }
            double tmp = Double.parseDouble(ss);
            bw.write(String.format("%.2f\n", tmp-d));
            d = tmp;
        }

        bw.flush();
    }
}