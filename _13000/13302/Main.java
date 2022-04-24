import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        boolean[] check = new boolean[N+1];
        if(M != 0) {
            s = br.readLine().split(" ");
            for(String ss : s) {
                int i = Integer.parseInt(ss);
                check[i] = true;
            }
        }

        int start = 0;
        for(int i=1; i<N+1; i++) {
            if(check[i] == false) {
                start = i;
                break;
            }
        }

        if(start == 0) {
            bw.write(0+"");
            bw.flush();
            return;
        }


        //int ma = (N/5)*2+5;
        int[][] dp = new int[N+1][N+1];

        for(int i=start; i<N+1; i++) {
            for(int j=0; j<N+1; j++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                if(check[i] == true) {
                    if(dp[i-1][j] != 0) {
                        tmp.add(dp[i-1][j]);
                    }
                }
                if(i-1 >= start-1 && j+3 < N+1) {
                    if(dp[i-1][j+3] != 0) {
                        tmp.add(dp[i-1][j+3]);
                    }
                }
                if(i-1 >= start-1) {
                    if(i-1 == start-1 && j == 0) {
                        tmp.add(dp[i-1][j]+10);
                    }
                    else if(dp[i-1][j] != 0) {
                        tmp.add(dp[i-1][j]+10);
                    }
                }
                if(i-3 >= start-1 && j-1 >= 0) {
                    if(i-3 == start-1 && j-1 == 0) {
                        tmp.add(dp[i-3][j-1]+25);
                    }
                    else if(dp[i-3][j-1] != 0) {
                        tmp.add(dp[i-3][j-1]+25);
                    }
                }
                if(i-5 >= start-1 && j-2 >= 0) {
                    if(i-5 == start-1 && j-2 == 0) {
                        tmp.add(dp[i-5][j-2]+37);
                    }
                    if(dp[i-5][j-2] != 0) {
                        tmp.add(dp[i-5][j-2]+37);
                    }
                }
                if(tmp.isEmpty()) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = Collections.min(tmp);
                }
            }
        }

        // for(int i=0; i<N+1; i++) {
        //     bw.write(String.format("%2d\t", i));
        //     for(int j=0; j<(N+1)/2; j++) {
        //         bw.write(String.format("%3d ", dp[i][j]));
        //     }
        //     bw.write("\n");
        // }

        int min = dp[N][0];
        for(int i=1; i<N+1; i++) {
            if(dp[N][i] == 0) {
                break;
            }
            if(min > dp[N][i]) {
                min = dp[N][i];
            }
        }

        bw.write(min*1000+"");
        bw.flush();
    }
}