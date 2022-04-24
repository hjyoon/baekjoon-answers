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
    final static int INF = 10000;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        sa = br.readLine().split(" +");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[][] d = new int[N][N];

        // data init
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(i == j) {
                    d[i][j] = 0;
                }
                else {
                    d[i][j] = INF;
                }
            }
        }

        // data input
        for (int i=0; i<M; i++) {
            sa = br.readLine().split(" +");
            int src = Integer.parseInt(sa[0]);
            int dst = Integer.parseInt(sa[1]);
            d[src-1][dst-1] = 1;
            d[dst-1][src-1] = 1;
        }

        // calc
        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        // find
        int ans = -1;
        int who = -1;
        for (int i=0; i<N; i++) {
            int sum = 0;
            for (int j=0; j<N; j++) {
                sum += d[i][j];
            }
            if (ans == -1 || sum < ans) {
                ans = sum;
                who = i+1;
            }
        }

        // print test
        // for (int i=0; i<N; i++) {
        //     for (int j=0; j<N; j++) {
        //         bw.write(d[i][j]+" ");
        //     }
        //     bw.write("\n");
        // }

        bw.write(who + "\n");
        bw.flush();
    }
}