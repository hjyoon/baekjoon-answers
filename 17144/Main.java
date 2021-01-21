import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static void diffuse_dust(int[][] map, int R, int C) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int[][] cal_map = new int[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                int cnt = 0;
                for(int k=0; k<4; k++) {
                    if(i+dy[k]>=0 && i+dy[k]<=R-1 && j+dx[k]>=0 && j+dx[k]<=C-1 && map[i+dy[k]][j+dx[k]]!=-1 && map[i][j]!=-1) {
                        cnt++;
                        cal_map[i+dy[k]][j+dx[k]] += map[i][j] / 5;
                    }
                }
                cal_map[i][j] -= (map[i][j]/5)*cnt;
            }
        }
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                map[i][j] += cal_map[i][j];
            }
        }
    }

    static void rotate_array(int[][] map, int up_y, int down_y, int R, int C) {
        for(int i=up_y-1; i>0; i--) {
            map[i][0] = map[i-1][0];
        }
        for(int i=0; i<C-1; i++) {
            map[0][i] = map[0][i+1];
        }
        for(int i=0; i<up_y; i++) {
            map[i][C-1] = map[i+1][C-1];
        }
        for(int i=C-1; i>1; i--) {
            map[up_y][i] = map[up_y][i-1];
        }
        map[up_y][1] = 0;

        for(int i=down_y+1; i<R-1; i++) {
            map[i][0] = map[i+1][0];
        }
        for(int i=0; i<C-1; i++) {
            map[R-1][i] = map[R-1][i+1];
        }
        for(int i=R-1; i>down_y; i--) {
            map[i][C-1] = map[i-1][C-1];
        }
        for(int i=C-1; i>1; i--) {
            map[down_y][i] = map[down_y][i-1];
        }
        map[down_y][1] = 0;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];

        int num_vertex = R*C;

        int up_y = -1;
        int down_y = -1;

        // input map data
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && up_y == -1 && down_y == -1) {
                    up_y = i;
                    down_y = i+1;
                }
            }
        }

        while(T-- > 0) {
            diffuse_dust(map, R, C);
            rotate_array(map, up_y, down_y, R, C);
        }

        int res = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] != -1) {
                    res += map[i][j];
                }
            }
        }

        /*for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                bw.write(map[i][j]+" ");
            }
            bw.newLine();
        }*/
    
        // print test
        // bw.write(up_y+" "+down_y);
        // bw.newLine();


        bw.write(res+"");
        bw.newLine();
        bw.flush();
    }
}