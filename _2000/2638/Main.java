import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

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
    static StringTokenizer st;
    final static int INF = 10000001;

    public static void bfs_for_list(int start_y, int start_x, int N, int M, int[][] map, int[][] visit) throws Exception {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start_y, start_x));
        visit[start_y][start_x] = 1;
        while(!q.isEmpty()) {
            Point target = q.remove();

            //bw.write(x+" ");

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
                if(map[ny][nx] == 0 && visit[ny][nx] == 0) { //not wall
                    q.add(new Point(ny, nx));
                    visit[ny][nx]++;
                }
                else if(map[ny][nx] == 1) {
                    visit[ny][nx]++;
                }
                else {
                    continue;
                }
            }
        }
    }

    static boolean chk_finish(int[][] map, int N, int M) {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j] >= 1) {
                    return false;
                }
            }
        }
        return true;
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
            for(int j=1; j<=M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
            }
        }

        int cnt = 0;
        while(!chk_finish(map, N, M)) {
            cnt++;
            bfs_for_list(1, 1, N, M, map, visit);
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    if(visit[i][j] >= 2) {
                        map[i][j] = 0;
                    }
                }
            }
            for(int i=1; i<=N; i++) {
                Arrays.fill(visit[i], 0);
            }
        }

        // for(int i=1; i<=N; i++) {
        //     for(int j=1; j<=M; j++) {
        //         bw.write(map[i][j]+"");
        //     }
        //     bw.newLine();
        // }

        bw.write(cnt+"");
        //bw.newLine();
        bw.flush();
    }
}