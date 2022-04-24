import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static long solve(int y, int x, int state, int N, int[][] a, long[][][] visit) throws Exception {
        long res = 0;
        if(y > N || x > N) {
            return res;
        }
        if(visit[y][x][state] != -1) {
            return visit[y][x][state];
        }
        if(a[y][x] == 1) {
            return res;
        }
        if(state == 2 && (a[y-1][x] != 0 || a[y][x-1] != 0)) {
            return res;
        }
        if(y == N && x == N) {
            res++;
            visit[y][x][state] = res;
            return visit[y][x][state];
        }
        if(state == 0) {
            long res1 = solve(y, x+1, 0, N, a, visit);
            long res2 = solve(y+1, x+1, 2, N, a, visit);
            visit[y][x][state] = res1 + res2;
            return visit[y][x][state];
        }
        else if(state == 1) {
            long res1 = solve(y+1, x, 1, N, a, visit);
            long res2 = solve(y+1, x+1, 2, N, a, visit);
            visit[y][x][state] = res1 + res2;
            return visit[y][x][state];
        }
        else if(state == 2) {
            long res1 = solve(y, x+1, 0, N, a, visit);
            long res2 = solve(y+1, x, 1, N, a, visit);
            long res3 = solve(y+1, x+1, 2, N, a, visit);
            visit[y][x][state] = res1 + res2 + res3;
            return visit[y][x][state];
        }
        return res;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] a = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                a[i][j] = tmp;
            }
        }

        long[][][] visit = new long[N+1][N+1][3];
        for(int i=0; i<N+1; i++) {
            for(int j=0; j<N+1; j++) {
                Arrays.fill(visit[i][j], -1);
            }
        }
        long res = solve(1, 2, 0, N, a, visit);

        bw.write(res+"");
        bw.newLine();
        
        bw.flush();
    }
}