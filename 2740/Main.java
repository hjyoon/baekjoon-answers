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
        int N1 = Integer.parseInt(st.nextToken());
        int M1 = Integer.parseInt(st.nextToken());

        int[][] a = new int[N1][M1];
        for(int i=0; i<N1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M1; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int N2 = Integer.parseInt(st.nextToken());
        int M2 = Integer.parseInt(st.nextToken());

        int[][] b = new int[N2][M2];
        for(int i=0; i<N2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M2; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] res = new int[N1][M2];
        for(int i=0; i<N1; i++) {
            for(int j=0; j<M2; j++) {
                int sum = 0;
                for(int k=0; k<M1; k++) {
                    sum += a[i][k] * b[k][j];
                }
                res[i][j] = sum;
            }
        }

        for(int i=0; i<N1; i++) {
            for(int j=0; j<M2; j++) {
                bw.write(res[i][j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}