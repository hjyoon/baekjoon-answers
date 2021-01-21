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
        int N = Integer.parseInt(s[0]);
        int W = Integer.parseInt(s[1]);
        int H = Integer.parseInt(s[2]);

        double max = Math.sqrt(W*W+H*H);

        for(int i=0; i<N; i++) {
            if(Integer.parseInt(br.readLine()) <= max) {
                bw.write("DA\n");
            }
            else {
                bw.write("NE\n");
            }
        }
        
        bw.flush();
    }
}