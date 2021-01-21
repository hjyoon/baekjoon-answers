import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void print(int[] data, int[] flag) throws Exception {
        for(int i=0; i<flag.length; i++) {
            bw.write(data[flag[i]]+" ");
        }
        bw.newLine();
    }

    public static void print(int[] data, int[] flag, int r) throws Exception {
        for(int i=0; i<r; i++) {
            bw.write(data[flag[i]]+" ");
        }
        bw.newLine();
    }

    public static void perm_overlab(int[] data, int[] flag, int depth, int n, int r) throws Exception {
        if (depth == r) {
            print(data, flag, r);
            //print_flag(flag);
            return;
        }
        for (int i=0; i<n; i++) {
            flag[depth] = i;
            perm_overlab(data, flag, depth+1, n, r);
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        for(int i=0; i<N; i++) {
            data[i] = i+1;
        }

        int[] flag = new int[M];
        for(int i=0; i<M; i++) {
            flag[i] = i;
        }

        perm_overlab(data, flag, 0, N, M);

        bw.flush();
    }
}