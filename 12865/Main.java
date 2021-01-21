import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N];
        int[] v = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K+1];
        for(int i=1; i<=N; i++) {
            for(int j=K; j>=1; j--) {
                if(j-w[i-1] >= 0) {
                    dp[j] = Math.max(dp[j-w[i-1]] + v[i-1], dp[j]);
                }
                else {
                    dp[j] = dp[j];
                }
            }
        }

        bw.write(dp[K]+"");
        bw.newLine();
        
        bw.flush();
    }
}