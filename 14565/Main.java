import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static long[] cal(long a, long b) {
        if (b == 0) {
            return new long[] {a, 1, 0};
        }

        long[] res = cal(b, a%b);

        long g = res[0];
        long x = res[1];
        long y = res[2];

        res[0] = g;
        res[1] = y;
        res[2] = x-(a/b)*y;

        return res;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        long[] res = cal(A, N);

        bw.write(N-A+" ");
        if(res[0] != 1) {
            bw.write("-1");
        }
        else {
            bw.write((res[1]+N)%N+"");
        }
        bw.newLine();
        bw.flush();
    }
}