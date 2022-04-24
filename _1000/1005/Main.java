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
        int T = Integer.parseInt(st.nextToken());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] ind = new int[N+1];
            int[] time = new int[N+1];
            int[] res = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            @SuppressWarnings("unchecked")
            List<Integer>[] a = (List<Integer>[]) new List[N+1];
            for (int i=1; i<=N; i++) {
                a[i] = new ArrayList<Integer>();
            }

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                a[X].add(Y);
                ind[Y]++;
            }

            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());

            // process
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i=1; i<=N; i++) {
                if (ind[i] == 0) {  // indegree�� 0�� ������ ť�� �־ Ž���� ����
                    q.add(i);
                }
            }

            for (int k=0; k<N; k++) {
                int x = q.remove();
                for (int y : a[x]) {
                    ind[y]--;   // x��尡 ����Ű�� ����� indegree�� ���ҽ�Ŵ
                    res[y] = Math.max(res[y], res[x]+time[x]);
                    if (ind[y] == 0) {  // x��尡 ����Ű�� ����� indegree�� 0�̸� �� ��带 ť�� ����
                        q.add(y);
                    }
                }
            }
            bw.write(res[W]+time[W]+"");
            bw.newLine();
        }

        bw.flush();
    }
}