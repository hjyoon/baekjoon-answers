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
            String s = br.readLine();
            if(s.equals("0 0")) {
                break;
            }
            String[] ss = s.split(" ");
            int M = Integer.parseInt(ss[0]);
            int F = Integer.parseInt(ss[1]);

            bw.write(M+F+"\n");
        }

        bw.flush();
    }
}