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

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int res = Math.max(a+b, a+c);
        res = Math.max(res, b+c);

        bw.write(res+"");
		bw.flush();
    }
}