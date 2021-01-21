import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Node {
    int i;
    int w;
    Node(int i, int w) {
        this.i = i;
        this.w = w;
    }
}

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

        List<Node>[] a = new List[N+1];  // 0�� ���� ��� X
        for (int i=1; i<=N; i++) {
            a[i] = new ArrayList<>();
        }

        // Ʈ�� ����
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            a[x].add(new Node(y, w));
            a[y].add(new Node(x, w));
        }

        int[] depth = new int[N+1];
        boolean[] check = new boolean[N+1];
        int[] parent = new int[N+1];
        int[] parent_w = new int[N+1];
        //int start = 1;  // 1�� ���� root
        Node start = new Node(1, 0);

        // root ���� bfs�� Ž���ϱ� ���� queue
        Queue<Node> q = new LinkedList<>();
        check[start.i] = true;// �ش� �ε����� ����ȣ�� �ǹ��ϸ�, �ش� ����ȣ�� �湮���θ� ����.
        depth[start.i] = 0;   // �ش� �ε����� ����ȣ�� �ǹ��ϸ�, �ش� ����ȣ�� depth�� �����.
        parent[start.i] = 0;  // �ش� �ε����� ����ȣ�� �ǹ��ϸ�, �ش� ����ȣ�� �θ� ����ȣ�� �����.

        q.add(start);
        while(!q.isEmpty()) {
            Node x = q.remove();
            for (Node y : a[x.i]) {
                if (check[y.i] == false) {
                    depth[y.i] = depth[x.i] + 1;
                    check[y.i] = true;
                    parent[y.i] = x.i;
                    parent_w[y.i] = y.w;
                    q.add(y);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (depth[x] < depth[y]) {  // �׻� x����� depth�� ũ�Բ� swap
                int temp = x;
                x = y;
                y = temp;
            }

            int dist = 0;
            
            // �� ����� depth�� ���� ���ִ� �۾�
            while(depth[x] != depth[y]) {   // x���� y����� depth�� �ٸ��� x����� depth�� �Ѵܰ� ����. (�ش� ����� �θ���� ��)
                dist += parent_w[x];
                x = parent[x];
            }

            // ���� ������ ã�� ����
            while (x != y) {    // �� ��尡 ���� �ٸ��ٸ�, ������������ x���, y��� ���� depth�� �Ѵܰ� ����. (�ش� ����� �θ���� ��)
                dist += parent_w[x];
                dist += parent_w[y];
                x = parent[x];
                y = parent[y];
            }

            bw.write(dist+""); // x�� y�� �������� ������ ���� �ϳ��� ���
            bw.newLine();
        }

        //bw.write("");
        bw.newLine();

        bw.flush();
    }
}