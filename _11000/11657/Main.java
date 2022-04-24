import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Edge {
    int from;
    int to;
    int cost;
    Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    final static int INF = 10000001;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge> al = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            al.add(new Edge(S, E, T));
        }
        long[] d = new long[N+1];
        Arrays.fill(d, INF);
        d[1] = 0;
        boolean ok = false;
        for (int i=1; i<=N; i++) {
            for (Edge e : al) {
                int x = e.from;
                int y = e.to;
                int z = e.cost;
                if (d[x] != INF && d[y] > d[x]+z) {
                    d[y] = d[x]+z;
                    if (i == N) {
                        ok = true;
                    }
                }
            }
        }
        if (ok) {
            bw.write("-1");
        }
        else{
            for(int i=2; i<=N; i++) {
                // if(d[i] == INF) {
                //     bw.write("-1");
                // }
                {
                    bw.write(d[i]+"");
                }
                bw.newLine();
            }
        }
        
        bw.flush();
    }
}