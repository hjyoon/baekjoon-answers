import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int f_1 = 1;
        int f_2 = 1;
        int res = 0;

        if(N == 0) {
            bw.write("0");
            bw.flush();
            return;
        }

        if(N < 3) {
            bw.write("1");
            bw.flush();
            return;
        }

        for(int i=0; i<N-2; i++) {
            res = (f_2 + f_1) % 1000000007;
            f_1 = f_2;
            f_2 = res;
        }

        bw.write(res+"");
        bw.flush();
    }
}