import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static int dfs(ArrayList<Integer>[] computer, boolean[] visited, int v, int cnt) throws Exception {
        //System.out.println("호출된 수: "+v+" ,cnt: "+cnt);
        int res = 1;
        visited[v] = true;

        for(int e : computer[v]) {
            if(!visited[e]) {
                res = res + dfs(computer, visited, e, ++cnt);
            }
        }
        //bw.newLine();
        return res;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());

        ArrayList[] computer=new ArrayList[N+1];
        boolean[] visited=new boolean[N+1];

        for(int i=0;i<N+1;i++) {
            visited[i]=false;
        }

        for(int i=0;i<N+1;i++) {
            computer[i]=new ArrayList();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());

            computer[n1].add(n2);
            //computer[n2].add(n1);
        }

        bw.write(dfs(computer, visited, 1, cnt)-1+"");
        bw.newLine();

        bw.flush();
    }
}