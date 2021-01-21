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

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            double sum = 0;
            int m = 0;
            for(int i=0; i<N; i++) {
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                double b = Double.parseDouble(s[1]);
                sum += a * b;
                m += a;
            }

            bw.write(String.format("%d %.1f\n", m, sum/m));
        }

        bw.flush();
    }
}