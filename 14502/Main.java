import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    
    public static void print(ArrayList<Integer> al, int[] flag, int r) throws Exception {
        for(int i=0; i<r; i++) {
            bw.write(al.get(flag[i])+" ");
        }
        bw.newLine();
    }

    public static void print_flag(int[] flag) throws Exception {
        for(int i=0; i<flag.length; i++) {
            bw.write(flag[i]+" ");
        }
        bw.newLine();
    }

    public static void init_flag_asc(int[] flag) {
        for(int i=0; i<flag.length; i++) {
            flag[i] = i;
        }
    }

    public static boolean next_comb_non_recursive(int[] flag, int n, int r) {
        /* this check is not strictly necessary, but if r is not close to n,
        it makes the whole thing quite a bit faster */
        // if(flag[r-1] < n-1) {
        //     flag[r-1]++;
        //     return true;
        // }
        int i = r-1;
        while(flag[i] >= n-(r-i)) {
            i--;
            if(i < 0) {
                return false;
            }
        }
        flag[i]++;
        while(i < r-1) {
            flag[i+1] = flag[i] + 1;
            i++;
        }
        return true;
    }

    public static void bfs_for_list(int start, int num_vertex, ArrayList<Integer>[] graph, int[] visit) throws Exception {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        //visit[start] = true;
        while(!q.isEmpty()) {
            int x = q.remove();

            //bw.write(x+" ");
            //visit[x] = true;

            // for(int i=1; i<=num_vertex; i++) {
            //     if(graph[x][i] != 0 && visit[i] == false) {
            //         visit[i] = true;
            //         q.add(i);
            //     }
            // }

            for(int y : graph[x]) {
                if(visit[y] == 0) {
                    visit[y] = 2;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        //br = new BufferedReader(new FileReader("../input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int num_vertex = N*M;

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph_list = new ArrayList[num_vertex+1];
        for(int i=1; i<=num_vertex; i++) {
            graph_list[i] = new ArrayList<>();
        }

        int[] visit_src = new int[num_vertex+1];

        // make graph
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int current_pos = i*M+j+1;
                if(i != 0) {
                    graph_list[current_pos].add(current_pos-M);
                }
                if(i != N-1) {
                    graph_list[current_pos].add(current_pos+M);
                }
                if(j != 0) {
                    graph_list[current_pos].add(current_pos-1);
                }
                if(j != M-1) {
                    graph_list[current_pos].add(current_pos+1);
                }
            }
        }

        ArrayList<Integer> virus_pos = new ArrayList<>();
        ArrayList<Integer> blank_pos = new ArrayList<>();

        // make visit
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int current_pos = i*M+j+1;
                int state = Integer.parseInt(st.nextToken());
                if(state == 2) {
                    virus_pos.add(current_pos);
                }
                else if(state == 0) {
                    blank_pos.add(current_pos);
                }
                visit_src[current_pos] = state;
            }
        }

        // combination init
        int r = 3;
        int[] flag = new int[r];
        init_flag_asc(flag);
        
        int max = 0;
        do {
            // init visit
            int[] visit_dst = visit_src.clone();
            
            // make walls
            for(int i=0; i<r; i++) {
                visit_dst[blank_pos.get(flag[i])] = 1;
            }
            
            // bfs from virus
            for(int i : virus_pos) {
                bfs_for_list(i, num_vertex, graph_list, visit_dst);
            }
            
            // count safe area
            int cnt = 0;
            for(int i=1; i<visit_dst.length; i++) {
                if(visit_dst[i] == 0) {
                    cnt++;
                }
            }
            
            // update max
            if(max < cnt) {
                max = cnt;
            }
        } while(next_comb_non_recursive(flag, blank_pos.size(), r));

        bw.write(max+"");
        bw.newLine();
        
        bw.flush();
    }
}