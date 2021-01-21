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

    public static void combi(int[] data, int[] flag, int idx, int n, int r, int target) throws Exception {
        if (r == 0){
            print(data, flag);
            //print_flag(flag);
            return;
        }
        else if (target == n){
            return;
        }
        else {
            flag[idx] = target;
            combi(data, flag, idx+1, n, r-1, target+1);
            combi(data, flag, idx, n, r, target+1);
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

        combi(data, flag, 0, N, M, 0);

        bw.flush();
    }
}