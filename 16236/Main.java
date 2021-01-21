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

public class Main {
    static BufferedWriter bw;
    static StringTokenizer st;
    static int sharkSize = 2;
    static int eatCnt = 0;
    static int currentPos;
    static int time;
    static int[] map;

    public static boolean bfs_for_list(int start, int num_vertex, ArrayList<Integer>[] graph, int[] visit) throws Exception {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visit[start] = 0;
        int tmp_time = Integer.MAX_VALUE;
        int tmp_pos = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int x = q.remove();

            if(map[x] != 0 && map[x] < sharkSize) {
                if(tmp_time >= visit[x]) {
                    tmp_time = visit[x];
                    if(tmp_pos > x) {
                        tmp_pos = x;
                    }
                }
            }

            if(tmp_time < visit[x]) {
                map[tmp_pos] = 0;
                currentPos = tmp_pos;
                eatCnt++;
                if(eatCnt == sharkSize) {
                    sharkSize++;
                    eatCnt = 0;
                }
                time += visit[tmp_pos];
                return true;
            }

            for(int y : graph[x]) {
                if(visit[y] == 0 && y != start) {
                    visit[y] = visit[x] + 1;
                    if(map[y] <= sharkSize) {
                       q.add(y);
                    }
                }
            }
        }

        if(tmp_time != Integer.MAX_VALUE && tmp_pos != Integer.MAX_VALUE) {
            map[tmp_pos] = 0;
            currentPos = tmp_pos;
            eatCnt++;
            if(eatCnt == sharkSize) {
                sharkSize++;
                eatCnt = 0;
            }
            time += visit[tmp_pos];
            return true;
        }

        return false;
    }

    public static void main(String args[]) throws Exception {
        Reader s = new Reader("../input.txt");
        //Reader s = new Reader();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = s.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph_list = new ArrayList[N*N+1];
        for(int i=1; i<=N*N; i++) {
            graph_list[i] = new ArrayList<>();
        }

        int[] visit = new int[N*N+1];
        map = new int[N*N+1];

        //input data and make graph structure
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int from_node_idx = i*N + j + 1;
                map[from_node_idx] = s.nextInt();
                if(map[from_node_idx] == 9) {
                    currentPos = from_node_idx;
                    map[from_node_idx] = 0;
                }
                for(int k=0; k<4; k++) {
                    int to_node_idx = (i+dy[k])*N + (j+dx[k]) + 1;
                    if(i+dy[k] >= 0 && i+dy[k] <= N-1 && j+dx[k] >= 0 && j+dx[k] <= N-1) {
                        graph_list[from_node_idx].add(to_node_idx);
                    }
                }
            }
        }

        while(bfs_for_list(currentPos, N, graph_list, visit)) {
            Arrays.fill(visit, 0);  
        }
        bw.write(time + "\n");

        bw.flush();
    }
}