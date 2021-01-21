import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    //static String s;
    static String[] sa;

    static int M = 1234567891;

    static long myPow(int a, int b) throws Exception {
        long res = 1;
        for(int i=0; i<b; i++) {
            res *= a;
            res %= M;
        }
        return res;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        //sa = br.readLine().split(" +");

        int L = Integer.parseInt(br.readLine());
        String Str = br.readLine();

        long res = 0;
        for(int i=0; i<L; i++) {
            long tmp = (Str.charAt(i)-'a'+1) * (long)myPow(31, i);
            //bw.write(tmp+"\n");
            res += tmp;
            res %= M;
        }

        bw.write(res+"\n");
        bw.flush();
    }
}