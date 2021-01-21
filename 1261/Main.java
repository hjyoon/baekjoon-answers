import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Pair {
    int x, y;
    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] map = new int[Y][X];

        for(int i=0; i<Y; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            for(int j=0; j<X; j++) {
                map[i][j] = S.charAt(j)-'0';
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] d = new int[Y][X];

        Queue<Pair> q = new LinkedList<Pair>();
        Queue<Pair> next_queue = new LinkedList<Pair>();

        q.offer(new Pair(0, 0));
        for (int i=0; i<Y; i++) {
            for (int j=0; j<X; j++) {
                d[i][j] = -1;
            }
        }
        d[0][0] = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int y = p.y;
            int x = p.x;
            for (int k=0; k<4; k++) {
                int ny = y+dy[k];
                int nx = x+dx[k];
                if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
                    if (d[ny][nx] == -1) {
                        if (map[ny][nx] == 0) {
                            d[ny][nx] = d[y][x];
                            q.offer(new Pair(ny, nx));
                        }
                        else {
                            d[ny][nx] = d[y][x]+1;
                            next_queue.offer(new Pair(ny, nx));
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                q = next_queue;
                next_queue = new LinkedList<Pair>();
            }
        }

        for(int i=0; i<Y; i++) {
            for(int j=0; j<X; j++) {
                bw.write(d[i][j]+"");
            }
            bw.newLine();
        }

        bw.write(d[Y-1][X-1]+"");
        bw.newLine();

        bw.flush();
    }
}