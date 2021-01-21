import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    //static String s;
    static String[] sa;

    public static int check(int N, int M, int B, int[][] map, int mid) throws Exception {
        int time = 0;
        int need_push = 0;
        int need_pull = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] < mid) {
                    need_push += mid - map[i][j];
                }
                else if(map[i][j] > mid){
                    need_pull += map[i][j] - mid;
                }
            }
        }

        time += need_pull*2;
        B += need_pull;
        time += need_push;

        return time;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        sa = br.readLine().split(" ");

        // 0 <= 높이 <= 256, 최대N*M = 250,000
        int N = Integer.parseInt(sa[0]); //  1 <= 세로N <= 500
        int M = Integer.parseInt(sa[1]); //  1 <= 가로M <= 500
        int B = Integer.parseInt(sa[2]); //  0 <= 인벤B <= 6.4 x 10^7 = 64,000,000

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            sa = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }

        // print test
        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<M; j++) {
        //         bw.write(map[i][j] + " ");
        //     }
        //     bw.write("\n");
        // }

        int res = Integer.MAX_VALUE;
        int time = Integer.MAX_VALUE;
        int end = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                end += map[i][j];
            }
        }
        end += B;
        end = end / (N*M);

        for(int i=0; i<=end; i++) {
            int tmp_time = check(N, M, B, map, i);
            //bw.write(i+" tmp_time = "+tmp_time+" res="+res+"\n");
            if(tmp_time <= time) {
                time = tmp_time;
                res = i;
            }
        }

        bw.write(time+" "+res+"\n");
        bw.flush();
    }
}