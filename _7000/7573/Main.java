import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

class Net {
    int h;
    int w;
    Net(int h, int w) {
        this.h = h;
        this.w = w;
    }
}

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

    static int cal_net_form(int h, int w, int sy, int sx, int n, boolean[][] map) throws Exception {
        int res = 0;
        for(int i=sy; i<=sy+h; i++) {
            for(int j=sx; j<=sx+w; j++) {
                if(sy == 4 && sx == 4) {
                }
                if(i<1 || i>n || j<1 || j>n) {
                    continue;
                }
                if(map[i][j] == true) {
                    res++;
                }
            }
        }
        return res;
    }

    static int cal_net(int y, int x, int h, int w, int n, boolean[][] map) throws Exception {
        int res = 0;
        for(int i=y-h+1; i<=y; i++) {
            for(int j=x-w+1; j<=x; j++) {
                if(i<1 || i>n || j<1 || j>n) {
                    continue;
                }
                res = Math.max(res, cal_net_form(h, w, i, j, n, map));
            }
        }
        return res;
    }

    static int check_point(int y, int x, int n, boolean[][] map, ArrayList<Net> al_net) throws Exception {
        int res = 0;
        for(Net tmp : al_net) {
            res = Math.max(res, cal_net(y, x, tmp.h, tmp.w, n, map));
        }
        return res;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);
        int M = Integer.parseInt(s[2]);

        boolean[][] map = new boolean[N+1][N+1];
        ArrayList<Point> al_point = new ArrayList<>();
        for(int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int y = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            map[y][x] = true;
            al_point.add(new Point(y, x));
        }

        ArrayList<Net> al_net = new ArrayList<>();
        for(int i=1; i<=L/2-1; i++) {
            al_net.add(new Net(i, L/2-1-(i-1)));
            //bw.write(i+" "+(L/2-1-(i-1))+"\n");
        }

        int res = 0;
        for(Point tmp : al_point) {
            res = Math.max(res, check_point(tmp.y, tmp.x, N, map, al_net));
        }
        bw.write(res+"");
        bw.flush();
    }
}