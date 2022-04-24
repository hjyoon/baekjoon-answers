import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static long fast_mul(long a, long b, long m) {  // a^b
        long ans = 1;
        if(a == 1 || b == 0) {
            return 1;
        }
        while(b > 0) {
            if(b % 2 == 1) {
                ans *= a;
                ans %= m;
            }
            a *= a;
            a %= m;
            b /= 2;
        }
        return ans;
    }

    static long fac(long n, long m) throws Exception {
        long ans = 1;
        for(long i=2; i<=n; i++) {
            ans *= i;
            ans %= m;
            bw.write(ans+"\n");
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());


        long a = fac(N, M);
        
        long b = fac(K, M) * fac(N-K, M);


        b %= M;

        bw.write(a+" "+b+"\n");

        long res = a * fast_mul(b, M-2, M);

        res %= M;

        bw.write(res+"");
        bw.newLine();
        bw.flush();
    }
}