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

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int N=0, K=0;
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            K = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            int res = 0;
            for(int i=0; i<N; i++) {
                int tmp = Integer.parseInt(s[i]);
                res += tmp/K;
            }
            bw.write(res+"\n");
        }

        bw.flush();
    }
}