import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Vertex {
    int v;
    int w;
    Vertex(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    final static int INF = 100000001;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        boolean[] c = new boolean[N+1];

        @SuppressWarnings("unchecked")
        ArrayList<Vertex>[] graph_list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph_list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph_list[u].add(new Vertex(v, w));
        }

        int[] d = new int[N+1];
        Arrays.fill(d, INF);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        d[start] = 0;
        for (int k=0; k<N-1; k++) {
            int min = INF+1;
            int x = -1;
            for (int i=1; i<=N; i++) {
                if (c[i] == false && min > d[i]) {
                    min = d[i];
                    x = i;
                }
            }
            c[x] = true;
            for (int i=0; i<graph_list[x].size(); i++) {
                int v = graph_list[x].get(i).v;
                int w = graph_list[x].get(i).w;
                if (d[v] > d[x] + w) {
                    d[v] = d[x] + w;
                }
            }
        }

        // print ans
        bw.write(d[end]+"\n");
        bw.flush();
    }
}