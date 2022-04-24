import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main_2 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    final static long mod = 1000000007;

    static ArrayList<Long>[] add(ArrayList<Long>[] a, ArrayList<Long>[] b) {
        int n = a.length;

        @SuppressWarnings("unchecked")
        ArrayList<Long>[] c = new ArrayList[n];
        for(int i=0; i<n; i++) {
            c[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                c[i].set(j, (a[i].get(j)+b[i].get(j))%mod);
            }
        }

        return c;
    }

    static ArrayList<Long>[] mul(ArrayList<Long>[] a, ArrayList<Long>[] b) {
        int n = a.length;

        @SuppressWarnings("unchecked")
        ArrayList<Long>[] c = new ArrayList[n];
        for(int i=0; i<n; i++) {
            c[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int sum = 0;
                for (int k=0; k<n; k++) {
                    sum += a[i].get(k) * a[k].get(j);
                }
                c[i].add(sum % mod);
            }
        }

        return c;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        if (N <= 1) {
            bw.write(N+" ");
            bw.newLine();
            return;
        }

        N -= 1;

        @SuppressWarnings("unchecked")
        ArrayList<Long>[] ans = new ArrayList[2];
        ArrayList<Long>[] a = new ArrayList[2];
        for(int i=0; i<2; i++) {
            ans[i] = new ArrayList<>();
            a[i] = new ArrayList<>();
        }

        ans[0].add((long)1);
        ans[0].add((long)0);
        ans[1].add((long)0);
        ans[1].add((long)1);

        a[0].add((long)1);
        a[0].add((long)1);
        a[1].add((long)1);
        a[1].add((long)0);

        //matrix ans = {{1, 0}, {0, 1}};
        //matrix a = {{1, 1}, {1, 0}};


        while (N > 0) {
            if (N % 2 == 1) {

                ans = ans * a;
            }
            a = a * a;
            N /= 2;
        }

        bw.write(ans[0][0]+" ");
        bw.newLine();
        bw.flush();
    }
}