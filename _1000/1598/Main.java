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

        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        int ax = (A-1)/4+1;
        int bx = (B-1)/4+1;

        int ay = (A%4) == 0 ? 4 : (A%4);
        int by = (B%4) == 0 ? 4 : (B%4);

        //bw.write(ax+" "+ay+"\n");
        //bw.write(bx+" "+by+"\n");

        int res = Math.abs(bx-ax) + Math.abs(by-ay);

        bw.write(res+"");
        bw.flush();
    }
}