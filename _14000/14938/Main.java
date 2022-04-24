import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    final static int INF = 10000001;

    static void print_matrix(int[][] d, int N) throws Exception {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                bw.write(d[i][j]+" ");
            }
            bw.newLine();
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] item_num = new int[N+1];

        int[][] d = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i != j) {
                    d[i][j] = INF;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            item_num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            d[a][b] = w;
            d[b][a] = w;
        }

        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        int res = 0;
        for(int i=1; i<=N; i++) {
            int sum = 0;
            for(int j=1; j<=N; j++) {
                if(d[i][j] <= M) {
                    sum += item_num[j];
                }
            }
            res = Math.max(res, sum);
        }

        bw.write(res+"");
        bw.flush();
    }
}