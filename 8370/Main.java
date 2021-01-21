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

        int n1 = Integer.parseInt(s[0]);
        int k1 = Integer.parseInt(s[1]);
        int n2 = Integer.parseInt(s[2]);
        int k2 = Integer.parseInt(s[3]);

        bw.write(n1*k1+n2*k2+"");
		bw.flush();
    }
}