import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int[] before;

    static int solve(int N, int[] dp) throws Exception {
        if(dp[N] != 0) {
            return dp[N];
        }
        if(N == 1) {
            return 0;
        }

        int a = 1000001;
        int b = 1000001;
        int c = 1000001;  

        if(N % 2 == 0) {
            a = solve(N/2, dp);
        }
        if(N % 3 == 0) {
            b = solve(N/3, dp);
        }
        c = solve(N-1, dp);

        int from_a = N/2;
        int from_b = N/3;
        int from_c = N-1;

        dp[N] = 1 + Math.min(a, Math.min(b,c));

        int m = 0;

        if(a > b) {
            if(b > c) {
                // c가 가장 작음
                m = from_c;
            }
            else {
                // b가 가장 작음
                m = from_b;
            }
        }
        else {
            if(a > c) {
                // c가 가장 작음
                m = from_c;
            }
            else {
                // a가 가장 작음
                m = from_a;
            }
        }

        before[N] = m;

        return dp[N];
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        before = new int[N+1];

        int[] dp = new int[N+1];

        int res = solve(N, dp);

        bw.write(res+"");
        bw.newLine();

        // for(int i=1; i<=N; i++) {
        //     bw.write(before[i]+" ");
        // }

        int start = N;
        while(true) {
            bw.write(start+" ");
            if(start == 1) {
                break;
            }
            start = before[start];
        }
        bw.flush();
    }
}