import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new FileReader("../input.txt"));
        //br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = 0;
        if(A/K == 1 && B/K != 0) {
            res = B/K;
        }
        else if(A/K != 0 && B/K == 1) {
            res = A/K;
        }
        else if(A/K == 0 || B/K == 0) {
            res = 0;
        }
        else {
            res = A/K*2+B/K*2-4;
        }

        bw.write(res+"");
        bw.newLine();

        bw.flush();
    }
}