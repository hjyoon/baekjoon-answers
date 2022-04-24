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
        int R = Integer.parseInt(s[0]);
        int G = Integer.parseInt(s[1]);
        int B = Integer.parseInt(s[2]);

        int res = Math.min(R, Math.min(G, B));

        R -= res;
        G -= res;
        B -= res;

        res += R/3;
        res += G/3;
        res += B/3;

        R = R%3;
        G = G%3;
        B = B%3;

        if(R+G+B > 2) {
            res += 2;
        }
        else if(R + G + B != 0) {
            res++;
        }

        bw.write(res+"");
        bw.flush();
    }
}