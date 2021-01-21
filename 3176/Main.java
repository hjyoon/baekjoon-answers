import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Edge {
    int to;
    int w;
    Edge(int to, int w) {
        this.to = to;
        this.w = w;
    }
}

class Pair {
    int min;
    int max;
    Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    final static int MAX = 100111;
    static int[] depth;
    static boolean[] check;
    static int[] parent;
    static int[] parent_w;
    static int[][] p;
    static int[][] len_min;
    static int[][] len_max;

    static Pair lca(int u, int v) {
        // 항상 u노드의 depth가 크게끔 swap
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int ans_min = 10000000;
        int ans_max = 0;

        int log = 1;
        while((1<<log) <= depth[u]) {
            log++;
        }
        log--;

        // u의 depth를 v의 depth에 맞추는 작업과 동시에 ans_min과 ans_max를 구한다.
        for (int i=log; i>=0; i--) {
            if(depth[u]-(1<<i) >= depth[v]) {
                if(ans_min > len_min[u][i]) {
                    ans_min = len_min[u][i];
                }
                if(ans_max < len_max[u][i]) {
                    ans_max = len_max[u][i];
                }
                u = p[u][i];
            }
        }

        // u노드와 v노드가 같으면 더 이상 구할게 없으므로 그대로 최소값 최대값 리턴
        if(u == v) {
            return new Pair(ans_min, ans_max);
        }
        else {
            // u노드와 v노드의 공통조상 직전까지 맞추는 작업과 동시에 ans_min과 ans_max를 구한다.
            for(int i=log; i>=0; i--) {
                if(p[u][i] != 0 && p[u][i] != p[v][i]) {
                    if(ans_min > len_min[u][i]) {
                        ans_min = len_min[u][i];
                    }
                    if(ans_max < len_max[u][i]) {
                        ans_max = len_max[u][i];
                    }
                    if(ans_min > len_min[v][i]) {
                        ans_min = len_min[v][i];
                    }
                    if(ans_max < len_max[v][i]) {
                        ans_max = len_max[v][i];
                    }
                    u = p[u][i];
                    v = p[v][i];
                }
            }

            // u노드와 v노드의 공통조상까지의 ans_min과 ans_max를 구한다.
            if(ans_min > len_min[u][0]) {
                ans_min = len_min[u][0];
            }
            if(ans_max < len_max[u][0]) {
                ans_max = len_max[u][0];
            }
            if(ans_min > len_min[v][0]) {
                ans_min = len_min[v][0];
            }
            if(ans_max < len_max[v][0]) {
                ans_max = len_max[v][0];
            }

            return new Pair(ans_min,ans_max);
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Edge>[] a = new List[N+1];  // 0번 노드는 사용 X
        for (int i=1; i<=N; i++) {
            a[i] = new ArrayList<>();
        }

        // 트리 구성
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());a
            a[x].add(new Edge(y, w));
            a[y].add(new Edge(x, w));
        }

        depth = new int[N+1];
        check = new boolean[N+1];
        parent = new int[N+1];
        parent_w = new int[N+1];
        p = new int[MAX][18];
        len_min = new int[MAX][18];
        len_max = new int[MAX][18];

        int start = 1;  // 1번 노드는 root

        // root 부터 bfs로 탐색하기 위한 queue
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;// 해당 인덱스는 노드번호를 의미하며, 해당 노드번호의 방문여부를 저장.
        depth[start] = 0;   // 해당 인덱스는 노드번호를 의미하며, 해당 노드번호의 depth가 저장됨.
        parent[start] = 0;  // 해당 인덱스는 노드번호를 의미하며, 해당 노드번호의 부모 노드번호가 저장됨.

        q.add(start);
        while(!q.isEmpty()) {
            int x = q.remove();
            for (Edge y : a[x]) {
                if (check[y.to] == false) {
                    depth[y.to] = depth[x] + 1;
                    check[y.to] = true;
                    parent[y.to] = x;
                    parent_w[y.to] = y.w;
                    q.add(y.to);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            p[i][0] = parent[i];
            len_min[i][0] = parent_w[i];
            len_max[i][0] = parent_w[i];
        }

        for (int j=1; (1<<j)<N; j++) {
            for (int i=1; i<=N; i++) {
                if (p[i][j-1] != 0) {
                    p[i][j] = p[p[i][j-1]][j-1];
                    len_min[i][j] = len_min[i][j-1];
                    len_max[i][j] = len_max[i][j-1];
                    if (p[p[i][j-1]][j-1] != 0) {
                        len_min[i][j] = Math.min(len_min[i][j-1], len_min[p[i][j-1]][j-1]);
                        len_max[i][j] = Math.max(len_max[i][j-1], len_max[p[i][j-1]][j-1]);
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Pair res = lca(x, y);

            bw.write(res.min+" "+res.max);
            bw.newLine();
        }

        //bw.write("");
        //bw.newLine();

        bw.flush();
    }
}