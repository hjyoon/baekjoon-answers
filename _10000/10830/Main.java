import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int cal(final int a, final int b) {  // a^b
        int base = a;
        int e = b;
        int frag = 1;
        if(b == 1) {
            return base;
        }
        while(true) {
            if(e == 2) {
                return base * base * frag;
            }
            if(e % 2 == 0) {
                e /= 2;
                base *= base;
            }
            else {
                e--;
                frag *= base;
            }
        }
    }

    static int[][] copy_array(int[][] src, int N) {
        int[][] res = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                res[i][j] = src[i][j];
            }
        }
        return res;
    }

    static int[][] make_identity_matrix(int N) {
        int[][] m = new int[N][N];
        for(int i=0; i<N; i++) {
            m[i][i] = 1;
        }
        return m;
    }

    static int[][] mul_matrix(int[][] m1, int[][] m2, int N) {
        int[][] res = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int sum = 0;
                for(int k=0; k<N; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                res[i][j] = sum % 1000;
            }
        }
        return res;
    }

    static void print_matrix(int[][] m, int N) throws Exception {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                bw.write(m[i][j]+" ");
            }
            bw.newLine();
        }
    }

    static int[][] ex_matrix(final int[][] src, final long b, final int N) throws Exception {
        int[][] res;
        int[][] frag = make_identity_matrix(N);
        int[][] base = copy_array(src, N);
        long e = b;
        if(b == 1) {
            res = copy_array(src, N);
            res = mul_matrix(src, frag, N);
            return res;
        }
        while(true) {
            if(e == 2) {
                int[][] tmp = mul_matrix(base, base, N);
                res = mul_matrix(tmp, frag, N);
                return res;
            }
            if(e % 2 == 0) {
                e /= 2;
                int[][] tmp = mul_matrix(base, base, N);
                base = copy_array(tmp, N);
            }
            else {
                e--;
                int[][] tmp = mul_matrix(frag, base, N);
                frag = copy_array(tmp, N);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] m = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //tmp = copy_array(m, N);

        // for(int l=0; l<B-1; l++) {
        //     res = mul_matrix(tmp, m, N);
        //     tmp = copy_array(res, N);
        // }

        int[][] res = ex_matrix(m, B, N);
        print_matrix(res, N);

        //int t = cal(2, 11);

        //bw.write(t+"");
        //bw.newLine();
        bw.flush();
    }
}