import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static long[][] p;
    static int N;
    static int zero_x;
    static int zero_y;
    static TreeSet<Long> ts;
    static TreeSet<Long> ts_zero;

    static void cal_set_except_zero() {
        for(int i=0; i<N; i++) {
            if(i == zero_y) {
                continue;
            }
            long sum = 0;
            for(int j=0; j<N; j++) {
                sum += p[i][j];
            }
            ts.add(sum);
        }

        for(int i=0; i<N; i++) {
            if(i == zero_x) {
                continue;
            }
            long sum = 0;
            for(int j=0; j<N; j++) {
                sum += p[j][i];
            }
            ts.add(sum);
        }

        long sum = 0;
        if(zero_y != zero_x) {
            for(int i=0; i<N; i++) {
                sum += p[i][i];
            }
            ts.add(sum);
        }

        if(zero_y + zero_x + 1 != N) {
            sum = 0;
            for(int i=0; i<N; i++) {
                sum += p[i][N-i-1];
            }
            ts.add(sum);
        }
    }

    static void cal_zero_axis() {
        if(zero_y + zero_x + 1 == N) {
            long sum = 0;
            for(int i=0; i<N; i++) {
                sum += p[i][N-i-1];
            }
            ts_zero.add(sum);
        }
        if(zero_y == zero_x) {
            long sum = 0;
            for(int i=0; i<N; i++) {
                sum += p[i][i];
            }
            ts_zero.add(sum);
        }
        long sum = 0;
        for(int j=0; j<N; j++) {
            sum += p[zero_y][j];
        }
        ts_zero.add(sum);

        sum = 0;
        for(int j=0; j<N; j++) {
            sum += p[j][zero_x];
        }
        ts_zero.add(sum);
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        p = new long[N][N];
        zero_x = 0;
        zero_y = 0;
        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                p[i][j] = Long.parseLong(s[j]);
                if(p[i][j] == 0) {
                    zero_y = i;
                    zero_x = j;
                }
            }
        }

        ts = new TreeSet<>();
        ts_zero = new TreeSet<>();

        cal_set_except_zero();
        cal_zero_axis();

        if(ts.size() == 1 && ts_zero.size() == 1 && ts.first().compareTo(ts_zero.first()) > 0) {
            bw.write(ts.last()-ts_zero.first()+"\n");
        }
        else {
            bw.write("-1\n");
        }

        bw.flush();
    }
}