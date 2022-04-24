import java.io.*;
import java.math.*;     
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //@SuppressWarnings({"unchecked"})
        ArrayList<Integer>[] a = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            a[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            a[u].add(v);
            a[v].add(u);
        }

        boolean[] check = new boolean[n+1];
        int[] parent = new int[n+1];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        check[1] = true;

        while(!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (check[y] == false) {
                    check[y] = true;
                    parent[y] = x;
                    q.add(y);
                }
            }
        }

        for(int i=2; i<=n; i++) {
            bw.write(parent[i]+"\n");
        }

        bw.flush();
    }
}