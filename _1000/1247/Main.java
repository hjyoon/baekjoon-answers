import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 3;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            BigInteger sum = BigInteger.ZERO;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                BigInteger tmp = new BigInteger(st.nextToken());
                sum = sum.add(tmp);
            }
            if(sum.signum() == 0) {
                bw.write("0");
            }
            else if(sum.signum() == -1) {
                bw.write("-");
            }
            else if(sum.signum() == 1) {
                bw.write("+");
            }
            bw.newLine();
        }
        bw.flush();
    }
}