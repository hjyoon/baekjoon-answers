import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static void print(long[] a) throws Exception {
        for (long i : a) {
            bw.write(i+" ");
        }
        bw.newLine();
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        
        // 정보 / 전산 / 미래 / 신양 / 진리 / 한경직 / 학생회관 / 형남
        long[] dp = {1, 0, 0, 0, 0, 0, 0, 0};

        long mod = 1000000007;

        // i초 후 해당 건물 위치로 가는 경우의 수
        for(int i=0; i<D; i++) {
            //print(dp);
            long[] tmp = new long[8];
            tmp[0] = (dp[1] + dp[2]) % mod;
            tmp[1] = (dp[0] + dp[2] + dp[3]) % mod;
            tmp[2] = (dp[0] + dp[1] + dp[3] + dp[5]) % mod;
            tmp[3] = (dp[1] + dp[2] + dp[4] + dp[5]) % mod;
            tmp[4] = (dp[3] + dp[5] + dp[6]) % mod;
            tmp[5] = (dp[2] + dp[3] + dp[4] + dp[7]) % mod;
            tmp[6] = (dp[4] + dp[7]) % mod;
            tmp[7] = (dp[5] + dp[6]) % mod;
            dp = tmp;
        }
        
        bw.write(dp[0]+"");
        bw.newLine();
        bw.flush();
    }
}