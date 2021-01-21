import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int cnt(int n, int p) {  // n! 에서의 p개수 (소인수분해 후 p의 개수)
        int k=0;
        while (n>0) {
            k += n/p;
            n /= p;
        }
        return k;
    }

    static long fast_mul(int a, int b, int m) {  // 빠른 거듭제곱법 a^b
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

    static long c(int n, int m, int mod) throws Exception {
        long ans = 1;

        // 에라토스테네스의 체 사용
        boolean[] check = new boolean[n+1];
        Arrays.fill(check, true);
        for (int i=2; i<=n; i++) {
            if (check[i]) {
                for (int j=2*i; j<=n; j+=i) {
                    check[j] = false;
                }

                // i는 2이상 n이하의 모든 소수
                int k = cnt(n,i) - cnt(m,i) - cnt(n-m,i);
                //bw.write(i+" "+k+"\n");
                ans = ans * fast_mul(i, k, mod);
                ans = ans % mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MOD = 142857;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            long res = c(N, K, MOD);
            bw.write(res+"");
            bw.newLine();
        }

        bw.newLine();
        bw.flush();
    }
}