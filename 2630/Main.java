import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static String s;
    static String[] sa;

    static int white = 0;
    static int blue = 0;

    public static int check(int arr[][], int N, int sy, int sx, int init) throws Exception {
        for(int i=sy; i<sy+N; i++) {
            for(int j=sx; j<sx+N; j++) {
                if(arr[i][j] != init) {
                    return -1;
                }
            }
        }
        return init;
    }

    public static void cal(int arr[][], int N, int sy, int sx) throws Exception {
        //bw.write("start "+"sy="+sy+" sx="+sx+" "+" N="+N+"\n");
        int init = arr[sy][sx];
        if(N == 1) {
            //bw.write("sy="+sy+" sx="+sx+" "+init+"\n");
            if(init == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int res = check(arr, N, sy, sx, init);
        if(res == 0) {
            white++;
            //bw.write(init+"\n");
            return;
        }
        else if(res == 1) {
            blue++;
            //bw.write(init+"\n");
            return;
        }
        else {
            cal(arr, N/2, sy, sx);
            cal(arr, N/2, sy, sx+N/2);
            cal(arr, N/2, sy+N/2, sx);
            cal(arr, N/2, sy+N/2, sx+N/2);
            return;
        }
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        //sa = s.split(" +");
        int N = Integer.parseInt(s);    // N(2^k), 1 <= k <= 7
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++) {
            s = br.readLine();
            sa = s.split(" +");
            for(int j=0; j<N; j++) {
                arr[i][j] = sa[j].charAt(0)-'0';
            }
        }

        // print test
        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         bw.write(arr[i][j]+"");
        //     }
        //     bw.newLine();
        // }

        cal(arr, N, 0, 0);
        bw.write(white+"\n"+blue);

        bw.flush();
    }
}