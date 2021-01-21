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
        int TC = Integer.parseInt(st.nextToken());
        while(TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            ArrayList<Edge> al = new ArrayList<>();
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                al.add(new Edge(S, E, T));
                al.add(new Edge(E, S, T));
            }
            for(int i=0; i<W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                al.add(new Edge(S, E, -T));
            }
            int[] d = new int[N+1];
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
                bw.write("YES");
            }
            else {
                bw.write("NO");
            }
            bw.newLine();
        }
        bw.flush();
    }
}