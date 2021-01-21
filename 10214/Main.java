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

        int y=0, k=0;
        while(T-->0) {
            for(int i=0; i<9; i++) {
                String[] s = br.readLine().split(" ");
                int tmp_a = Integer.parseInt(s[0]);
                int tmp_b = Integer.parseInt(s[1]);
                if(tmp_a > tmp_b) {
                    y++;
                }
                else if(tmp_a < tmp_b) {
                    k++;
                }
            }
            if(y > k) {
                 bw.write("Yonsei\n");
            }
            else if(y < k) {
                bw.write("Korea\n");
            }
            else {
                bw.write("Draw\n");
            }
        }

        bw.flush();
    }
}