import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Edge implements Comparable<Edge> {
    public int start;
    public int end;
    public int cost;

    public Edge() {
        this(0,0,0);
    }

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        if(cost > e.cost) {
            return 1;
        }
        else if(cost < e.cost) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Edge>[] graph_list = (List<Edge>[]) new List[N+1];
        for (int i=1; i<=N; i++) {
            graph_list[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph_list[a].add(new Edge(a, b, w));
            graph_list[b].add(new Edge(b, a, w));
        }

        boolean[] c = new boolean[N+1];

        int start_node = 1;
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        c[start_node] = true;
        for (Edge e : graph_list[start_node]) {
            pq.add(e);
        }
        int ans = 0;
        for (int i=0; i<N-1; i++) {
            Edge e = new Edge();
            while (!pq.isEmpty()) {
                e = pq.poll();
                if (c[e.end] == false) {
                    break;
                }
            }
            c[e.end] = true;
            ans += e.cost;
            for (Edge ee : graph_list[e.end]) {
                pq.add(ee);
            }
        }
        
        bw.write(ans+"");
        bw.newLine();

        bw.flush();
    }
}