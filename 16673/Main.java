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

        String[] s = br.readLine().split(" ");
        int C = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int P = Integer.parseInt(s[2]);

        int sum = 0;
        for(int i=1; i<=C; i++) {
            sum += K*i + P*i*i;
        }

        bw.write(sum+"");
        bw.flush();
    }
}