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

        int n = Integer.parseInt(br.readLine());

        int a=100, b=100;
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            int tmp_a = Integer.parseInt(s[0]);
            int tmp_b = Integer.parseInt(s[1]);
            if(tmp_a > tmp_b) {
                b -= tmp_a;
            }
            else if(tmp_a < tmp_b) {
                a -= tmp_b;
            }
        }

        bw.write(a+"\n"+b);

        bw.flush();
    }
}