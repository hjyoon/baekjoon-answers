import java.io.*;
import java.math.*;     
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static void bomb_O(int R, int C, int i, int j, char[][] map) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {-1, 1, 0, 0};
        map[i][j] = 'X';
        for(int k=0; k<4; k++) {
            int tmpy = i + dy[k];
            int tmpx = j + dx[k];
            if(tmpy >= 0 && tmpy <= R-1 && tmpx >= 0 && tmpx <= C-1) {
                if(map[tmpy][tmpx] == 'S') {
                    map[tmpy][tmpx] = 'X';
                }
            }
        }
    }

    static void bomb_S(int R, int C, int i, int j, char[][] map) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {-1, 1, 0, 0};
        map[i][j] = 'X';
        for(int k=0; k<4; k++) {
            int tmpy = i + dy[k];
            int tmpx = j + dx[k];
            if(tmpy >= 0 && tmpy <= R-1 && tmpx >= 0 && tmpx <= C-1) {
                if(map[tmpy][tmpx] == 'O') {
                    map[tmpy][tmpx] = 'X';
                }
            }
        }
    }

    static void X_to_DOT(int R, int C, char[][] map) {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == 'X') {
                    map[i][j] = '.';
                }
            }
        }
    }

    static void set_bomb_S(int R, int C, char[][] map) {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == '.') {
                    map[i][j] = 'S';
                }
            }
        }
    }

    static void set_bomb_O(int R, int C, char[][] map) {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == '.') {
                    map[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int R = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        int N = Integer.parseInt(s[2]);

        char[][] map = new char[R][C];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int t = 0;
        while(true) {
            X_to_DOT(R, C, map);
            t++;

            if(t == N) break;
            set_bomb_S(R, C, map);
            t++;

            if(t == N) break;
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j] == 'O') {
                        bomb_O(R, C, i, j, map);
                    }
                }
            }
            X_to_DOT(R, C, map);
            t++;

            if(t == N) break;
            set_bomb_O(R, C, map);
            t++;

            if(t == N) break;
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j] == 'S') {
                        bomb_S(R, C, i, j, map);
                    }
                }
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == 'S') {
                    bw.write("O");
                }
                else {
                    bw.write(map[i][j]+"");
                }
            }
            bw.write("\n");
        }

        bw.flush();
    }
}