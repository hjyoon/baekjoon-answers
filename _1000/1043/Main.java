import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void dfs_for_array(int start, int num_vertex, int[][] graph, boolean[] visit, boolean[] chk) throws Exception {
        if(visit[start]) {
            return;
        }

        visit[start] = true;
        chk[start] = true;

        //bw.write(start+" ");

        for(int i=1; i<=num_vertex; i++) {
            if(graph[start][i] != 0 && visit[i] == false) {
                dfs_for_array(i, num_vertex, graph, visit, chk);
            }
        }
    }

    public static void make_graph(int[][] graph_array, ArrayList<Integer> tmp_connect) {
        for(int i=0; i<tmp_connect.size(); i++) {
            for(int j=0; j<tmp_connect.size(); j++) {
                graph_array[tmp_connect.get(i)][tmp_connect.get(j)] = 1;
                graph_array[tmp_connect.get(j)][tmp_connect.get(i)] = 1;
            }
        }
    }

    public static boolean chk_group(boolean[] chk, ArrayList<Integer> tmp_connect) {
        int cnt = 0;
        for(int j=0; j<tmp_connect.size(); j++) {
            if(chk[tmp_connect.get(j)] == false) {
                cnt++;
            }
            else {
                break;
            }
        }
        if(cnt == tmp_connect.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph_array = new int[N+1][N+1];
        boolean[] visit = new boolean[N+1];
        boolean[] chk = new boolean[N+1];

        ArrayList<Integer> start_points = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int O = Integer.parseInt(st.nextToken());
        for(int i=0; i<O; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            chk[tmp] = true;
            start_points.add(tmp);
        }

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] tmp_connect = new ArrayList[M];
        for(int i=0; i<M; i++) {
            tmp_connect[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            for(int j=0; j<tmp; j++) {
                int tmp2 = Integer.parseInt(st.nextToken());
                tmp_connect[i].add(tmp2);
            }
            make_graph(graph_array, tmp_connect[i]);
        }

        for(int i=0; i<start_points.size(); i++) {
            dfs_for_array(start_points.get(i), N, graph_array, visit, chk);
        }

        int res = 0;
        for(int i=0; i<M; i++) {
            if(chk_group(chk, tmp_connect[i])) {
                res++;
            }
        }

        // // print test
        // for(int i=1; i<=N; i++) {
        //     bw.write(chk[i]+" ");
        // }
        // bw.newLine();

        // // print test
        // for(int i=1; i<=N; i++) {
        //     bw.write(visit[i]+" ");
        // }
        // bw.newLine();

        // // print test
        // for(int i=0; i<=N; i++) {
        //     for(int j=0; j<=N; j++) {
        //         bw.write(graph_array[i][j]+" ");
        //     }
        //     bw.newLine();
        // }
        // bw.newLine();

        bw.write(res+"\n");
        bw.flush();
    }
}