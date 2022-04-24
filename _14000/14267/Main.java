import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Vertex implements Comparable<Vertex> {
    int v;
    int w;
    Vertex(int v, int w) {
        this.v = v;
        this.w = w;
    }
    public int compareTo(Vertex o){
        return w <= o.w ? -1 : 1;
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
        int M = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        ArrayList<Vertex>[] graph_list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph_list[i] = new ArrayList<>();
        }

        int[] order = new int[N+1];
        //boolean[] connected = new boolean[N+1];
        int[] weight_list = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            order[i] = tmp;
        }

        // assign weight to graph
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = order[to];
            int w = Integer.parseInt(st.nextToken());
            //graph_list[from].add(new Vertex(to, w));
            //connected[to] = true;
            weight_list[to] += w;
        }

        // make default graph if node don't have any vertex.
        for(int i=2; i<=N; i++) {
            int to = i;
            // if(connected[to]) {
            //     continue;
            // }
            int from = order[to];
            int w = weight_list[to];
            graph_list[from].add(new Vertex(to, w));
            //bw.write(from+" "+to+" "+w+"\n");
        }

        int[] d = new int[N+1];
        boolean[] c = new boolean[N+1];

        int start = 1;  // start
        //int end = N;    // end

        // list and heap
        Arrays.fill(c, false);
        Arrays.fill(d, INF);
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Vertex(start, d[start]));
        while(!pq.isEmpty()){
            int cost = pq.peek().w;
            int here = pq.peek().v;
            pq.poll();
            if(cost > d[here]) {
                continue;
            } 
            for (int i=0; i<graph_list[here].size(); i++) {
                int v = graph_list[here].get(i).v;
                int w = graph_list[here].get(i).w;
                if(d[v] > d[here] + w) {
                    d[v] = d[here] + w;
                    pq.offer(new Vertex(v, d[v]));
                }
            }
        }

        for(int i=1; i<=N; i++) {
            bw.write(d[i]+" ");
        }
        bw.newLine();

        bw.flush();
    }
}