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

        int k = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]);

        bw.write((w - k + (m-1)) / m + "");
		bw.flush();
    }
}