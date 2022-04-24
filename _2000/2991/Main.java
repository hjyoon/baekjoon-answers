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
        int C = Integer.parseInt(s[2]);
        int D = Integer.parseInt(s[3]);

        s = br.readLine().split(" ");
        int P = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int N = Integer.parseInt(s[2]);

        int res_p = 0;
        if((P-1)%(A+B) < A) {
            res_p++;
        }
        if((P-1)%(C+D) < C) {
            res_p++;
        }

        int res_m = 0;
        if((M-1)%(A+B) < A) {
            res_m++;
        }
        if((M-1)%(C+D) < C) {
            res_m++;
        }

        int res_n = 0;
        if((N-1)%(A+B) < A) {
            res_n++;
        }
        if((N-1)%(C+D) < C) {
            res_n++;
        }

        bw.write(res_p+"\n");
        bw.write(res_m+"\n");
        bw.write(res_n+"\n");
        bw.flush();
    }
}