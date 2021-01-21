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

        s = br.readLine();
        //sa = br.readLine().split(" +");
        int N = Integer.parseInt(s);

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
        for (int i=0; i<N; i++) {
            sa = br.readLine().split(" +");
            for(int j=0; j<N; j++) {
                d[i][j] = Integer.parseInt(sa[j]);
            }
        }

        // calc
        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (d[i][k] == 1 && d[k][j] == 1) {
                        d[i][j] = 1;
                    }
                }
            }
        }

        //print test
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                bw.write(d[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}