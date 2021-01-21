import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];
        int[][] b = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] res = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                bw.write(res[i][j]+" ");
            }
            bw.newLine();
        }

        //bw.write(cnt+"");
        //bw.newLine();
        bw.flush();
    }
}