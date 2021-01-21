import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String[] s;

    public static void main(String args[]) throws Exception {
    	br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine().split(" ");

        int X = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);

        if(X >= L && X <= R) {
            bw.write(X+"");
        }
        else if(Math.abs(X-L) <= Math.abs(X-R)) {
            bw.write(L+"");
        }
        else {
            bw.write(R+"");
        }

		bw.flush();
    }
}