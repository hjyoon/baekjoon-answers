import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Point {
    int y;
    int x;
    int dis;
    int drill;
    Point(int y, int x, int dis, int drill) {
        this.y = y;
        this.x = x;
        this.dis = dis;
        this.drill = drill;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    final static int INF = 10000001;

    public static int bfs_for_list(int start_y, int start_x, int N, int M, int[][] map, int[][] visit) throws Exception {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int ans = INF;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start_y, start_x, 1, 0));
        visit[start_y][start_x] = 0;
        while(!q.isEmpty()) {
            Point target = q.remove();

            //bw.write(x+" ");
            if(target.y == N && target.x == M){
                ans = target.dis;
                break;
            }

            // for(int i=1; i<=num_vertex; i++) {
            //     if(graph[target][i] != 0 && visit[i] == false) {
            //         visit[i] = true;
            //         q.add(i);
            //     }
            // }

            for(int i=0; i<4; i++) {
                int ny = target.y + dy[i];
                int nx = target.x + dx[i];
                if(ny < 0 || nx < 0 || ny > N || nx > M) {
                    continue;
                }
                if(visit[ny][nx] <= target.drill) {
                    continue;
                }
                if(map[ny][nx] == 0) { //not wall
                    visit[ny][nx] = target.drill;
                    q.add(new Point(ny, nx, target.dis+1, target.drill));
                }
                else { // wall
                    if(target.drill < 1) {
                        visit[ny][nx] = target.drill + 1;
                        q.add(new Point(ny, nx, target.dis+1, target.drill+1));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        int[][] visit = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=1; j<=M; j++) {
                int tmp = s.charAt(j-1)-'0';
                if(tmp == 0) {
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = 1;
                }
                visit[i][j] = INF;
            }
        }

        int ans = bfs_for_list(1, 1, N, M, map, visit);

        if(ans == INF) {
            bw.write("-1");
        }
        else {
            bw.write(ans+"");
        }
        bw.newLine();
        bw.flush();
    }
}