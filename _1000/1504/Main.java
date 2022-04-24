import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Node implements Comparable<Node> {
    int i;
    int w;
    Node(int i, int w) {
        this.i = i;
        this.w = w;
    }
    public int compareTo(Node o){
        return w <= o.w ? -1 : 1;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    final static int INF = 10000001;

    static int cal(int start, int end, ArrayList<Node>[] graph_list, int N) {
        int[] d = new int[N+1];
        boolean[] c = new boolean[N+1];
        Arrays.fill(d, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start, d[start]));
        while(!pq.isEmpty()){
            int cost = pq.peek().w;
            int here = pq.peek().i;
            pq.poll();
            if(cost > d[here]) {
                continue;
            } 
            for (int i=0; i<graph_list[here].size(); i++) {
                int v = graph_list[here].get(i).i;
                int w = graph_list[here].get(i).w;
                if(d[v] > d[here] + w) {
                    d[v] = d[here] + w;
                    pq.offer(new Node(v, d[v]));
                }
            }
        }
        return d[end];
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        ArrayList<Node>[] graph_list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph_list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph_list[a].add(new Node(b, c));
            graph_list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int start = 1;

        int start_to_v1 = cal(start, v1, graph_list, N);
        start_to_v1 += cal(v1, v2, graph_list, N);
        start_to_v1 += cal(v2, N, graph_list, N);



        int start_to_v2 = cal(start, v2, graph_list, N);
        start_to_v2 += cal(v2, v1, graph_list, N);
        start_to_v2 += cal(v1, N, graph_list, N);

        int res = Math.min(start_to_v1, start_to_v2);

        if(res >= INF) {
            bw.write("-1");
        }
        else {
            bw.write(res+"");
        }
        bw.newLine();
        bw.flush();
    }
}