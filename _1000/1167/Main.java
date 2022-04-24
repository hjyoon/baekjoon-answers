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
    final static int INF = 1000000001;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        ArrayList<Vertex>[] graph_list = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            graph_list[i] = new ArrayList<>();
        }

        int[] d = new int[V+1];
        boolean[] c = new boolean[V+1];

        // make graph
        for(int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                graph_list[from].add(new Vertex(to, w));
            }
        }

        int start = 1;  // start
        int end = V;    // end

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

        // find max
        int max_idx = 0;
        int max_value = 0;
        for(int i=1; i<=V; i++) {
            //bw.write(d[i]+" ");
            if(d[i] > max_value) {
                max_value = d[i];
                max_idx = i;
            }
        }

        start = max_idx;

        // list and heap
        Arrays.fill(c, false);
        Arrays.fill(d, INF);
        pq = new PriorityQueue<>();
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

        // find max
        max_idx = 0;
        max_value = 0;
        for(int i=1; i<=V; i++) {
            //bw.write(d[i]+" ");
            if(d[i] > max_value) {
                max_value = d[i];
                max_idx = i;
            }
        }

        bw.write(max_value+"");
        bw.newLine();

        bw.flush();
    }
}