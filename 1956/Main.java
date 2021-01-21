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
        sa = br.readLine().split(" +");
        int V = Integer.parseInt(sa[0]);
        int E = Integer.parseInt(sa[1]);

        int[][] d = new int[V+1][V+1];  // 0번 도시 제외 , 1번 도시부터 시작

        // data init
        for (int i=1; i<=V; i++) {
            for (int j=1; j<=V; j++) {
                if(i == j) {
                    d[i][j] = INF;
                }
                else {
                    d[i][j] = INF;
                }
            }
        }

        // data input
        for(int i=0; i<E; i++) {
            sa = br.readLine().split(" +");
            int src = Integer.parseInt(sa[0]);
            int dst = Integer.parseInt(sa[1]);
            int cost = Integer.parseInt(sa[2]);
            if(d[src][dst] > cost) {
                d[src][dst] = cost;
            }
        }

        // calc
        for (int k=1; k<=V; k++) {
            for (int i=1; i<=V; i++) {
                for (int j=1; j<=V; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        //print test
        // for (int i=1; i<=V; i++) {
        //     for (int j=1; j<=V; j++) {
        //         // if(d[i][j] == INF) {
        //         //     bw.write("-1 ");
        //         // }
        //         // else {
        //         //     bw.write(d[i][j]+" ");
        //         // }
        //         bw.write(d[i][j]+" ");
        //     }
        //     bw.write("\n");
        // }

        int res = INF;
        for(int i=1; i<=V; i++) {
            if(d[i][i] < res) {
                res = d[i][i];
            }
        }

        if(res == INF) {
            bw.write("-1\n");
        }
        else {
            bw.write(res+"\n");
        }

        bw.flush();
    }
}