import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] ind = new int[N+1];
        int[] time = new int[N+1];
        int[] res = new int[N+1];

        @SuppressWarnings("unchecked")
        List<Integer>[] a = (List<Integer>[]) new List[N+1];
        for (int i=1; i<=N; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) {
                    break;
                }
                a[to].add(i);
                ind[i]++;
            }
        }

        // process
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i=1; i<=N; i++) {
            if (ind[i] == 0) {  // indegree가 0인 노드부터 큐에 넣어서 탐색을 시작
                q.add(i);
            }
        }

        for (int k=0; k<N; k++) {
            int x = q.remove();
            for (int y : a[x]) {
                ind[y]--;   // x노드가 가리키는 노드의 indegree를 감소시킴
                res[y] = Math.max(res[y], res[x]+time[x]);
                if (ind[y] == 0) {  // x노드가 가리키는 노드의 indegree가 0이면 그 노드를 큐에 넣음
                    q.add(y);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            res[i] += time[i];
            bw.write(res[i]+" ");
            bw.newLine();
        }

        bw.flush();
    }
}