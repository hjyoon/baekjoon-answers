import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    final static int MAX = 100111;
    static List<Integer>[] a = new List[MAX];
    static int[][] p = new int[MAX][18];
    static int[] tin = new int[MAX];
    static int[] tout = new int[MAX];
    static int timer;
    static int l;

    static void dfs(int v, int parent) {
        tin[v] = ++timer;
        p[v][0] = parent;
        for (int i=1; i<=l; i++) {
            p[v][i] = p[p[v][i-1]][i-1];
        }
        for (int to : a[v]) {
            if (to != parent) {
                dfs(to, v);
            }
        }
        tout[v] = ++timer;
    }

    static boolean upper(int u, int v) {
        return (tin[u] <= tin[v] && tout[u] >= tout[v]);
    }

    static int lca(int u, int v) {
        if (upper(u, v)) {
            return u;
        }
        if (upper(v, u)) {
            return v;
        }
        for (int i=l; i>=0; i--) {
            if (!upper(p[u][i], v)) {
                u = p[u][i];
            }
        }
        return p[u][0];
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            a[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[x].add(y);
            a[y].add(x);
        }

        l = 1;
        while((1<<l) <= N) {
            l++;
        }
        l--;

        dfs(1, 1);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int res = lca(x, y);
            bw.write(res+"");
            bw.newLine();
        }

        for(int i=1; i<=N; i++) {
            bw.write(i+" : ");
            for(int j=0; j<10; j++) {
                bw.write(p[i][j]+" ");
            }
            bw.newLine();
        }

        //bw.write("");
        //bw.newLine();

        bw.flush();
    }
}