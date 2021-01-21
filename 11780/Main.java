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
    //static Stack<Integer> stk = new Stack<>();

    static void prtin_trace(int i, int j, int[][] trace, ArrayList<Integer> al) throws Exception {
        if(trace[i][j] != 0) {
            prtin_trace(i, trace[i][j], trace, al);
            al.add(trace[i][j]);
            //bw.write(trace[i][j]+" ");
            //prtin_trace(trace[i][j], j, trace, al);
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        //sa = br.readLine().split(" +");
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] d = new int[N+1][N+1];  // 0번 도시 제외 , 1번 도시부터 시작

        int[][] trace = new int[N+1][N+1];

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
        for(int i=0; i<M; i++) {
            sa = br.readLine().split(" +");
            int src = Integer.parseInt(sa[0]);
            int dst = Integer.parseInt(sa[1]);
            int cost = Integer.parseInt(sa[2]);
            if(d[src][dst] > cost) {
                d[src][dst] = cost;
            }
        }

        // calc
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    // if (i == j) {
                    //     continue;
                    // }
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        trace[i][j] = k;
                    }
                }
            }
        }

        //print test
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if(d[i][j] == INF) {
                    bw.write("0 ");
                }
                else {
                    bw.write(d[i][j]+" ");
                }
            }
            bw.write("\n");
        }

        //print test
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                bw.write(trace[i][j]+" ");
            }
            bw.write("\n");
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(d[i][j] == 0) {
                    bw.write("0");
                }
                else {
                    ArrayList<Integer> al = new ArrayList<>();
                    prtin_trace(i, j, trace, al);
                    bw.write(al.size()+2 + " ");
                    bw.write(i + " ");
                    for(int tmp : al) {
                        bw.write(tmp + " ");
                    }
                    bw.write(j + " ");
                }
                bw.newLine();
            }
        }
        
        bw.flush();
    }
}