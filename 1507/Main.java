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
    final static int INF = 10000001;


    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        //sa = br.readLine().split(" +");
        int N = Integer.parseInt(br.readLine());

        int[][] d = new int[N+1][N+1];
        boolean[][] v = new boolean[N+1][N+1];

        // data init
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if(i == j) {
                    d[i][j] = 0;
                }
                else {
                    d[i][j] = INF;
                }
            }
        }

        // data input
        for(int i=1; i<=N; i++) {
            sa = br.readLine().split(" +");
            for(int j=1; j<=N; j++) {
                d[i][j] = Integer.parseInt(sa[j-1]);
            }
        }

        // calc
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        bw.write("-1\n");
                        bw.flush();
                        return;
                    }
                    if (d[i][j] == d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        //bw.write(i+" "+j+" "+k+"\n");
                        v[i][j] = true;
                        //d[i][j] = INF;
                    }
                }
            }
        }

        //print test
        // for (int i=1; i<=N; i++) {
        //     for (int j=1; j<=N; j++) {
        //         if(d[i][j] == INF) {
        //             bw.write("0 ");
        //         }
        //         else {
        //             bw.write(d[i][j]+" ");
        //         }
        //     }
        //     bw.write("\n");
        // }

        int res = 0;
        for(int i=1; i<=N; i++) {
            for(int j=i+1; j<=N; j++) {
                if(v[i][j] == false) {
                    res += d[i][j];
                }
            }
        }

        bw.write(res+"");

        // for (int i=1; i<=N; i++) {
        //     for (int j=1; j<=N; j++) {
        //         if(v[i][j] == false) {
        //             bw.write("0");
        //         }
        //         else {
        //             bw.write("1");
        //         }
        //     }
        //     bw.write("\n");
        // }
        
        bw.flush();
    }
}