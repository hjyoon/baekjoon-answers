import java.io.*;
import java.math.*;     
import java.util.*;
import java.util.regex.*;
import java.util.Map.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static void print_res(int[] res) throws Exception {
        for(int i=1; i<res.length; i++) {
            bw.write(res[i]+" ");
        }
        bw.write("\n");
    }

    static void bfs(int start, int num_vertex, int[][] graph, boolean[] visit, int[] res) throws Exception {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visit[start] = true;
        while(!q.isEmpty()) {
            int x = q.remove();

            //bw.write(x+" ");

            for(int i=1; i<=num_vertex; i++) {
                if(graph[x][i] != 0 && visit[i] == false && res[x] < 2) {
                    visit[i] = true;
                    q.add(i);
                    res[i] = res[x] + 1;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N+1][N+1];
        boolean[] visit = new boolean[N+1];
        int[] res = new int[N+1];

        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            int len = s.length();
            for(int j=0; j<len; j++) {
                if(s.charAt(j) == 'Y') {
                    graph[i][j+1] = 1;
                }
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            bfs(i, N, graph, visit, res);
            //print_res(res);

            int cnt = 0;
            for(int j=1; j<=N; j++) {
                if(res[j] == 1 || res[j] == 2) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);

            Arrays.fill(visit, false);
            Arrays.fill(res, 0);
        }

        bw.write(max+"");
        bw.flush();
    }
}