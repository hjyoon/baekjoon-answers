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
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if((j==0) || (j==n-1) || (i==0) || (i==n-1)) {
                        bw.write("#");
                    }
                    else {
                        bw.write("J");
                    }
                }
                bw.write("\n");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}