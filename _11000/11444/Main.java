import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    final static long mod = 1000000007;

    static HashMap<Long, Long> d;

    static long fibo(long n) {
        if (n <= 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 1;
        }
        else if (d.containsKey(n)) {
            return d.get(n);
        }
        else {
            if (n % 2 == 1) {
                long m = (n+1) / 2;
                long t1 = fibo(m);
                long t2 = fibo(m-1);
                d.put(n, (t1*t1 + t2*t2)%mod);
                return d.get(n);
            }
            else {
                long m = n/2;
                long t1 = fibo(m-1);
                long t2 = fibo(m);
                d.put(n, ((2*t1 + t2)*t2)%mod);
                return d.get(n);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        d = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        long res = fibo(N);

        bw.write(res+" ");
        bw.newLine();

        bw.flush();
    }
}