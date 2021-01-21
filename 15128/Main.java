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

        int p1 = Integer.parseInt(s[0]);
        int q1 = Integer.parseInt(s[1]);
        int p2 = Integer.parseInt(s[2]);
        int q2 = Integer.parseInt(s[3]);

        double area = (double)p1/q1 * (double)p2/q2 * 1/2.0;

        if(Math.floor(area) == Math.ceil(area)) {
            bw.write("1");
        }
        else {
            bw.write("0");
        }

		bw.flush();
    }
}