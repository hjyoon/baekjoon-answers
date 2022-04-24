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
            String[] s = br.readLine().split(" ");
            double[] price = {350.34, 230.90, 190.55, 125.30, 180.90};
            int[] n = new int[5];
            for(int i=0; i<5; i++) {
                n[i] = Integer.parseInt(s[i]);
            }
            double sum = 0;
            for(int i=0; i<5; i++) {
                sum += price[i]*n[i];
            }
            String res = String.format("%.2f", sum);
            bw.write(String.format("$"+res+"\n"));
        }

        bw.flush();
    }
}