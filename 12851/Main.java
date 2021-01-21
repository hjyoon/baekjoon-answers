import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Node {
    int idx;
    int depth;
    Node(int idx, int depth) {
        this.idx = idx;
        this.depth = depth;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int min_dist = 100001;
    static int cnt = 0;
    static int cal = -1;

    public static void bfs_for_list(int start, int end, ArrayList<Node>[] graph, int[] visit) throws Exception {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visit[start] = 0;
        while(!q.isEmpty()) {
            Node x = q.remove();

            // if(cal < x.depth) {
            //     cal = x.depth;
            //     bw.write(x.idx+" "+x.depth);
            //     bw.newLine();
            //     bw.flush();
            // }

            bw.write(x.idx+" "+x.depth);
            bw.newLine();
            bw.flush();

            if(visit[x.idx] < x.depth) {
                continue;
            }

            if(min_dist < x.depth) {
                continue;
            }

            if(visit[x.idx] > x.depth) {
                visit[x.idx] = x.depth;
            }

            if(x.idx == end) {
                if(min_dist > x.depth) {
                    min_dist = x.depth;
                    //bw.write("found!!!\n");
                    cnt = 1;
                }
                else if(min_dist == x.depth) {
                    cnt++;
                }
                continue;
            }
            
            //bw.write(x+" ");

            for(Node y : graph[x.idx]) {
                if(visit[y.idx] >= x.depth+1) {
                    //visit[y.idx] = true;
                    //y.depth++;
                    //q.add(new Node(y.idx, x.depth+1));
                    //y.depth = x.depth + 1;
                    // if(min_dist < x.depth+1) {
                    //     continue;
                    // }
                    // if(visit[y.idx] < x.depth+1) {
                    //     continue;
                    // }
                    q.add(new Node(y.idx, x.depth+1));
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        min_dist = Math.abs(N-K);

        int[] visit = new int[200001];
        Arrays.fill(visit, 200000);

        @SuppressWarnings("unchecked")
        ArrayList<Node>[] graph_list = new ArrayList[200001];
        for(int i=0; i<200001; i++) {
            graph_list[i] = new ArrayList<>();
        }

        // make graph
        for(int i=0; i<200001; i++) {
            if(i+1 < 200000) {
                graph_list[i].add(new Node(i+1, 0));
            }
            if(i*2 < 200000 && i != 0) {
                graph_list[i].add(new Node(i*2, 0));
            }
            if(i-1 >= 0) {
                graph_list[i].add(new Node(i-1, 0));
            }
        }

        bfs_for_list(N, K, graph_list, visit);

        bw.write(min_dist+"");
        bw.newLine();
        bw.write(cnt+"");
        bw.newLine();
        
        bw.flush();
    }
}