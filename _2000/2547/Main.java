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

        //String[] s = br.readLine().split(" ");
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            br.readLine();
            BigInteger sum = BigInteger.ZERO;
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }
            if(sum.remainder(new BigInteger(N+"")) == BigInteger.ZERO) {
                bw.write("YES\n");
            }
            else {
                bw.write("NO\n");
            }
        }

        bw.flush();
    }
}