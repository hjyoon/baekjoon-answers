import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null) 
            return; 
        din.close(); 
    }
}

class Node implements Comparable<Node> {
    int idx;
    int w;
    Node(int idx, int w) {
        this.idx = idx;
        this.w = w;
    }
    public int compareTo(Node o){
        return w <= o.w ? -1 : 1;
    }
}

class Edge {
    int from;
    int to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
    public boolean equals(Object obj) {
        if(obj instanceof Edge) {
            Edge tmp = (Edge)obj;
            return from == tmp.from && to == tmp.to;
        }
        return false;
    }
    public int hashCode() {
        //return Object.hash(from, to);
        return (from + " " + to).hashCode();
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static int bfs_for_list(int start, int num_vertex, ArrayList<Node>[] graph, int[] d, HashSet<Edge> hs) throws Exception {
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        while(!q.isEmpty()) {
            Node x = q.remove();

            //bw.write(x+" ");

            // for(int i=1; i<=num_vertex; i++) {
            //     if(graph[x][i] != 0 && visit[i] == false) {
            //         visit[i] = true;
            //         q.add(i);
            //     }
            // }

            for(Node y : graph[x.idx]) {
                if(d[y.idx] == d[x.idx] - y.w && hs.contains(new Edge(x.idx, y.idx)) == false) {
                    cnt++;
                    //bw.write("from: " + x.idx + " to: "+ y.idx + "\n");
                    hs.add(new Edge(x.idx, y.idx));
                    q.add(new Node(y.idx, y.w));
                }
            }
        }
        return cnt;
    }

    public static void main(String args[]) throws Exception {
        //br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Reader s = new Reader("../input.txt"); 
        //Reader s = new Reader();

        //st = new StringTokenizer(br.readLine());
        int N = s.nextInt();

        //st = new StringTokenizer(br.readLine());
        int M = s.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Node>[] graph_list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph_list[i] = new ArrayList<>();
        }

        @SuppressWarnings("unchecked")
        ArrayList<Node>[] graph_list_reverse = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph_list_reverse[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            //st = new StringTokenizer(br.readLine());
            int from = s.nextInt();;
            int to = s.nextInt();;
            int w = s.nextInt();;
            graph_list[from].add(new Node(to, w));
            graph_list_reverse[to].add(new Node(from, w));
        }

        //st = new StringTokenizer(br.readLine());
        int start = s.nextInt();
        int end = s.nextInt();

        int[] d = new int[N+1];
        HashSet<Edge> hs = new HashSet<>();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start, d[start]));
        while(!pq.isEmpty()){
            int cost = pq.peek().w;
            int here = pq.peek().idx;
            pq.poll();
            if(cost > d[here]) {
                continue;
            } 
            for (int i=0; i<graph_list[here].size(); i++) {
                int idx = graph_list[here].get(i).idx;
                int w = graph_list[here].get(i).w;
                if(d[idx] < d[here] + w) {
                    d[idx] = d[here] + w;
                    pq.offer(new Node(idx, d[idx]));
                }
            }
        }
        // print
        // for(int i=1; i<=N; i++) {
        //     bw.write(d[i]+" ");
        // }
        // bw.write("\n");

        int res = bfs_for_list(end, N, graph_list_reverse, d, hs);
        bw.write(d[end]+"\n");
        bw.write(res+"\n");

        bw.flush();
    }
}