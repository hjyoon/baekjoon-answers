import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Vertex {
    char value;
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void bfs_for_list(int start, int num_vertex, ArrayList<Integer>[] graph, boolean[] visit) throws Exception {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visit[start] = true;
        while(!q.isEmpty()) {
            int x = q.remove();

            //bw.write(x+" ");

            // for(int i=1; i<=num_vertex; i++) {
            //     if(graph[x][i] != 0 && visit[i] == false) {
            //         visit[i] = true;
            //         q.add(i);
            //     }
            // }

            for(int y : graph[x]) {
                if(visit[y] == false) {
                    visit[y] = true;
                    q.add(y);
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

        // input data
        char[][] a = new char[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = st.nextToken().toCharArray();
        }

        // print test
        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         bw.write(a[i][j] + " ");
        //     }
        //     bw.write("\n");
        // }

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph_list = new ArrayList[N*N+1];
        for(int i=1; i<=N*N; i++) {
            graph_list[i] = new ArrayList<>();
        }

        boolean[] visit = new boolean[N*N+1];

        //make graph structure
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int node_idx = i*N + j + 1;
                if(i==0 && j==0) {
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                }
                else if(i==0 && j==N-1) {
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                }
                else if(i==N-1 && j==0) {
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                }
                else if(i==N-1 && j==N-1) {
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                }
                else if(i==0) {
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                }
                else if(j==0) {
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                }
                else if(i==N-1) {
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                }
                else if(j==N-1) {
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                }
                else {
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                }
            }
        }

        for(int i=1; i<=N*N; i++) {
            Collections.sort(graph_list[i]);
        }

        // for(int i=1; i<=N; i++) {
        //     for(int j : graph_list[i]) {
        //         bw.write(j+" ");
        //     }
        //     bw.write("\n");
        // }

        int res1 = 0;
        int res2 = 0;
        for(int i=1; i<=N*N; i++) {
            if(!visit[i]) {
                bfs_for_list(i, N*N, graph_list, visit);
                res1++;
                //bw.write("\n");
            }
        }

        // init list
        Arrays.fill(visit, false);
        for(int i=1; i<=N*N; i++) {
            graph_list[i].clear();
        }


        // G -> R
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(a[i][j] == 'G') {
                    a[i][j] = 'R';
                }
            }
        }

        //make graph structure
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int node_idx = i*N + j + 1;
                if(i==0 && j==0) {
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                }
                else if(i==0 && j==N-1) {
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                }
                else if(i==N-1 && j==0) {
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                }
                else if(i==N-1 && j==N-1) {
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                }
                else if(i==0) {
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                }
                else if(j==0) {
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                }
                else if(i==N-1) {
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                }
                else if(j==N-1) {
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                }
                else {
                    if(a[i][j] == a[i-1][j]) {
                        graph_list[node_idx].add(node_idx-N);
                    }
                    if(a[i][j] == a[i][j-1]) {
                        graph_list[node_idx].add(node_idx-1);
                    }
                    if(a[i][j] == a[i+1][j]) {
                        graph_list[node_idx].add(node_idx+N);
                    }
                    if(a[i][j] == a[i][j+1]) {
                        graph_list[node_idx].add(node_idx+1);
                    }
                }
            }
        }

        for(int i=1; i<=N*N; i++) {
            Collections.sort(graph_list[i]);
        }

        for(int i=1; i<=N*N; i++) {
            if(!visit[i]) {
                bfs_for_list(i, N*N, graph_list, visit);
                res2++;
                //bw.write("\n");
            }
        }

        bw.write(res1 + " " + res2 + "\n");
        bw.flush();
    }
}