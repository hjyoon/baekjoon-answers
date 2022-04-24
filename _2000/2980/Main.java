import java.util.*;
import java.io.*;
import java.math.*;

class MyData {
    public int D;
    public int R;
    public int G;

    MyData(int d, int r, int g) {
        D = d;
        R = r;
        G = g;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int L = Integer.parseInt(s[1]);

        Queue<MyData> qu = new LinkedList<>();
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            int d, r, g;
            d = Integer.parseInt(s[0]);
            r = Integer.parseInt(s[1]);
            g = Integer.parseInt(s[2]);
            qu.offer(new MyData(d, r, g));
        }
        qu.offer(new MyData(L, 0, 0));

        int res = 0;
        int pos = 0;
        while(true) {
            MyData tmp = qu.poll();

            res += (tmp.D-pos);
            pos = tmp.D;

            if(tmp.D == L) {
                break;
            }

            int mod = res%(tmp.R+tmp.G);
            if(mod < tmp.R) {
                res += (tmp.R-mod);
            }
            //bw.write(pos+" "+res+"\n");
        }

        bw.write(res+"");
        bw.flush();
    }
}