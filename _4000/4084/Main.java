import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String ss = br.readLine();
            if(ss.equals("0 0 0 0")) {
                break;
            }
            String[] s = ss.split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int C = Integer.parseInt(s[2]);
            int D = Integer.parseInt(s[3]);

            int cnt = 0;
            while(true) {
                if(A == B && B == C && C == D) {
                    break;
                }
                int tmp_a = Math.abs(A-B);
                int tmp_b = Math.abs(B-C);
                int tmp_c = Math.abs(C-D);
                int tmp_d = Math.abs(D-A);
                A = tmp_a;
                B = tmp_b;
                C = tmp_c;
                D = tmp_d;
                cnt++;
            }

            bw.write(cnt+"\n");
        }

        bw.flush();
    }
}