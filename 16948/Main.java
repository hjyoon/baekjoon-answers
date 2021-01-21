import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

class Point {
    int y;
    int x;
    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void bfs_for_array(int start_y, int start_x, int N, int[][] graph, boolean[][] visit) throws Exception {
        int[] dy = {-2, -2, 0, 0, 2, 2};
        int[] dx = {-1, 1, -2, 2, -1, 1};
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(start_y, start_x));
        visit[start_y][start_x] = true;
        while(!q.isEmpty()) {
            Point tmp = q.remove();

            //bw.write(x+" ");

            for(int i=0; i<6; i++) {
                
                if(tmp.y+dy[i] >= 0 && tmp.y+dy[i] <= N && tmp.x+dx[i] >= 0 && tmp.x+dx[i] <= N) {
                    if(visit[tmp.y+dy[i]][tmp.x+dx[i]] == false) {
                        visit[tmp.y+dy[i]][tmp.x+dx[i]] = true;
                        graph[tmp.y+dy[i]][tmp.x+dx[i]] = graph[tmp.y][tmp.x] + 1;
                        q.add(new Point(tmp.y+dy[i], tmp.x+dx[i]));
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N+1][N+1];
        boolean[][] visit = new boolean[N+1][N+1];

        String[] s = br.readLine().split(" ");
        int r1 = Integer.parseInt(s[0]);
        int c1 = Integer.parseInt(s[1]);
        int r2 = Integer.parseInt(s[2]);
        int c2 = Integer.parseInt(s[3]);

        bfs_for_array(r1, c1, N, graph, visit);

        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         bw.write(graph[i][j]+""); 
        //     }
        //     bw.write("\n"); 
        // }


        if(graph[r2][c2] == 0) {
            bw.write("-1");
        }
        else {
            bw.write(graph[r2][c2]+"");
        }
        bw.flush();
    }
}