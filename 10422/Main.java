import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    final static int MOD = 1000000007;

    static long[] dp = new long[2500+1];

    static long C(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }
        else {
            long sum = 0;
            for(int i=0; i<=n-1; i++) {
                sum += (C(i)%MOD)*(C(n-1-i)%MOD);
                sum %= MOD;
            }
            dp[n] = sum;
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        dp[0] = 1;

        C(2500);

        // for(int i=0; i<=2500; i++) {
        //     bw.write(i+" "+dp[i]+"\n");
        // }

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());

            if(L%2 == 0) {
                bw.write(dp[L/2]+"");
            }
            else {
                bw.write("0");
            }
            
            bw.newLine();
        }
        bw.flush();
    }
}