import java.io.*;
import java.math.*;     
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static void print(int[][] dp, int N) throws Exception {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                bw.write(dp[i][j]+" ");
            }
            bw.write("\n");
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // for(int i : arr) {
        //     bw.write(i+" ");
        // }

        for(int i=1; i<=N; i++) {
            dp[i][i] = 4;
        }

        int i=0, j=0;
        for(int ii=1; ii<=N; ii++) {
            for(int jj=ii+1; jj<=N; jj++) {
                i = jj-ii;
                j = jj;

                if(arr[j] - arr[i] <= 4) {
                    dp[i][j] = Math.min(dp[i][j-1]-1, dp[i+1][j]);
                }
                else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]);
                }
            }
        }


        //print(dp, N);

        bw.write(dp[1][N]+"");
        bw.flush();
    }
}