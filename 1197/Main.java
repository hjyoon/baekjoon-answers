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

    public static void disjoint_union(int [] p, int x, int y) {
        x = find(p, x);
        y = find(p, y);
        p[x] = y;
    }

    public static int find(int[] p, int x) {
        if (x == p[x]) {
            return x;
        } else {
            return (p[x] = find(p, p[x]));
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] p = new int[V+1];
        for (int i=0; i<=V; i++) {
            p[i] = i;
        }

        List<Edge> edge_list = new ArrayList<>();

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge_list.add(new Edge(a, b, w));
            //edge_list.add(new Edge(b, a, w));
        }
        Collections.sort(edge_list);

        int ans = 0;
        for (Edge e : edge_list) {
            int x = find(p, e.start);
            int y = find(p, e.end);
            if (x != y) {
                disjoint_union(p, e.start, e.end);
                ans += e.cost;
            }
        }
        
        bw.write(ans+"");
        bw.newLine();

        bw.flush();
    }
}