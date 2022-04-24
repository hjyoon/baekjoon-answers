import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Point {
    public int x;
    public int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static Scanner sc;
    static String s;
    static String[] sa;
    final static int INF = 100000001;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        // 시작 위치 입력
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());

        // 끝 위치 입력
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 경유 마을 개수 입력
        int N = Integer.parseInt(st.nextToken());   // 0 <= N <= 4000
        N += 2;

        Point[] p = new Point[N+1];   // 경유마을갯수N + 시작위치 + 끝위치 + 1

        p[1] = new Point(sx, sy);   // 시작 위치 저장
        p[N] = new Point(dx, dy);   // 끝 위치 저장

        // 경유 마을 위치 입력
        for(int i=2; i<=N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            p[i] = new Point(x, y);
        }

        int[][] a = new int[N+1][N+1];  // 0번 도시 제외 , 1번 도시부터 시작
        int[] d = new int[N+1];
        boolean[] c = new boolean[N+1];

        // data init
        for (int i=1; i<=N; i++) {
            d[i] = INF;
            c[i] = false;
        }

        // eratosthenes
        int limit = 8485;
        boolean[] primeList = new boolean[limit+1];    // Math.sqrt(6000 * 6000 * 2) -> 8485;
        Arrays.fill(primeList, true);
        primeList[0] = false;
        primeList[1] = false;

        for(int i=2; (i*i)<=limit; i++){
            if(primeList[i]){
                for(int j = i*2; j<=limit; j+=i) {
                    primeList[j] = false;
                }
            }
        }

        // data init and input
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if(i == j) {
                    a[i][j] = 0;
                }
                else {
                    int distance = (int)Math.sqrt(Math.pow(p[i].x-p[j].x, 2) + Math.pow(p[i].y-p[j].y, 2));
                    if(primeList[distance]) {
                        a[i][j] = distance;
                    }
                    else {
                        a[i][j] = INF;
                    }
                }
            }
        }

        int start = 1;  // 시작 노드
        int end = N;    // 끝 노드
        
        d[start] = 0;

        for (int k=0; k<N-1; k++) {
            int min = INF+1;
            int min_idx = -1;
            for (int i=1; i<=N; i++) {
                if (c[i] == false && min > d[i]) {
                    min = d[i];
                    min_idx = i;
                }
            }
            c[min_idx] = true;
            for (int i=1; i<=N; i++) {
                if (d[i] > d[min_idx] + a[min_idx][i]) {
                    d[i] = d[min_idx] + a[min_idx][i];
                }
            }
        }

        if(d[end] == INF) {
            bw.write("-1\n");
        }
        else {
            bw.write(d[end]+"\n");
        }

        bw.flush();
    }
}