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

        int r = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        for(int l=3; ; l++) {
            if((r+b)%l != 0) {
                continue;
            }
            else {
                int w = (r+b)/l;
                if((l-2)*(w-2)==b) {
                    int max = Math.max(l, w);
                    int min = Math.min(l, w);
                    bw.write(max+" "+min+"\n");
                    bw.flush();
                    return;
                }
            }
        }
    }
}