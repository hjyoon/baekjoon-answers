import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String s;
    static String[] sa;
    //final static int INF = 10000001;

    public static boolean check_edges(int[][] a, int i, int j, int c) throws Exception {
        if(a[i][j] == a[i+c][j+c] && a[i][j] == a[i][j+c] && a[i][j] == a[i+c][j]) {
            return true;
        }
        return false;
    }

    public static int calc_area(int N, int M, int[][] a, int size) throws Exception {
        int cal_idx = size - 1;
        for(int i=0; i<N-cal_idx; i++) {
            for(int j=0; j<M-cal_idx; j++) {
                if(check_edges(a, i, j, cal_idx)) {
                    return size * size;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        sa = br.readLine().split(" +");
        int N = Integer.parseInt(sa[0]);    // 1 <= N <= 50
        int M = Integer.parseInt(sa[1]);    // 1 <= M <= 50

        int[][] a = new int[N][M];

        // data_init
        for(int i=0; i<N; i++) {
            Arrays.fill(a[i], 0);
        }

        // data_input
        for(int i=0; i<N; i++) {
            s = br.readLine();
            for(int j=0; j<M; j++) {
                a[i][j] = s.charAt(j)-'0';
            }
        }

        // print test
        // for (int i=0; i<N; i++) {
        //     for (int j=0; j<M; j++) {
        //         bw.write(a[i][j]+"");
        //     }
        //     bw.write("\n");
        // }

        // calc
        int max = 0;
        int limit = Math.min(N, M);
        for(int i=1; i<=limit; i++) {
            int tmp = calc_area(N, M, a, i);
            if(max < tmp) {
                max = tmp;
            }
        }

        bw.write(max+"\n"); // output result
        bw.flush();
    }
}