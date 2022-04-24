import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int rest;

    static boolean checkMap(boolean[][] map, int Y, int X) {
        for(int i=0; i<Y; i++) {
            for(int j=0; j<X; j++) {
                if(map[i][j] == false) {
                    return false;
                }
            }
        }
        return true;
    }

    static int solve2(boolean[][] map, int Y, int X, int posY, int posX, int d) throws Exception {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        //bw.write(posY+" "+posX+"\n");
        if(posY <= -1 || posY >= Y || posX <= -1 || posX >= X || map[posY][posX]) {
            //bw.write("+1\n");
            return -1;
        }

        map[posY][posX] = true;
        rest--;
        
        if(rest == 0) {
            return 0;
        }

        int res = 0;
        while(true) {
            if(rest == 0) {
                break;
            }
            int tmp = solve2(map, Y, X, posY+dy[d], posX+dx[d], d);

            if(tmp == -1) {
                d = (d+1)%4;
                res++;
            }
            else {
                res += tmp;
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        rest = Y*X;

        boolean[][] map = new boolean[Y][X];
        int res = solve2(map, Y, X, 0, 0, 0);
        bw.write(res+"");
        bw.newLine();
        bw.flush();
    }
}