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
    static String s;
    static String[] sa;
    final static int INF = 10000001;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //s = br.readLine();
        //sa = br.readLine().split(" +");
        int T = Integer.parseInt(br.readLine());
        

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Point[] p = new Point[N+3];   // 편의점갯수N + 시작위치 + 끝위치 + 1

            // 시작 위치 입력 
            sa = br.readLine().split(" +");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);
            p[1] = new Point(x, y);

            // 편의점 위치 입력
            for(int i=2; i<=N+1; i++) {
                sa = br.readLine().split(" +");
                x = Integer.parseInt(sa[0]);
                y = Integer.parseInt(sa[1]);
                p[i] = new Point(x, y);
            }

            // 끝 위치 입력
            sa = br.readLine().split(" +");
            x = Integer.parseInt(sa[0]);
            y = Integer.parseInt(sa[1]);
            p[N+2] = new Point(x, y);


            int[][] d = new int[N+3][N+3];  // 0번 도시 제외 , 1번 도시부터 시작

            // data init and input
            for (int i=1; i<=N+2; i++) {
                for (int j=1; j<=N+2; j++) {
                    if(i == j) {
                        d[i][j] = 0;
                    }
                    else {
                        int distance = Math.abs(p[i].x-p[j].x) + Math.abs(p[i].y-p[j].y);
                        if(distance <= 1000) {
                            d[i][j] = 1;
                        }
                        else {
                            d[i][j] = INF;
                        }
                    }
                }
            }

            // data input
            // for(int i=0; i<E; i++) {
            //     sa = br.readLine().split(" +");
            //     int src = Integer.parseInt(sa[0]);
            //     int dst = Integer.parseInt(sa[1]);
            //     int cost = Integer.parseInt(sa[2]);
            //     if(d[src][dst] > cost) {
            //         d[src][dst] = cost;
            //     }
            // }

            // calc
            for (int k=1; k<=N+2; k++) {
                for (int i=1; i<=N+2; i++) {
                    for (int j=1; j<=N+2; j++) {
                        if (d[i][j] > d[i][k] + d[k][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                        }
                    }
                }
            }

            //print test
            // for (int i=1; i<=N+2; i++) {
            //     for (int j=1; j<=N+2; j++) {
            //         // if(d[i][j] == INF) {
            //         //     bw.write("-1 ");
            //         // }
            //         // else {
            //         //     bw.write(d[i][j]+" ");
            //         // }
            //         bw.write(d[i][j]+" ");
            //     }
            //     bw.write("\n");
            // }

            // 마무리 계산
            // int res = INF;
            // for(int i=1; i<=N+2; i++) {
            //     if(d[i][i] < res) {
            //         res = d[i][i];
            //     }
            // }

            if(d[1][N+2] == INF) {
                bw.write("sad\n");
            }
            else {
                bw.write("happy\n");
            }

        }

        bw.flush();
    }
}