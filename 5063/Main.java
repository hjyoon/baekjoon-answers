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

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            if(r > e-c) {
                bw.write("do not advertise\n");
            }
            else if(r < e-c) {
                bw.write("advertise\n");
            }
            else {
                bw.write("does not matter\n");
            }
        }

        bw.flush();
    }
}