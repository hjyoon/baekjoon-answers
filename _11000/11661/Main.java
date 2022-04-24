import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int gcd(int x, int y) {  // Greatest Common Divisor
        // 유클리드 호제법을 이용
        while(y != 0) {
            int r = x%y;
            x = y;
            y = r;
        }
        return x;
    }

    static int[] cal(int a, int b) {
        if (b == 0) {
            return new int[] {a, 1, 0};
        }

        int[] res = cal(b, a%b);

        int g = res[0];
        int x = res[1];
        int y = res[2];

        res[0] = g;
        res[1] = y;
        res[2] = x-(a/b)*y;

        return res;
    }

    static int f(int base, int t, int k, int low, int high, HashSet<Integer> hs) throws Exception {
        if(hs.contains(k)) {
            return 0;
        }
        else {
            hs.add(k);
        }

        int res = 0;
        bw.write(base+t*k+"\n");

        if(base+t*k >= low) {
            return 1 + f(base, t, k-1, low, high, hs);
        }
        if(base+t*k <= high) {
            return 1 + f(base, t, k+1, low, high, hs);
        }
        return 0;
    }

    static int find_pos() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X1 = Integer.parseInt(st.nextToken());
        int X2 = Integer.parseInt(st.nextToken());
        int Y1 = Integer.parseInt(st.nextToken());
        int Y2 = Integer.parseInt(st.nextToken());

        if(A == 0 && B == 0) {
            if(C == 0) {
                ; // 모든 해가 정답 (X2-X1+1) * (Y2-Y1+1)
            }
            else {
                ; // 해가 없음 (0)
            }
        }
        else if(A == 0 && B != 0) {
            ; // 모든 X가 해 (X2-X1+1)
        }
        else if(A != 0 && B == 0) {
            ; // 모든 Y가 해 (Y2-Y1+1)
        }
        else {
            int d = gcd(A, B);
            if(d % C != 0) {
                ; // 해가 없음 (0)
            }
            //int[] res = cal(A, B);
            //bw.write(res[0]+" "+res[1]*(C/d)+" "+res[2]*(C/d));
        }

        A = 324;
        B = 118;
        C = 8;
        X1 = -20;
        X2 = 50;
        Y1 = -20;
        Y2 = 50;

        int d = gcd(A, B);
        int[] res = cal(A, B);
        int x0 = res[1]*(C/d);
        int y0 = res[2]*(C/d);
        // x1 ≤ x0 + B'k ≤ x2
        // y1 ≤ y0 + A'k ≤ y2

        // while(x0+B*k >= X1 && x0+B*k <= X2) {

        // }

        // while(y0+A*k >= Y1 && y0+A*k <= Y2) {

        // }

        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        int cnt_x = f(x0, B, (X1+X2)/2, X1, X2, hs);
        bw.newLine();
        int cnt_y = f(y0, A, (Y1+Y2)/2, Y1, Y2, hs2);

        bw.write(cnt_x+" "+cnt_y);

        //bw.write(res[0]+" "+res[1]*(8/d)+" "+res[2]*(8/d));



        bw.newLine();
        bw.flush();
    }
}