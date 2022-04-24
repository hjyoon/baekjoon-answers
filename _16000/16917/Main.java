import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.time.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int res = 0;

        if(A+B > C*2 && X > 0 && Y > 0) {
            if(X < Y) {
                res += (C*2) * X;
                Y -= X;
                X = 0;
            }
            else if(X > Y) {
                res += (C*2) * Y;
                X -= Y;
                Y = 0;
            }
            else {
                res += (C*2) * X;
                X = 0;
                Y = 0;
            }
        }

        if(A > C*2 && X > 0) {
            res += (C*2) * X;
            X = 0;
        }
        else {
            res += A * X;
            X = 0;
        }

        if(B > C*2 && Y > 0) {
            res += (C*2) * Y;
            Y = 0;
        }
        else {
            res += B * Y;
            Y = 0;
        }


        bw.write(res+"");
        bw.newLine();
        bw.flush();
    }
}