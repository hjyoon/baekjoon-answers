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

        for(int i=0; i<T; i++) {
            String[] s = br.readLine().split(" ");
            int tmp_a = Integer.parseInt(s[0]);
            int tmp_b = Integer.parseInt(s[1]);

            bw.write("You get "+tmp_a/tmp_b+" piece(s) and your dad gets "+tmp_a%tmp_b+" piece(s).\n");
        }

        bw.flush();
    }
}